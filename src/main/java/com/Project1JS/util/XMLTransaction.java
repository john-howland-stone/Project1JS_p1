package com.Project1JS.util;

import com.Project1JS.model.XMLSavepoint;
import com.Project1JS.model.XMLWriteQuery;

import java.util.ArrayList;

/**
 * Singleton class for managing transactoins
 */
public class XMLTransaction {

    private ArrayList<XMLSavepoint> savepoints = new ArrayList<>();

    private static XMLTransaction instance;

    /**
     * Sigleton constructor
     */
    private XMLTransaction() {
    }

    /**
     *  Singleton implementation
     * @return the singleton instance
     */
    synchronized public static XMLTransaction getInstance() {
        if (instance == null) {
            instance = new XMLTransaction();
        }
        return instance;
    }

    /**
     * Adds a query to the current savepoint. Will create the first savepoint if none exist
     * @param query the query to add
     */
    public void add (XMLWriteQuery query) {
        if (savepoints.size() == 0) {
            savepoints.add(new XMLSavepoint());
        }
        savepoints.get(savepoints.size()-1).addQuery(query);
    }

    /**
     * Saves the current savepoint and creates a new one for subsequent queries
     */
    public void save() {
        savepoints.add(new XMLSavepoint());
    }

    /**
     * Deletes the current savepoint
     */
    public void rollback() {
        savepoints.remove(savepoints.size()-1);
    }

    /**
     * Commits the current transaction and clears all savepoints
     */
    public void commit() {
        for (XMLSavepoint s: savepoints) {
            s.commit();
        }
        savepoints.clear();
    }
}
