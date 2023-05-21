package com.steal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        boolean keepgoing = true;;
        boolean first = true;
        while (keepgoing) {
            if(first){

                first = false;
            }
            System.out.println("do you want keep making stuff");
            String keepit = sc.nextLine();
            if (keepit.equals("y")) {
                App program = new App();
                program.main(args);
                keepgoing = true;
            } else {
                System.out.println("goodbye");
                keepgoing = false;
                break;
            }
        }
        
    }
}
