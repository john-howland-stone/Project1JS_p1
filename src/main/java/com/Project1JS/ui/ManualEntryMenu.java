package com.Project1JS.ui;

import com.Project1JS.util.XMLTransaction;
import com.Project1JS.model.XMLWriteQuery;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * UI Class for entering values into a transaction manually.
 * If the table does not already exist it is created first.
 * The menu must be re-loaded to switch tables
 */

public class ManualEntryMenu {
    /**
     *  Shows the manual data entry UI
     * @param scan scanner used for input
     */
    public void showMenu(Scanner scan) {
        System.out.println("Enter table name");
        String tablename = scan.nextLine();
        ArrayList<String> values = new ArrayList<>();
        do {
            System.out.println("enter value");
            values.add(scan.nextLine());
        } while (UIUtility.yOrN(scan,"Enter more values?"));
        XMLTransaction.getInstance().add(new XMLWriteQuery(tablename,values));
        System.out.println("Added values to current transaction");
    }
}
