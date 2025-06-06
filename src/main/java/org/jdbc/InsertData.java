package org.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertData {
    public static void main(String[] args) {

        try {
            Connection con = ConnectionProvider.getConnetion();
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
                float salary = Float.parseFloat(ssalary);
                insertstmt.setString(1, name);
                insertstmt.setString(2, city);
                insertstmt.setFloat(3, salary);
                insertstmt.executeUpdate();
                System.out.println("Data Inserted");
            }
            con.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}