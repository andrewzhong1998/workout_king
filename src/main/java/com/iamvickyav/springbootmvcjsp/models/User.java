package com.iamvickyav.springbootmvcjsp.models;

import com.iamvickyav.springbootmvcjsp.connection.MS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class User {
    private int uid;
    private String email;
    private String name;
    private String gender;
    private double height;
    private double weight;
    private double target_weight;
    private String motto;
    private List<DayIntake> intakes;

    public double getHeight() { return height; }
    public void setHeight(double height) { this.height = height; }
    public int getUid() {
        return uid;
    }
    public void setUid(int uid) {
        this.uid = uid;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public double getTarget_weight() {
        return target_weight;
    }
    public void setTarget_weight(double target_weight) {
        this.target_weight = target_weight;
    }
    public String getMotto() {
        return motto;
    }
    public void setMotto(String motto) {
        this.motto = motto;
    }
    public List<DayIntake> getIntakes() {
        return intakes;
    }
    public void setIntakes(List<Intake> intakes) {
        List<DayIntake> day_intakes = new LinkedList<>();
        DayIntake day_intake = null;
        Date date = null;
        for(Intake i:intakes){
            if(date==null||!i.getDate().equals(date)){
                if(day_intake!=null) day_intakes.add(day_intake);
                date = i.getDate();
                day_intake = new DayIntake();
                day_intake.setDate(date);
                //day_intake.intakes = new LinkedList<>();
            }
            day_intake.intakes.add(i);
            day_intake.fat += i.getFat();
            day_intake.calories += i.getCalories();
            day_intake.carbohydrate += i.getCarbohydrate();
            day_intake.protein += i.getProtein();
        }
        if(day_intake!=null) day_intakes.add(day_intake);
        this.intakes = day_intakes;
        //this.today = day_intakes.isEmpty()||!day_intakes.get(0).getDate().equals(new Date()) ? new DayIntake() : day_intakes.get(0);
    }

    public static int userExist(String email,String password){
        Connection conn = MS.getConnection();
        int uid = -1;
        try {
            String sql="select uid from User where email=\""+email+"\" and password=\""+password+"\"";
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                uid = rs.getInt("uid");
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return uid;
    }

    public static User getUserById(int uid){
        Connection conn = MS.getConnection();
        User user = null;
        try {
            String sql="select * from User where uid="+uid;
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                user = new User();
                user.setUid(rs.getInt("uid"));
                user.setEmail(rs.getString("email"));
                user.setName(rs.getString("name"));
                user.setHeight(rs.getDouble("height"));
                user.setTarget_weight(rs.getDouble("target_weight"));
                user.setGender(rs.getString("gender"));
                user.setMotto(rs.getString("motto"));
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        user.setIntakes(Intake.getUserIntakes(uid));
        return user;
    }

    public static User getUserByEmailAndPassword(String email,String password){
        Connection conn = MS.getConnection();
        try {
            String sql="select uid from User where email=\""+email+"\" and password=\""+password+"\"";
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                int uid =rs.getInt("uid");
                rs.close();
                ps.close();
                conn.close();
                return getUserById(uid);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean createUser(String email,String password,String name,double height,double target_weight,String gender,String motto){
        Connection conn = MS.getConnection();
        try{
            String sql="insert into User (email,password,name,height,target_weight,gender,motto) values(?,?,?,?,?,?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            ps.setString(3, name);
            ps.setDouble(4, height);
            ps.setDouble(5, target_weight);
            ps.setString(6, gender);
            ps.setString(7, motto);;
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

    public static boolean updateUserByEmailAndPassword(String email, String password, String name, double height, double target_weight, String gender, String motto) {
        Connection conn = MS.getConnection();
        try{
            String sql="update User set name=?, height=?, target_weight=?, gender=?, motto=? where email=\""+email+"\" and password=\""+password+"\"";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,name);
            ps.setDouble(2,height);
            ps.setDouble(3,target_weight);
            ps.setString(4,gender);
            ps.setString(5,motto);
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
        //System.out.println(User.userExist("andrewzhong1998@outlook.com","123457890"));
        User.createUser("a@a.com","123123123","a z",1,1,"Male","AAA");
    }
}
