package com.iamvickyav.springbootmvcjsp.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    public static Connection getConnection(){
        Connection conn = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/workout_king";
            String username="workout_king";
            String password="comp426";
            conn = DriverManager.getConnection(url,username,password);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return conn;
    }
}
