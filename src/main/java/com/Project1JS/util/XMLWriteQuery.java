package com.Project1JS.util;

import java.util.ArrayList;

public class XMLWriteQuery {
    String tablename;
    ArrayList<String> values;

    public XMLWriteQuery(String tablename, ArrayList<String> values) {
        this.tablename = tablename;
        this.values = values;
    }

    public String getTablename() {
        return tablename;
    }

    public ArrayList<String> getValues() {
        return values;
    }
}
