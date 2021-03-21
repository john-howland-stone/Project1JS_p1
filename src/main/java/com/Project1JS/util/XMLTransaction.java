package com.Project1JS.util;

import java.util.ArrayList;

public class XMLTransaction {

    private ArrayList<XMLSavepoint> savepoints = new ArrayList<>();

    private static XMLTransaction instance;

    private XMLTransaction() {
    }

    synchronized public static XMLTransaction getInstance() {
        if (instance == null) {
            instance = new XMLTransaction();
        }
        return instance;
    }

    public void add (XMLWriteQuery query) {
        if (savepoints.size() == 0) {
            savepoints.add(new XMLSavepoint());
        }
        savepoints.get(savepoints.size()-1).addQuery(query);
    }
    public void save() {
        savepoints.add(new XMLSavepoint());
    }
    public void rollback() {
        savepoints.remove(savepoints.size()-1);
    }
    public void commit() {
        for (XMLSavepoint s: savepoints) {
            s.commit();
        }
        savepoints.clear();
    }
}
