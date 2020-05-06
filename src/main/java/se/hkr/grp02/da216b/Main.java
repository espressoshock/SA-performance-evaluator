package se.hkr.grp02.da216b;

import se.hkr.grp02.da216b.methods.RunSortingAlgorithms;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 1;
        while(choice == 1){
            new RunSortingAlgorithms().run();
            System.out.println("Continue ?\n[1]    YES\n[any key]    EXIT!");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("\u001B[34m" + "Thank you!\nBye Bye!" + "\u001B[0m");
                choice = 0;
            }
        }
    }
}
