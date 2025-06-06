package org.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class InsertData {
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
                //create query
                String insertquery = "insert into Employee(name,city,salary) values (?,?,?)";
                //get PreparedStatement object
                PreparedStatement insertstmt = con.prepareStatement(insertquery);
                //set dynamic values
                insertstmt.setString(1, "Seetal");
                insertstmt.setString(2, "Cuttack");
                insertstmt.setInt(3, 80000);
                insertstmt.executeUpdate();
                System.out.println("Data Inserted");

            }

            con.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}