package com.Project1JS.util;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class XMLExecutor {
    private static XMLExecutor instance;

    private ExecutorService executor = Executors.newFixedThreadPool(5);

    private XMLExecutor() {
    }

    synchronized public static XMLExecutor getInstance() {
        if (instance == null) {
            instance = new XMLExecutor();
        }
        return instance;
    }
    public void runXMLQuery(String tablename, ArrayList<String> values) {
        executor.execute(() -> System.out.println(XMLDao.getInstance().createOrUpdate(tablename,values)));
    }

    public ExecutorService getExecutor() {
        return executor;
    }
}
