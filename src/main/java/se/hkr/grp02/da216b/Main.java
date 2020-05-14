package se.hkr.grp02.da216b;

import se.hkr.grp02.da216b.methods.RunSortingAlgorithms;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 1;
        while (choice == 1) {
            System.out.println("Select: \n[1]   Print DB results\n[2]   Run tests");
            try {
                int answer = Integer.parseInt(scanner.nextLine());
                if (answer==1){
                    RunSortingAlgorithms run = new RunSortingAlgorithms();
                    run.pullFromDB();
                    run.printDBResults();
                } else if (answer==2){
                    new RunSortingAlgorithms().run();
                }
            } catch (NumberFormatException e) {
                choice = 0;
            }

            System.out.println("Continue ?\n[1]    YES\n[ENTER]    EXIT!");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice != 1)
                    System.out.println("\u001B[34m" + "Thank you!\nBye Bye!" + "\u001B[0m");
            } catch (NumberFormatException e) {
                System.out.println("\u001B[34m" + "Thank you!\nBye Bye!" + "\u001B[0m");
                choice = 0;
            }
        }
    }
}
