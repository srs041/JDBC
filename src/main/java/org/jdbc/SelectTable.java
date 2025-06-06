package org.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectTable {
    public static void main(String[] args) {

        try {
            Connection con = ConnectionProvider.getConnetion();
            if (con.isClosed()) {
                System.out.println("Connection Closed");
            } else {
                System.out.println("Connection opened");
                String selectquery = "select * from Employee";
                Statement selecttablestmt = con.createStatement();
                ResultSet rs=selecttablestmt.executeQuery(selectquery);


                while(rs.next()){
                    int id=rs.getInt(1);
                    String name=rs.getString(2);
                    String city=rs.getString(3);
                    float salary=rs.getFloat(4);

                    System.out.println("Employee : " + id +" : "+name+" : "+city+" : "+salary);
                }


            }
            con.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}