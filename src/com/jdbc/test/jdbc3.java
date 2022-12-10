package com.jdbc.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
public class jdbc3 {
    public static void main(String[] args){
        try{
            // Creating connection
            Connection con = ConnectionProvider.getConnection("employees");

            // SQL Query
            String q = "update titles set to_date = ? where emp_no = ?";

            // Taking input from user
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter to_date.....");

            String to_date = br.readLine();

            System.out.println("Enter employee number....");

            int emp_no = Integer.parseInt(br.readLine());

            // Making statements
            PreparedStatement pstmt = con.prepareStatement(q);

            pstmt.setString(1,to_date);
            pstmt.setInt(2,emp_no);

            pstmt.executeUpdate();
            System.out.println("Done!!!");

            // Connection close
            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}