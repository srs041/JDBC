package org.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

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
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Enter Name : ");
                String name = br.readLine();
                System.out.println("Enter City : ");
                String city = br.readLine();
                System.out.println("Enter Salary : ");
                String ssalary = br.readLine();
                int salary = Integer.parseInt(ssalary);
                insertstmt.setString(1, name);
                insertstmt.setString(2, city);
                insertstmt.setInt(3, salary);
                insertstmt.executeUpdate();
                System.out.println("Data Inserted");
            }
            con.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}