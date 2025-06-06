package org.jdbc;

import java.sql.Connection;
import java.sql.Statement;

public class CreateTable {
    public static void main(String[] args) {

        try {
            Connection con = ConnectionProvider.getConnetion();
            if (con.isClosed()) {
                System.out.println("Connection Closed");
            } else {
                System.out.println("Connection opened");
                String createtablequery = "create table Employee(id int(10) primary key auto_increment,name varchar(30) not null,city varchar(30),salary float(10))";
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