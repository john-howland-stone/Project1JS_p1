package com.Project1JS.util;

public class XMLDelete {
    public static void delete(String tablename, int index, String value) {
        XMLDao.getInstance().remove(tablename,index,value);
    }
}
