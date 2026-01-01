package personal;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //1.Ask the user to enter a number.Determine if the number is positive, negative, or zero, and print the result.

//        task1(scanner);


        //2.Ask the user to enter a number between 1 and 7. Print the corresponding day of the week for that number.

//        task2(scanner);


        //3.Ask the user to enter a number. Using a loop, print all the odd numbers up to that number.

//        task3(scanner);


        //4.Ask the user to enter a number. Perform the following checks:
        //If the number is a palindrome (e.g., 12321), display:
        //If the digits of the number are in increasing order (e.g., 123489), indicate that.
        //If the digits of the number are in decreasing order (e.g., 97530), indicate that.
        //Otherwise, display:  "The digits are neither in increasing nor decreasing order."

//        task4(scanner);


        //5.Ask the user to enter their age and gender (M or F).
        //If the user is under 18, print "Access denied".
        //If the user is 18 or older, print:
        //For M: "Male access granted"
        //For F: "Female access granted"
        //If the user enters an incorrect gender, print "Invalid gender entered".

//        task5(scanner);


        //6.Write a program that prints Fibonacci numbers.
        //Ask the user how many Fibonacci numbers to print.
        //If the entered number is zero or negative, print "Please enter a valid number".
        //Use loops to print the Fibonacci sequence.
        //Use a to show whether each Fibonacci number is even or odd.

//        task6(scanner);


        //7.Ask the user to enter a number and calculate its factorial.
        //If the user enters a negative number, print "Factorial does not exist for negative numbers".
        //Use loops and (like i++ or --) during the calculation.
        //Print the result

//        task7(scanner);


        //8.A "Strong number" is defined as follows:
        //If the sum of the factorials of each digit of the number equals the number itself, then it is a .
        //145 → 1! + 4! + 5! = 1 + 24 + 120 = → ✅
        //123 → 1! + 2! + 3! = 1 + 2 + 6 = ≠ 123 → ❌
        //Calculate the factorial for each digit.
        //Sum them up and compare the result with the original number.

//        task8(scanner);


        //9.An is defined as:
        //If the sum of each digit raised to the power of the number of digits equals the number itself, then it is an .
        //153 → 1³ + 5³ + 3³ = 1 + 125 + 27 = → ✅
        //9474 → 9⁴ + 4⁴ + 7⁴ + 4⁴ = 6561 + 256 + 2401 + 256 = → ✅
        //123 → 1³ + 2³ + 3³ = 1 + 8 + 27 = ≠ 123 → ❌
        //Extract the digits of the number.
        //Count how many digits it has.
        //Raise each digit to the power of the number of digits.
        //Sum the results and compare with the original number.

