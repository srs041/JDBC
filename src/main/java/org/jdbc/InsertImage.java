package org.jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertImage {
    public static void main(String[] args) {

        try {
            Connection con = ConnectionProvider.getConnetion();
            if (con.isClosed()) {
                System.out.println("Connection Closed");
            } else {
                System.out.println("Connection opened");

                String picquery = "insert into pictures(pic) values(?)";

                PreparedStatement picstmt = con.prepareStatement(picquery);
                //Give your path where you have the image
                FileInputStream fis = new FileInputStream("C:\\Users\\Seetal\\IdeaProjects\\JDBC\\src\\main\\resources\\eye.jpg");
                picstmt.setBinaryStream(1, fis, fis.available());

                picstmt.executeUpdate();

                System.out.println("Image Inserted");
            }
            con.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}