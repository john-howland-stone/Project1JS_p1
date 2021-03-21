package com.Project1JS.util;

import java.util.ArrayList;

public class XMLReadCache {
    private static XMLReadCache instance;

    private ArrayList<XMLRead> queries = new ArrayList<>();

    private XMLReadCache() {
    }

    synchronized public static XMLReadCache getInstance() {
        if (instance == null) {
            instance = new XMLReadCache();
        }
        return instance;
    }

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

    public void clearCache() {
        this.queries = new ArrayList<XMLRead>();
    }
}
