package com.Project1JS.ui;

import com.Project1JS.util.XMLDelete;
import java.util.Scanner;

public class DataErasureMenu {
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
