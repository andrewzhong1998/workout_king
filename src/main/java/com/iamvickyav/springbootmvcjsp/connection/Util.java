package com.iamvickyav.springbootmvcjsp.connection;

import java.sql.Date;

public class Util {
    public static Date getDate(){
        java.util.Date date=new java.util.Date();
        java.sql.Date sqlDate=new java.sql.Date(date.getTime());
        return sqlDate;
    }

    public static void main(String[] args){
        System.out.println(Util.getDate().toString());
    }
}
