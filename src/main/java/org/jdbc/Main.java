package org.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
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
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}