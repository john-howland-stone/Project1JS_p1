package com.Project1JS.util;

import java.util.ArrayList;

public class XMLSavepoint {

    private ArrayList<XMLWriteQuery> queries = new ArrayList<>();

    public void addQuery(XMLWriteQuery query) {
        queries.add(query);
    }

    public void commit() {
        for (XMLWriteQuery q : queries) {
            XMLExecutor.getInstance().runXMLQuery(q.getTablename(),q.getValues());
        }
    }
}
