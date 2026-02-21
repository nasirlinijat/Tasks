package personal.exceptionHandlingPractice.task2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            test();
        }catch (InvalidInputException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void test() throws InvalidInputException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter age from 0 to 100.");
        int age = scanner.nextInt();
        if (age < 0 || age > 100) {
            throw new InvalidInputException("Please enter age in the given range");
        }
    }
}
