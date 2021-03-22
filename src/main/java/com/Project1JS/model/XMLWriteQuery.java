package com.Project1JS.model;

import java.util.ArrayList;

/**
 * Class for modeling a single write query
 */
public class XMLWriteQuery {
    String tablename;
    ArrayList<String> values;

    /**
     * COonstructs a new write query
     * @param tablename name of the table to insert into
     * @param values values to insert
     */
    public XMLWriteQuery(String tablename, ArrayList<String> values) {
        this.tablename = tablename;
        this.values = values;
    }

    /**
     * Getter for tablename
     * @return the tablename
     */
    public String getTablename() {
        return tablename;
    }
    /**
     * Getter for values
     * @return the values as an Arraylist
     */
    public ArrayList<String> getValues() {
        return values;
    }
}
