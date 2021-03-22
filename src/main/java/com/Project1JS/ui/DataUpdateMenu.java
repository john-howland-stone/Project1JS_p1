package com.Project1JS.ui;

import com.Project1JS.util.XMLUpdate;

import java.util.Scanner;

/**
 * UI Class for updating data in the database
 * Data will be updated if the value at the index matches the desired value
 */
public class DataUpdateMenu {
    /**
     *  Shows the data update UI
     * @param scan scanner used for input
     */
    public void showMenu(Scanner scan) {
        do {
            System.out.println("Enter table name");
            String tablename = scan.nextLine();
            System.out.println("Enter index");
            int index = UIUtility.enterInteger(scan);
            System.out.println("Enter value to replace");
            String oldvalue = scan.nextLine();
            System.out.println("Enter new value");
            XMLUpdate.update(tablename,index,oldvalue,scan.nextLine());
        } while (UIUtility.yOrN(scan,"Update more values?"));
    }
}
