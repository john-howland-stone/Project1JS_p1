package com.Project1JS.util;

/**
 * Class containing a static method to handle delete requests
 */

public class XMLDelete {
    /**
     * Passes delete requests to the DAO layer
     * @param tablename table to delete from
     * @param index index to delete rows from
     * @param value will delete rows where the value at the index matches this value
     */
    public static void delete(String tablename, int index, String value) {
        XMLDao.getInstance().remove(tablename,index,value);
    }
}
