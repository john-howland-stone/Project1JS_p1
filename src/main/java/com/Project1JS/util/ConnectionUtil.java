package com.Project1JS.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    private static ConnectionUtil instance;

    private ConnectionUtil(){}

    public static ConnectionUtil getInstance(){
        if(instance == null){
            instance = new ConnectionUtil();
        }
        return instance;
    }


    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:postgresql://john-howland-stone-revature.csxskrlqp9f1.us-east-2.rds.amazonaws.com/postgres?currentSchema=public",
                "__LOT",
                "__ROOT");
    }
}