package personal;

import java.util.Arrays;
import java.util.Locale;

public class Task3 {
    public static void main(String[] args) {
        //1.Ən böyük və ən kiçik ədədi tap
        //Şərt:
        //Verilmiş int[] tipli array-dən
        //istifadə edərək:
        //Ən böyük ədədi tap.
        //Ən kiçik ədədi tap.
        //Hər ikisini ekrana çap et.
        //Nümunə:
        //int[] numbers = {4, 7, -2, 15, 0, 99, -100};
        //Gözlənilən çıxış:
        //Ən böyük ədəd: 99
        //Ən kiçik ədəd: -100

//        task1();


        //2. 2 Ölçülü array-də əsas və köməkçi diaqonalın
        //cəmi
        //Şərt:
        //3x3 ölçülü kvadrat matrisi
        //verilir.
        //Əsas diaqonal: matrix[0][0],
        //matrix[1][1], matrix[2][2]
        //Köməkçi diaqonal: matrix[0][2],
        //matrix[1][1], matrix[2][0]
        //Hər iki diaqonalın cəmini hesabla
        //və çap et
        //(hesablayan zaman sadece : matrix[0][0]+ matrix[1][1]+matrix[2][2]etmeyin,dovrlerden
        //istifade edin).
        //Nümunə:
//        int[][] matrix = {
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}
//        };
        //Gözlənilən çıxış:
        //Əsas diaqonal cəmi: 15
        //Köməkçi diaqonal cəmi: 15

//        task2();


        //3. 3 Ölçülü Array-də müəyyən şərtə uyğun ədədləri
        //çap et
        //Şərt:
        //3D array verilir.
        //6-dan böyük olan bütün ədədləri
        //tap və çap et.
        //Nümunə:
        //int[][][] cube = {
        //    {
        //        {1, 2}, {3, 4}
        //    },
        //    {
        //        {5, 6}, {7, 8}
        //    }
        //};
        //Gözlənilən çıxış:
        //6-dan böyük ədədlər: 7, 8

//        task3();


        //4.Verilən int[] array-i artan sıraya görə sort et.
        //Daha sonra array-in tərs versiyasını çap et.
        //Arrays.sort()
        //methodu istifade etmeyin.
        //Nümunə:
        //int[] arr = {10, 5, 8, 3, 1};
        //Gözlənilən çıxış:
        //Tərsinə sort edilmiş array: 10 8 5 3 1

//        task4();


        //5.Verilmiş string-i tərsinə çevir.
        //Yeni yaradılmış string-i çap et.
        //Nümunə:
        //String input = "OpenAI";
        //Gözlənilən çıxış:
        //İvers edilmiş string: IanepO

//        task5();


        //6.Verilmiş string-in palindrome olub-olmadığını
        //yoxla.
        //Palindrome: tərsinə oxunduqda da eyni olan söz.
        //Nümunə:
        //String word = "madam";
        //Gözlənilən çıxış:
        //madam palindrome-dur.

//        task6();

        //7.Verilmiş cümlədə hər bir hərfin neçə dəfə
        //təkrarlandığını tap.
        //Boşluq və xüsusi simvolları nəzərə alma.
        //Nümunə:
        //String sentence = "Java is awesome";
        //Gözlənilən çıxış (sadəcə nümunə):
        //a - 3
        //e - 2
        //i - 1
        //j - 1
        //
        //.....
        //her bir herf nezere alinsin

//        task7();

    }

    private static void task7() {
        String sentence = "Java is awesome".toLowerCase();
        int[] lettersCounts = new int[26];
        for (char c : sentence.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                lettersCounts[c - 'a']++;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (lettersCounts[i] != 0) {
                System.out.println((char) ('a' + i) + "-" + lettersCounts[i]);
            }
        }
    }

    private static void task6() {
        String word = "madam".toLowerCase();
        boolean isPalindrome = true;
        int length = word.length();

        for (int i = 0; i < length / 2; i++) {
            if (word.charAt(i) != word.charAt(length - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println(isPalindrome
                ? word + " palindrome-dur"
                : word + " palindrome deyil");
    }

    private static void task5() {
        String input = "OpenAI";
        StringBuilder reversed = new StringBuilder();
        int length = input.length();
        for (int i = length - 1; i >= 0; i--) {
            reversed.append(input.charAt(i));
        }
        System.out.println("İvers edilmiş string: " + reversed);
    }

    private static void task4() {
        int[] arr = {10, 5, 8, 3, 1};
        //sorting
        for (int i = 0; i < arr.length - 1; i++) {
            int smallestIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[smallestIndex]) {
                    smallestIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[smallestIndex];
            arr[smallestIndex] = temp;
        }

        StringBuilder output = new StringBuilder("Tərsinə sort edilmiş array:");
        for (int i = arr.length - 1; i >= 0; i--) {
            output.append(" ").append(arr[i]);
        }
        System.out.println(output);
    }

    private static void task3() {
        int[][][] cube = {
                {
                        {1, 2}, {3, 4}
                },
                {
                        {5, 6}, {7, 8}
                }
        };
        StringBuilder message = new StringBuilder("6-dan böyük ədədlər: ");
        boolean first = true;
        for (int[][] twoDArray : cube) {
            for (int[] oneDArray : twoDArray) {
                for (int number : oneDArray) {
                    if (number > 6) {
                        if (!first) {
                            message.append(", ");
                        }
                        message.append(number);
                        first = false;
                    }
                }
            }
        }
        System.out.println(message);
    }

    private static void task2() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int mainSum = 0;
        int secondarySum = 0;
        for (int i = 0; i < matrix.length; i++) {
            mainSum += matrix[i][i];
            secondarySum += matrix[i][matrix.length - 1 - i];
        }
        System.out.println("Əsas diaqonal cəmi: " + mainSum);
        System.out.println("Köməkçi diaqonal cəmi: " + secondarySum);
    }

    private static void task1() {
        int[] numbers = {4, 7, -2, 15, 0, 99, -100};
        int lengthOfArray = numbers.length;
        if (lengthOfArray == 0) return;
        int smallestNumber = numbers[0];
        int biggestNumber = smallestNumber;
        for (int i = 1; i < lengthOfArray; i++) {
            if (numbers[i] > biggestNumber) {
                biggestNumber = numbers[i];
            } else if (numbers[i] < smallestNumber) {
                smallestNumber = numbers[i];
            }
        }
        System.out.println("Ən böyük ədəd: " + biggestNumber);
        System.out.println("Ən kiçik ədəd: " + smallestNumber);
    }
}
