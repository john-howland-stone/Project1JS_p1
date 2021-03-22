package com.Project1JS.model;

import com.Project1JS.util.XMLDao;

/**
 * Class for caching a single read query
 */

public class XMLRead {
    private String tableName;
    private String returnMessage;

    /**
     * constructor
     * @param tableName the table name
     */
    public XMLRead(String tableName) {
        this.tableName = tableName;
    }

    /**
     * getter for table name
     * @return the table name
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * getter for return message
     * @return the return message
     */
    public String getReturnMessage() {
        return returnMessage;
    }

    /**
     * Executes the query and cache's the result
     */
    public void execute () {
        this.returnMessage = XMLDao.getInstance().getAll(tableName);
    }

    /**
     * Two queries are equal if they have the same input
     * @param o the object to compare to
     * @return true of equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        XMLRead xmlRead = (XMLRead) o;
        return getTableName().equals(xmlRead.getTableName());
    }
}
