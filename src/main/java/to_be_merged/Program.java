package to_be_merged;

import to_be_merged.method.RunSortingAlgorithms;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean open = true;
        while(open){
            new RunSortingAlgorithms().run();
            System.out.println("Continue ?\n[1]    YES\n[any key]    NO");
            int choice = scanner.nextInt();
            open = choice == 1;
        }
    }
}
