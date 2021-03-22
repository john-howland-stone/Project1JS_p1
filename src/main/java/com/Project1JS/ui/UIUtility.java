package com.Project1JS.ui;

import java.util.Scanner;

/**
 * Utility class containing various UI methods
 */

public class UIUtility {
    /**
     *  Utility Method for confirming an action with a yess/no prompt
     * @param scan scanner used for input
     * @param message Message shown to the user for the yes or no prompt
     * @return true if yes, false if no
     */
    public static boolean yOrN(Scanner scan, String message){
        String answer;
        do{
            System.out.println(message + " y/n");
            answer = scan.nextLine();
            if(answer.equals("y")){
                return true;
            } else if(answer.equals("n")){
                return false;
            }
        } while(true);
    }

    /**
     *  Utility Method that makes the user enter an integer. Handles invaild input by repeating the prompt.
     * @param scan scanner used for input
     * @return The integer entered
     */
    public static int enterInteger(Scanner scan) {
        while (!scan.hasNextInt()) {
            scan.nextLine();
            System.out.println("Input is not an integer");
        }
        int answer = scan.nextInt();
        scan.nextLine();
        return answer;
    }
}
