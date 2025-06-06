package org.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {

    private static Connection con;

    public static Connection getConnetion(){
        if(con==null){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root","Csgo1234@");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        return con;
    }
}
