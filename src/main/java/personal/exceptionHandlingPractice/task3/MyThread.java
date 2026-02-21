package personal.exceptionHandlingPractice.task3;

public class MyThread implements Runnable {
    private String name;

    public MyThread(String name) {
        this.name = name;
    }


    @Override
    public void run() {
        for (int i = 0; i < 8; i++) {
            System.out.println(this.name + ": " + i);
        }
    }
}
