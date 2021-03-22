package com.Project1JS.ui;

import com.Project1JS.util.XMLDelete;
import java.util.Scanner;

/**
 * UI Class for erasing data from the database.
 * Values are erased if they match both the table name and the value at the desired index
 */

public class DataErasureMenu {
    /**
     *  Shows the data erasure UI
     * @param scan scanner used for input
     */
    public void showMenu(Scanner scan) {
        do {
        System.out.println("Enter table name");
        String tablename = scan.nextLine();
        System.out.println("Enter index");
        int index = UIUtility.enterInteger(scan);
        System.out.println("Enter value");
            XMLDelete.delete(tablename,index,scan.nextLine());
        } while (UIUtility.yOrN(scan,"Delete more values?"));
    }
}
