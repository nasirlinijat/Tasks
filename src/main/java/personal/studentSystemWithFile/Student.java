package personal.studentSystemWithFile;

public class Student {
    private long studentId;
    private String name;
    private double score;

    public Student(long studentId, String name, double score) {
        this.studentId = studentId;
        this.name = name;
        this.score = score;
    }

    public Student() {
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "StudentId: " + studentId + ", Name: " + name + ", Score: " + score;
    }
}
