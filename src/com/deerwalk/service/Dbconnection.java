package com.deerwalk.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by user on 10/30/2017.
 */
public class Dbconnection {
    public Connection getDbconnection(){
        Connection connection=null;
        String DBURL = "jdbc:mysql://localhost:3306/quiz";
        String USERNAME = "root";
        String PASSWORD ="";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
