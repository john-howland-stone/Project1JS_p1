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
     * Runs a create or append query on a seperate thread
     * @param tablename table name for query
     * @param values values to put in the table
     */
    public void runXMLCreateorAppendQuery(String tablename, ArrayList<String> values) {
        executor.execute(() -> System.out.println(XMLDao.getInstance().createOrAppend(tablename,values)));
    }

    public void runXMLUpdateQuery(String tablename,int index, String oldvalue, String newvalue) {
        executor.execute(() -> XMLDao.getInstance().update(tablename,index,oldvalue,newvalue));
    }

    public ExecutorService getExecutor() {
        return executor;
    }
}
