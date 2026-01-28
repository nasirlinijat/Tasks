package personal.smartLibraryAndRecommendationSystem.model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class User {
    private final String name;
    private final int age;
    private final List<BorrowRecord> borrowHistory;

    public User(String name, int age, List<BorrowRecord> borrowRecords) {
        this.name = name;
        this.age = age;
        this.borrowHistory = borrowRecords;
    }

    public void addBorrowRecord(BorrowRecord borrowRecord) {
        borrowHistory.add(borrowRecord);
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<BorrowRecord> getBorrowHistory() {
        return Collections.unmodifiableList(borrowHistory);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name) && Objects.equals(borrowHistory, user.borrowHistory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, borrowHistory);
    }


}
