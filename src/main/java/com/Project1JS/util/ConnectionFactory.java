package com.Project1JS.util;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Factory class that manages connections to the database
 * Regulates the max number of connections the program can use
 */
public class ConnectionFactory implements Closeable {

    public static final int MAX_CONNECTIONS = 6;
    private final Connection[] connectionPool = new Connection[MAX_CONNECTIONS];

    private static ConnectionFactory instance;

    /**
     * Constructor that initializes the connection pool
     */

    private ConnectionFactory() {
        for(int i = 0; i< MAX_CONNECTIONS; i++){
            connectionPool[i] = createConnection();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Singleton design pattern implementation
     * @return the singleton instance
     */
    synchronized public static ConnectionFactory getInstance() {
        if (instance == null) {
            instance = new ConnectionFactory();
        }
        return instance;
    }


    /**
     * Creates a connection for the program to use
     * @return the created connection
     */

    private Connection createConnection() {
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

    /**
     * Getter for the connection pool
     * @return the connection pool
     */
    public Connection[] getConnectionPool() {
        return connectionPool;
    }

    /**
     * Closes a connection
     */
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