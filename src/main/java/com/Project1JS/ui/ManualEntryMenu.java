package com.Project1JS.ui;

import com.Project1JS.util.XMLTransaction;
import com.Project1JS.util.XMLWriteQuery;

import java.util.ArrayList;
import java.util.Scanner;

public class ManualEntryMenu {
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
