package com.iamvickyav.springbootmvcjsp.models;

import com.iamvickyav.springbootmvcjsp.connection.DB;
import com.iamvickyav.springbootmvcjsp.connection.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Intake {
    private int iid;
    private Date date;
    private List<Diet> diets;
    private double calories;
    private double fat;
    private double protein;
    private double carbohydrate;
    private String description;

    public int getIid() {
        return iid;
    }
    public void setIid(int iid) {
        this.iid = iid;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public List<Diet> getDiets() {
        return diets;
    }
    public void setDiets(List<Diet> diets) {
        this.diets = diets;
    }
    public double getCalories() {
        return calories;
    }
    public void setCalories(double calories) {
        this.calories = calories;
    }
    public double getFat() {
        return fat;
    }
    public void setFat(double fat) {
        this.fat = fat;
    }
    public double getProtein() {
        return protein;
    }
    public void setProtein(double protein) {
        this.protein = protein;
    }
    public double getCarbohydrate() {
        return carbohydrate;
    }
    public void setCarbohydrate(double carbohydrate) {
        this.carbohydrate = carbohydrate;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public static boolean insertIntake(int uid, double fat, double carbohydrate, double protein, double calories, String description, List<Diet> diets){
        Connection conn = DB.getConnection();
        try{
            String sql = "INSERT INTO Intake (uid,fat,carbohydrate,protein,calories,description,date) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1,uid);
            ps.setDouble(2,fat);
            ps.setDouble(3,carbohydrate);
            ps.setDouble(4,protein);
            ps.setDouble(5,calories);
            ps.setString(6, description);
            ps.setDate(7, Util.getDate());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            int iid = rs.next() ? rs.getInt(1) : 0;
            rs.close();
            for(Diet d:diets){
                sql = "INSERT INTO Diet (food,amount,unit,iid) VALUES(?,?,?,?)";
                ps = conn.prepareStatement(sql);
                ps.setString(1,d.getFood());
                ps.setDouble(2,d.getAmount());
                ps.setString(3,d.getUnit());
                ps.setInt(4,iid);
                ps.executeUpdate();
            }
            ps.close();
            conn.close();
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public static List<Intake> getUserIntakes(int uid){
        Connection conn = DB.getConnection();
        List<Intake> intakes = new LinkedList<Intake>();
        try{
            String sql = "SELECT D.did,D.food,D.amount,D.unit,I.iid,I.fat,I.carbohydrate,I.protein,I.calories,I.description,I.date,I.uid" +
                    " FROM Diet D, Intake I" +
                    " WHERE D.iid=I.iid AND I.uid=" + uid +
                    " ORDER BY I.iid DESC";
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();

            Intake intake = null;
            int iid = -1;
            while(rs.next()){
                if(rs.getInt("iid")!=iid){
                    if(intake!=null) intakes.add(intake);
                    iid = rs.getInt("iid");
                    intake = new Intake();
                    intake.setIid(iid);
                    intake.setCalories(rs.getDouble("calories"));
                    intake.setCarbohydrate(rs.getDouble("carbohydrate"));
                    intake.setFat(rs.getDouble("fat"));
                    intake.setProtein(rs.getDouble("protein"));
                    intake.setDate(rs.getDate("date"));
                    intake.setDescription(rs.getString("description"));
                    intake.diets = new LinkedList<>();
                }
                Diet d = new Diet();
                d.setFood(rs.getString("food"));
                d.setAmount(rs.getDouble("amount"));
                d.setUnit(rs.getString("unit"));
                intake.diets.add(d);
            }
            if(intake!=null) intakes.add(intake);
            rs.close();
            ps.close();
            conn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return intakes;
    }

    public static boolean deleteIntake(int iid){
        Connection conn = DB.getConnection();
        try{
            String sql = "DELETE FROM Intake WHERE iid="+iid;
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args){
        //Intake.deleteIntake(3);

        //Intake.getUserIntakes(1);

        //System.out.println(PreparedStatement.RETURN_GENERATED_KEYS);
        Diet d1 = new Diet();
        d1.setFood("apple");
        d1.setAmount(1);
        d1.setUnit("kg");

        Diet d2 = new Diet();
        d2.setFood("orange");
        d2.setAmount(2);
        d2.setUnit("kg");

        List<Diet> diets = new LinkedList<Diet>();
        diets.add(d1);
        diets.add(d2);

        Intake.insertIntake(1,1,1,1,1,"dinner",diets);
    }
}
