package com.Project1JS.model;

import java.util.ArrayList;

/**
 * Class for handling read requests
 */

public class XMLReadCache {
    private static XMLReadCache instance;

    private ArrayList<XMLRead> queries = new ArrayList<>();

    /**
     * Singleton constructor
     */
    private XMLReadCache() {
    }
    /**
     *  Singleton implementation
     * @return the singleton instance
     */
    synchronized public static XMLReadCache getInstance() {
        if (instance == null) {
            instance = new XMLReadCache();
        }
        return instance;
    }

    /**
     * Runs a query returning it from the cache if its present
     * @param query the table to query
     * @return the return value of the query
     */
    public String runQuery(XMLRead query) {
        if (!queries.contains(query)) {
            query.execute();
            this.queries.add(query);
            return query.getReturnMessage();
        }
        for (int i = 0; i < queries.size(); i++) {
            if (query.equals(queries.get(i))) {
                return queries.get(i).getReturnMessage();
            }
        }
        return "Unknown Error";
    }

    /**
     * Clears the cache of stored queries
     */
    public void clearCache() {
        this.queries = new ArrayList<>();
    }
}
