package com.cibt.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
    
    public static Connection getConnection() throws Exception {

        // Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/budget_planner";
        String user = "root";
        String password = "";

        return DriverManager.getConnection(url, user, password);
    }

}