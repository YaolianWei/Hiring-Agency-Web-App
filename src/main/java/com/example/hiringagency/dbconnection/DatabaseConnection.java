package com.example.hiringagency.dbconnection;

import java.sql.*;

public class DatabaseConnection {

    private Connection connection = null;
    private String url = "jdbc:sqlite:Agency.db";

    public DatabaseConnection(){

    }

    public void initialize() throws SQLException {
        connection = DriverManager.getConnection(url);
        System.out.println("connection is " + connection.isClosed());
    }

    public void disconnect() throws SQLException {
        connection.close();
    }


}
