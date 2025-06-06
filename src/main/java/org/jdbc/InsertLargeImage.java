package org.jdbc;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertLargeImage {
    public static void main(String[] args) {

        try {
            Connection con = ConnectionProvider.getConnetion();
            if (con.isClosed()) {
                System.out.println("Connection Closed");
            } else {
                System.out.println("Connection opened");

                String picquery = "insert into pictures(pic) values(?)";

                PreparedStatement picstmt = con.prepareStatement(picquery);
                //Choose a file
                JFileChooser jfc=new JFileChooser();

                jfc.showOpenDialog(null);

                File f=jfc.getSelectedFile();

                FileInputStream fis=new FileInputStream(f);

                picstmt.setBinaryStream(1,fis,fis.available());
                picstmt.executeUpdate();

                JOptionPane.showMessageDialog(null,"Success");
                System.out.println("Image Inserted");
            }
            con.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}