package com.Project1JS.util;

import java.sql.*;
import java.util.ArrayList;

/**
 * Class for handling interactions with the database
 */
public class XMLDao {
    private static XMLDao instance;

    /**
     * Singleton constructor
     */
    private XMLDao() {
    }

    /**
     *  Singleton implementation
     * @return the singleton instance
     */
    synchronized public static XMLDao getInstance() {
        if (instance == null) {
            instance = new XMLDao();
        }
        return instance;
    }

    /**
     * Method that appends data to tables. The table will be created if it doesn't yet exist.
     * @param tableName Table name to append to
     * @param valueList Values to append
     */
    public void createOrAppend(String tableName, ArrayList<String> valueList) {
        ResultSet rs;
        try {
            ConnectionSession sess = new ConnectionSession();
            Connection conn = sess.getActiveConnection();
            DatabaseMetaData md = conn.getMetaData();
            rs = md.getTables(null, "public", tableName, null);
            PreparedStatement ps;
            if (rs == null || !rs.next()) {
                StringBuilder statementBuilder = new StringBuilder("create table " + tableName + " (");
                for (int i = 0; i < valueList.size() - 1; i++) {
                    statementBuilder.append("value");
                    statementBuilder.append(i);
                    statementBuilder.append(" text, ");
                }
                statementBuilder.append("value");
                statementBuilder.append(valueList.size() - 1);
                statementBuilder.append(" text");
                statementBuilder.append(")");
                ps = conn.prepareStatement(statementBuilder.toString());
                ps.executeUpdate();
            }
            ps = conn.prepareStatement("select * from " + tableName);
            rs = ps.executeQuery();
            if (rs.getMetaData().getColumnCount() != valueList.size()) {
                //ps.close();
                //rs.close();
                //conn.close();
                sess.close();
            }
            StringBuilder statementBuilder = new StringBuilder("insert into " + tableName + " values (");
            for (int i = 0; i < valueList.size() - 1; i++) {
                statementBuilder.append("?,");
            }
            statementBuilder.append("?)");
            ps = conn.prepareStatement(statementBuilder.toString());
            for (int i = 0; i < valueList.size(); i++) {
                ps.setString(i + 1, valueList.get(i));
            }
            ps.executeUpdate();
            sess.close();
        } catch (SQLException e) {
        }

    }

    /**
     * Method that reads and returns data from a table
     * @param tableName the table name to read
     * @return the data from the table
     */
    public String getAll(String tableName) {
        try {
            ConnectionSession sess = new ConnectionSession();
            Connection conn = sess.getActiveConnection();
            DatabaseMetaData md = conn.getMetaData();
            ResultSet rs = md.getTables(null, "public", tableName, null);
            if (rs == null || rs.getMetaData().getColumnCount() < 1) {
                //conn.close();
                sess.close();
                //rs.close();
                return "No results";
            }
            if (rs.getRow() < 0) {
                //conn.close();
                sess.close();
                //rs.close();
                return "No results";
            }
            PreparedStatement ps = sess.getActiveConnection().prepareStatement("select * from " + tableName);
            rs = ps.executeQuery();
            StringBuilder returnvalue = new StringBuilder();
            while (rs.next()) {
                returnvalue.append("| ");
                for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                    returnvalue.append(rs.getString(i + 1));
                    returnvalue.append(" | ");
                }
                returnvalue.append(System.lineSeparator());
            }
            //conn.close();
            sess.close();
            //ps.close();
            //rs.close();
            return returnvalue.toString();
        } catch (SQLException e) {
            return "Error communicating with the database, possibly malformed input";
        } catch (Exception e) {
            return "Unknown Error";
        }
    }

    /**
     * Removes data from a table based matching a value at an index
     * @param tableName the table to delete from
     * @param index the index to search
     * @param value the value to match
     */
    public void remove(String tableName, int index, String value) {
        try (ConnectionSession sess = new ConnectionSession()) {
            Connection conn = sess.getActiveConnection();
            PreparedStatement ps = conn.prepareStatement("delete from "+ tableName + " where " + "value" + index +" = ?");
            ps.setString(1, value);
            ps.executeUpdate();
            //ps.close();
            //conn.close();
            sess.close();
        } catch (Exception e) {
        }

    }

    /**
     * Updates values in a table if the value at the index matches the desired value
     * @param tableName table to update
     * @param index index to update
     * @param oldvalue value to search for
     * @param newvalue value to replace with
     */
    public void update(String tableName, int index, String oldvalue,String newvalue) {
        //TODO implement this
        try (ConnectionSession sess = new ConnectionSession()) {
            Connection conn = sess.getActiveConnection();
            PreparedStatement ps = conn.prepareStatement("update "+ tableName + " set value" + index + " = ? where " + "value" + index +" = ?");
            ps.setString(1, newvalue);
            ps.setString(2, oldvalue);
            ps.executeUpdate();
            //ps.close();
            //conn.close();
            sess.close();
        } catch (Exception e) {
        }

    }
}
