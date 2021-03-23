package com.Project1JS.util;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *  Class for managing threads used in create and update requests
 */

public class XMLExecutor {
    private static XMLExecutor instance;

    private ExecutorService executor = Executors.newFixedThreadPool(5);

    /**
     * Singleton constructor
     */
    private XMLExecutor() {
    }

    /**
     *  Singleton implementation
     * @return the singleton instance
     */
    synchronized public static XMLExecutor getInstance() {
        if (instance == null) {
            instance = new XMLExecutor();
        }
        return instance;
    }

    /**
     * Runs a create or append query on a separate thread
     * @param tablename table name for query
     * @param values values to put in the table
     */
    public void runXMLCreateorAppendQuery(String tablename, ArrayList<String> values) {
        executor.execute(() -> XMLDao.getInstance().createOrAppend(tablename,values));
    }

    /**
     * Runs an update query on a separate thread
     * @param tableName table to update
     * @param index index to update
     * @param oldvalue value to search for
     * @param newvalue value to replace with
     */
    public void runXMLUpdateQuery(String tableName,int index, String oldvalue, String newvalue) {
        executor.execute(() -> XMLDao.getInstance().update(tableName,index,oldvalue,newvalue));
    }

    public ExecutorService getExecutor() {
        return executor;
    }
}
