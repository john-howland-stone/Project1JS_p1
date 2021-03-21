package com.Project1JS.util;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory implements Closeable {

    public static final int MAX_CONNECTIONS = 4;
    private final Connection[] connectionPool = new Connection[MAX_CONNECTIONS];

    private static ConnectionFactory instance;

    private ConnectionFactory() {
        for(int i = 0; i< MAX_CONNECTIONS; i++){
            connectionPool[i] = createConnection("dev");
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public static ConnectionFactory getInstance() {
        if (instance == null) {
            instance = new ConnectionFactory();
        }
        return instance;
    }


    private Connection createConnection(String profile) {
        Properties props = new Properties();
        try {
            return DriverManager.getConnection(
                    "jdbc:postgresql://john-howland-stone-revature.csxskrlqp9f1.us-east-2.rds.amazonaws.com/postgres?currentSchema=public",
                    "__LOT",
                    "__ROOT");
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Connection[] getConnectionPool() {
        return connectionPool;
    }

    @Override
    public void close() {
        for(Connection con: connectionPool){
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

}