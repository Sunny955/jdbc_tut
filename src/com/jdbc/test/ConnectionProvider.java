package com.jdbc.test;

import java.sql.*;

public class ConnectionProvider {
    private static Connection con;

    public static Connection getConnection(String db_name){

       try{
           if(con == null){
               Class.forName("com.mysql.jdbc.Driver");

               con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+db_name,"root","");

           }
       }catch (Exception e){
           e.printStackTrace();
       }

        return  con;
    }
}