package com.jdbc.test;

import java.sql.*;
public class jdbc1 {
    public static void main(String[] args) {
        try{
            // Creating connection
            Connection con = ConnectionProvider.getConnection("employees");

            // SQL query
            String q = "select * from employees limit 50";

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(q);

            // Process the data
            while(rs.next()) {
                int emp_no = rs.getInt("emp_no");
                String first_name = rs.getString(3);
                String last_name = rs.getString(4);

                System.out.println(emp_no+" : "+first_name+" : "+last_name);
            }

            // Closing connection
            con.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}