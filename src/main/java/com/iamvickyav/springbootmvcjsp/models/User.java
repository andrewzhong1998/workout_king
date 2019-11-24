package com.iamvickyav.springbootmvcjsp.models;

import com.iamvickyav.springbootmvcjsp.connection.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class User {
    private int uid;
    private String email;
    private String name;
    private String gender;
    private double height;
    private double weight;
    private double target_weight;

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

    public static User getUserById(int uid){
        Connection conn = DB.getConnection();
        User user = null;
        String sql="select * from User where uid="+uid;
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                user = new User();
                user.setUid(rs.getInt("uid"));
                user.setEmail(rs.getString("email"));
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public static User getUserByEmail(String email){
        Connection conn = DB.getConnection();
        User user = null;
        String sql="select * from User where email=\""+email+"\"";
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                user = new User();
                user.setUid(rs.getInt("uid"));
                user.setEmail(rs.getString("email"));
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public static boolean createUser(String email, String password){
        Connection conn = DB.getConnection();
        try{
            String sql="insert into User (email,password) values(?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
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

    public static boolean updateUserById(int uid, String name, double height, double target_weight, String gender) {
        Connection conn = DB.getConnection();
        try{
            String sql="update User set name=?, height=?, target_weight=?, gender=? where uid="+uid;
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,name);
            ps.setDouble(2,height);
            ps.setDouble(3,target_weight);
            ps.setString(4,gender);
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
        User.updateUserById(1,"Andrew Zhong",6,150,"Male");
    }
}
