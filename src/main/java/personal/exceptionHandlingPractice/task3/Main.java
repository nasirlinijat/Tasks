package personal.exceptionHandlingPractice.task3;

public class Main {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyThread("Thread 1"));
        Thread thread2 = new Thread(new MyThread("Thread 2"));
        thread1.start();
        thread2.start();
    }
}
