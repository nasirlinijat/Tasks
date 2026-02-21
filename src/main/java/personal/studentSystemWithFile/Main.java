package personal.studentSystemWithFile;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = true;
        while (exit) {
            System.out.print("Menu:\n" +
                             "1. View all records \n" +
                             "2. Overwrite file with new records \n" +
                             "3. Append a new record \n" +
                             "4. Exit\n" +
                             "Enter your choice: ");
            int number = scanner.nextInt();

            switch (number) {
                case 1 -> FileUtil.readFromFile();
                case 2 -> FileUtil.overwriteToFile(createStudent(scanner));
                case 3 -> FileUtil.appendToFile(createStudent(scanner));
                case 4 -> exit = false;
            }
        }

    }

    private static Student createStudent(Scanner scanner) {
        try {
            System.out.print("Student id: ");
            long studentId = scanner.nextLong();
            System.out.print("Student name: ");
            String name = scanner.next();
            System.out.print("Student grade: ");
            double score = scanner.nextDouble();

            return new Student(studentId, name, score);
        } catch (InputMismatchException e) {
            throw new RuntimeException("Invalid input type! Please enter correct values.", e);
        }
    }
}

