package com.Project1JS.util;

import java.sql.Connection;

/**
 * Class that handles an instance of a connection
 */
public class ConnectionSession implements AutoCloseable {

    private Connection activeConnection;
    private int locationIndex = -1;

    /**
     * Returns a new active connection for a database query to use
     * @return the connection
     */
    synchronized public Connection getActiveConnection(){
        for(int i = 0; i< ConnectionFactory.MAX_CONNECTIONS; i++){
            Connection conn = ConnectionFactory.getInstance().getConnectionPool()[i];
            if(conn != null){

                activeConnection = conn;
                ConnectionFactory.getInstance().getConnectionPool()[i] = null;
                locationIndex = i;
                return activeConnection;
            }
        }
        throw new RuntimeException("No active connections available");
    }
/**
Closes the connection and gives it back to the connection pool to be used again later
 */
    @Override
    public void close() {
        ConnectionFactory.getInstance().getConnectionPool()[locationIndex]=activeConnection;
        activeConnection = null;
        locationIndex = -1;
    }
}
