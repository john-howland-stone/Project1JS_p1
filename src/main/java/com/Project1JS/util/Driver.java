package com.Project1JS.util;

import com.Project1JS.ui.*;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Driver {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int answer;
        System.out.println("====Welcome to JS's ORM====");
        do {
            System.out.println("1. Load XML File 2. Manual Data Entry 3. Transaction Management. 4. View table data 5. Data Erasure menu 6. Exit");
            answer = UIUtility.enterInteger(scan);
            if (answer == 1) {
                new LoadFileMenu().showMenu(scan);
            } else if (answer == 2) {
                new ManualEntryMenu().showMenu(scan);
            } else if (answer == 3) {
                new TransactionManagementMenu().showMenu(scan);
            } else if (answer == 4) {
                if (UIUtility.yOrN(scan,"Do you wish to clear the cache before searching?")) {
                    XMLReadCache.getInstance().clearCache();
                }
                System.out.println("Enter table name to view");
                System.out.println(XMLReadCache.getInstance().runQuery(new XMLRead(scan.nextLine())));
            } else if (answer == 5) {
                new DataErasureMenu().showMenu(scan);
            }
        } while (answer != 6);
        System.out.println("Exiting");
        try {
            XMLExecutor.getInstance().getExecutor().awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println("Error finishing Transactions");
        }
    }
}
