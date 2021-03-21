package com.Project1JS.ui;

import com.Project1JS.util.XMLTransaction;
import com.Project1JS.util.XMLWriteQuery;

import java.util.ArrayList;
import java.util.Scanner;

public class TransactionManagementMenu {
    public void showMenu(Scanner scan) {
        int answer;
        do {
            System.out.println("1. Commit 2. Savepoint 3. Rollback 4. Previous Menu");
            answer = UIUtility.enterInteger(scan);
            if (answer == 1) {
                XMLTransaction.getInstance().commit();
                System.out.println("Committing");
                break;
            }
            if (answer == 2) {
                XMLTransaction.getInstance().save();
                System.out.println("Created Savepoint");
            }
            if (answer == 3) {
                XMLTransaction.getInstance().rollback();
                System.out.println("Rolled back current Savepoint");
            }
        } while (answer != 4);
    }
}
