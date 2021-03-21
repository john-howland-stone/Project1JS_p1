package com.Project1JS.util;

import java.sql.*;
import java.util.ArrayList;

public class XMLDao {
    private static XMLDao instance;

    private XMLDao() {
    }

    synchronized public static XMLDao getInstance() {
        if (instance == null) {
            instance = new XMLDao();
        }
        return instance;
    }

    public String createOrUpdate(String tableName, ArrayList<String> valueList) {
        ResultSet rs;
        try {
            ConnectionSession sess = new ConnectionSession();
            Connection conn = sess.getActiveConnection();
            DatabaseMetaData md = conn.getMetaData();
            rs = md.getTables(null, "public", tableName, null);
            PreparedStatement ps = null;
            if (rs == null || !rs.next()) {
                StringBuilder statementBuilder = new StringBuilder("create table " + tableName + " (");
                for (int i = 0; i < valueList.size() - 1; i++) {
                    statementBuilder.append("value" + i + " text, ");
                }
                statementBuilder.append("value" + (valueList.size() - 1) + " text");
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
                return "Number of elements for query to " + tableName + " does not match existing definition";
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
            if (ps.executeUpdate() > 0) {
                //ps.close();
                //rs.close();
                //conn.close();
                sess.close();
                return "Successfully wrote to database";
            } else {
                //ps.close();
                //rs.close();
                //conn.close();
                sess.close();
                return "Error writing to the database";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error writing to the database";
        }

    }

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

    public boolean remove(String tableName, int index, String value) {
        try (ConnectionSession sess = new ConnectionSession()) {
            Connection conn = sess.getActiveConnection();
            PreparedStatement ps = conn.prepareStatement("delete from "+ tableName + " where " + "value" + index +" = ?");
            ps.setString(1, value);
            int i = ps.executeUpdate();
            //ps.close();
            //conn.close();
            sess.close();
            return i > 0;
        } catch (SQLException throwables) {
            return false;
        } catch (Exception e) {
            return false;
        }

    }
}
