package JAVA.JDBC.Bus_MAnagament_System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class m {
    private static final String url = "jdbc:mysql://localhost:3306";
        public static final String username = "root";
        public static final String password = "root";

        public static void main(String[] args) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }
            try {
                Connection connect = DriverManager.getConnection(url, username, password);
                }
                catch (SQLException e) {
                System.out.println(e.getMessage());
                }
            }
}
