package personal.studentSystemWithFile;


import java.io.*;

public class FileUtil {
    public static final String STUDENT_DATA_FILE_PATH = "src/main/java/personal/studentSystemWithFile/students.txt";

    public static void overwriteToFile(Student student) {
        writeToFile(student, false);
    }

    public static void appendToFile(Student student) {
        writeToFile(student, true);
    }

    private static void writeToFile(Student student, boolean append) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(STUDENT_DATA_FILE_PATH, append))) {
            bw.write(student.toString() + '\n');
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(STUDENT_DATA_FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException("Error: students.txt file not found.", e);
        } catch (IOException e) {
            throw new RuntimeException("Error: Unable to read/write the file.", e);
        }
    }
}
