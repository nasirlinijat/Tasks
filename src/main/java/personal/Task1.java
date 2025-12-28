package personal;

public class Task1 {
    public static void main(String[] args) {
        //step-1
        int age;
        double height;
        boolean isStudent;

        //step-2
        age = 14;
        height = 1.58;
        isStudent = true;

        printInfo(age, height, isStudent);

        //step-3
        int points = 85;
        double pointsDouble = points;
        System.out.println("\nPoints (int): " + points + "\nPoints (double): " + pointsDouble);

        //step-4
        double averageScore = 89.7;
        int finalScore = (int) averageScore;
        System.out.println("\nAverage score: " + averageScore + "\nFinal score: " + finalScore);
    }

    public static void printInfo(int age, double height, boolean isStudent){
        System.out.println("Student Information: \n"
                         + "Age: " + age
                         + "\nHeight: " + height
                         + "\nIs Student: " + isStudent);
    }
}
