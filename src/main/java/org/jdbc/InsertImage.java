package org.jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertImage {
    public static void main(String[] args) {

        //This code is for  06th june branch
        String url = "jdbc:mysql://localhost:3306/employeedb";
        String username = "root";
        String password = "Csgo1234@";
        try {
            //load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Create connection
            Connection con = DriverManager.getConnection(url, username, password);
            if (con.isClosed()) {
                System.out.println("Connection Closed");
            } else {
                System.out.println("Connection opened");

                String picquery="insert into pictures(pic) values(?)";

                PreparedStatement picstmt=con.prepareStatement(picquery);
                //Give your path where you have the image
                FileInputStream fis=new FileInputStream("C:\\Users\\Seetal\\IdeaProjects\\JDBC\\src\\main\\resources\\frog.jpg");
                picstmt.setBinaryStream(1,fis,fis.available());


                picstmt.executeUpdate();

                System.out.println("Image Inserted");
            }
            con.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}