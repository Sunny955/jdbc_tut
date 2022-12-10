package com.jdbc.test;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
public class jdbc2 {
    public static void main(String[] args) {
        try{
            // Creating connection
            Connection c = ConnectionProvider.getConnection("jdbc_test");

            // Query
            String q = "insert into images(pic) values(?)"; // Dynamic query
            PreparedStatement pstmt = c.prepareStatement(q);

            // Creating dialog box for choosing images
            JFileChooser jfc = new JFileChooser();
            jfc.showOpenDialog(null);

            File file = jfc.getSelectedFile();

            FileInputStream fis = new FileInputStream(file);

            // Processing file
            pstmt.setBinaryStream(1,fis,fis.available());

            pstmt.executeUpdate();

//            System.out.println("Data inserted successfully!!!");
            JOptionPane.showMessageDialog(null,"Success");

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}