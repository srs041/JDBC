package org.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable {
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

                String createtablequery = "create table Employee(id int(10) primary key auto_increment,name varchar(30) not null,city varchar(30),salary int(10))";

                Statement createtablestmt = con.createStatement();
                createtablestmt.executeUpdate(createtablequery);

                System.out.println("Table Created");

            }

            con.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}