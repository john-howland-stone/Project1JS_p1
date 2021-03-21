package com.Project1JS.ui;

import java.util.Scanner;

public class UIUtility {

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
