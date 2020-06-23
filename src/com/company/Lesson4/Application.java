package com.company.Lesson4;

import org.gjt.mm.mysql.Driver;

import java.sql.*;
import java.util.UUID;

public class Application {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "root");
        Statement stmt = conn.createStatement();
        //stmt.executeUpdate("UPDATE user SET age=37 WHERE id=1");
        //stmt.executeUpdate("INSERT INTO user (name, last_name, age) VALUE ('Даша', 'Иванова', 18)");
        //stmt.executeUpdate("DELETE  FROM  user WHERE id=6");
        stmt.executeUpdate("INsert into user(name, last_name, age) value ('Борис', 'Kovkov', 21)");
        ResultSet data = stmt.executeQuery("SELECT * FROM user");

        ResultSetMetaData metaData = data.getMetaData();
        for (int i = 1; i < metaData.getColumnCount(); i++) {
            System.out.println("Column Name = " + metaData.getColumnName(i));
            System.out.println("Column Name = " + metaData.getColumnLabel(i));
            System.out.println("Column Name = " + metaData.getColumnTypeName(i));
            System.out.println("Column Name = " + metaData.getColumnClassName(i));
            System.out.println("Column SIZE = " + metaData.getColumnDisplaySize(i));
        }


        while (data.next()) {
            System.out.println(data.getInt(1) +") "+
                    data.getString("name") +" " +
                    data.getString(3) +" " +
                    data.getInt("age") + " год рождения");
        }

        System.out.println("Updating...");
    }
}
