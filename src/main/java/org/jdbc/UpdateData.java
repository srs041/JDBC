package org.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateData {

    public static void main(String[] args) {

        try {
            Connection con = ConnectionProvider.getConnetion();
            if (con.isClosed()) {
                System.out.println("Connection Closed");
            } else {
                System.out.println("Connection opened");
                String updateque = "update Employee set name=?,city=?,salary=? where id=?";
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Enter Name :");
                String name = br.readLine();
                System.out.println("Enter City :");
                String city = br.readLine();
                System.out.println("Enter Salary :");
                float salary = Float.parseFloat(br.readLine());
                System.out.println("Enter ID to be updated  :");
                int id = Integer.parseInt(br.readLine());
                PreparedStatement upstmt = con.prepareStatement(updateque);
                upstmt.setString(1, name);
                upstmt.setString(2, city);
                upstmt.setFloat(3, salary);
                upstmt.setInt(4, id);
                upstmt.executeUpdate();
                System.out.println("Data updated ");
            }

            con.close();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
