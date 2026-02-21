package personal.exceptionHandlingPractice;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        System.out.println(powerToSquare());
    }

    public static int powerToSquare() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Enter an integer: ");
                int number = scanner.nextInt();
                return number * number;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid integer.");
                scanner.nextLine();
            }
        }
    }
}
