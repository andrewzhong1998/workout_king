package ninja.workout_king.app.connection;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Util {
    public static Date getDate(){
        java.util.Date date=new java.util.Date();
        java.sql.Date sqlDate=new java.sql.Date(date.getTime());
        return sqlDate;
    }
    public static String getTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date date = new java.util.Date();
        return sdf.format(date);
    }
    public static void main(String[] args){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date date = new java.util.Date();
        System.out.println(sdf.format(date));
    }
}