//        task9(scanner);

    }

    private static void task9(Scanner scanner) {
        System.out.print("Enter a number: ");
        int input = scanner.nextInt();
        int number = input;
        int numberOfDigits = 0;
        if (input < 0) System.out.println("Enter a positive number.");
        else {
            //used do while for 0 case
            do {
                numberOfDigits++;
                number /= 10;
            } while (number > 0);

            number = input;
            int powerOfDigitsSum = 0;
            do {
                int digit = number % 10;
                int digitExponent = (int) Math.pow(digit, numberOfDigits);
                System.out.println(digit + "^" + numberOfDigits + " = " + digitExponent);
                powerOfDigitsSum += digitExponent;
                number /= 10;
            } while (number > 0);
            System.out.println("Sum: " + powerOfDigitsSum + '\n' + ((input == powerOfDigitsSum) ? "✅" : "❌"));
        }
    }

    private static void task8(Scanner scanner) {
        System.out.print("Enter a number: ");
        int input = scanner.nextInt();
        int number = input;
        long factorialsSum = 0;
        if (input < 0) System.out.println("Enter a positive number.");
        else {
            //used do while for 0 case
            do {
                long factorial = 1;
                int digit = number % 10;
                for (int i = 2; i <= digit; i++) {
                    factorial *= i;
                }
                System.out.println(digit + "!" + " = " + factorial);
                number /= 10;
                factorialsSum += factorial;
            } while (number > 0);
            System.out.println("Sum: " + factorialsSum + '\n' + ((input == factorialsSum) ? "✅" : "❌"));
        }
    }

    private static void task7(Scanner scanner) {
        System.out.print("Enter a number to print factorial: ");
        int number = scanner.nextInt();
        if (number < 0) {
            System.out.println("Factorial does not exist for negative numbers");
        } else {
            long factorial = 1; //used long due to memory issues
            for (int i = 2; i <= number; i++) {
                factorial *= i;
            }
            System.out.println("Factorial of " + number + " is " + factorial);
        }
    }

    private static void task6(Scanner scanner) {
        System.out.print("How many Fibonacci number to print?: ");
        int count = scanner.nextInt();
        if (count <= 0) System.out.println("Please enter a valid number");
            // An additional else-if block is used as required by the task description.
            // However, according to the Fibonacci definition (Fₙ = Fₙ₋₁ + Fₙ₋₂),
            // the sequence is only meaningful for n ≥ 2.
        else if (count > 1) {
            int previous = 0;
            int current = 1;
            System.out.println("1: 0 \n2: 1-Odd");
            for (int i = 2; i < count; i++) {
                int next = previous + current;
                previous = current;
                current = next;
                System.out.println(i + 1 + ": " + current + ((current % 2 == 0) ? "-Even" : "-Odd"));
            }
        }
    }


    private static void task5(Scanner scanner) {
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        if (age <= 0) {
            System.out.println("Invalid number, please enter positive number");
        } else if (age < 18) {
            System.out.println("Access denied");
        } else {
            System.out.print("Enter gender(male-M, female-F): ");
            char gender = scanner.next().toUpperCase().charAt(0);
            if (gender == 'M') {
                System.out.println("Male access granted");
            } else if (gender == 'F') {
                System.out.println("Female access granted");
            } else System.out.println("Invalid gender entered");
        }
    }

    private static void task4(Scanner scanner) {
        System.out.print("Enter a number: ");
        long input = scanner.nextLong();
        long number = input;
        long reversedNumber = 0;
        int numberOfDigits = 0;
        if (number > 0) {
            do {
                reversedNumber = reversedNumber * 10 + number % 10;
                number /= 10;
                numberOfDigits++;
            } while (number > 0);
            number = input;
            //checks if palindrome
            if (input == reversedNumber) {
                System.out.println("This number is palindrome.");
            } else System.out.println("This number is not palindrome.");

            int sequenceCounter = 0;
            long previous = number % 10;
            number /= 10;
            for (int i = 1; i < numberOfDigits; i++) {
                long current = number % 10;
                if (current > previous) {
                    sequenceCounter--;
                } else if (current < previous) {
                    sequenceCounter++;
                }
                previous = current;
                number /= 10;
            }

            //checks order
            if (sequenceCounter + 1 == numberOfDigits) {
                System.out.print("The digits are in increasing order.");
            } else if (sequenceCounter - 1 == -numberOfDigits) {
                System.out.print("The digits are in decreasing order.");
            } else System.out.print("The digits are neither in increasing nor decreasing order.");
        } else {
            System.out.println("Enter a positive number.");
        }


    }

    private static void task3(Scanner scanner) {
        System.out.print("Enter a number: ");
        int input = scanner.nextInt();
        if (input <= 0) System.out.println("Enter positive number.");
        int number = 0; //A variable to print values in ascending order.
        while (number <= input) {
            if (number % 2 != 0) System.out.println(number);
            number++;
        }
    }

    private static void task2(Scanner scanner) {
        System.out.print("Enter a number between 1 to 7: ");
        int day = scanner.nextInt();
        switch (day) {
            case 1:
                System.out.print("Monday");
                break;
            case 2:
                System.out.print("Tuesday");
                break;
            case 3:
                System.out.print("Wednesday");
                break;
            case 4:
                System.out.print("Thursday");
                break;
            case 5:
                System.out.print("Friday");
                break;
            case 6:
                System.out.print("Saturday");
                break;
            case 7:
                System.out.print("Sunday");
                break;
            default:
                System.out.print("Invalid day");
        }
    }

    private static void task1(Scanner scanner) {
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        if (number > 0) {
            System.out.println(number + "(Positive)");
        } else if (number == 0) {
            System.out.println(number + "(Zero)");
        } else System.out.println(number + "(Negative)");
    }
}
