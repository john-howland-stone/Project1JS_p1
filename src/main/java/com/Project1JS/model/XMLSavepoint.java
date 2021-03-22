package com.Project1JS.model;

import com.Project1JS.util.XMLExecutor;

import java.util.ArrayList;

/**
 * Class for managing savepoints. Each savepoint is an arraylist of queries
 */
public class XMLSavepoint {

    private ArrayList<XMLWriteQuery> queries = new ArrayList<>();

    /**
     * Adds a query to this savepoint
     * @param query The query to add
     */
    public void addQuery(XMLWriteQuery query) {
        queries.add(query);
    }
/**
Runs each query in this savepoint to a separate thread.
 */
    public void commit() {
        for (XMLWriteQuery q : queries) {
            XMLExecutor.getInstance().runXMLCreateorAppendQuery(q.getTablename(),q.getValues());
        }
    }
}
