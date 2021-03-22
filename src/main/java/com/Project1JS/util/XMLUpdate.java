package com.Project1JS.util;

/**
 * Class containing a static method to handle update requests
 */
public class XMLUpdate {
    /**
     *
     * @param tablename  table name to update
     * @param index index to search
     * @param oldvalue value to match
     * @param newvalue value to replace with
     */
    public static void update(String tablename, int index, String oldvalue,String newvalue) {
        XMLExecutor.getInstance().runXMLUpdateQuery(tablename,index,oldvalue,newvalue);
    }
}
