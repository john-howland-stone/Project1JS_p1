package com.Project1JS.util;

import java.util.ArrayList;
import java.util.Objects;

public class XMLRead {
    private String tableName;
    private String returnMessage;

    public XMLRead(String tableName) {
        this.tableName = tableName;
    }

    public String getTableName() {
        return tableName;
    }

    public String getReturnMessage() {
        return returnMessage;
    }
    public void execute () {
        this.returnMessage = XMLDao.getInstance().getAll(tableName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        XMLRead xmlRead = (XMLRead) o;
        return getTableName().equals(xmlRead.getTableName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTableName());
    }
}
