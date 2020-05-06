package se.hkr.grp02.da216b;

import java.util.Scanner;

public class Main {
    private static Scanner scanner;
    private static Boolean running;

    public static void main(String[] args) {
        Main.running = true;

        while(running){
            ///////******** IMPORT AND =UNCOMMENT ///////********
            //new RunSortingAlgorithms().run();
            ///////******** IMPORT AND =UNCOMMENT ///////********
            System.out.println("Continue ?\n[1]    YES\n[any key]    NO");
            int choice = scanner.nextInt();
            running = choice == 1;
        }
    }
}
