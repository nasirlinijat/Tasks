package personal.smartLibraryAndRecommendationSystem.model;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;

public class BorrowRecord {
    private final Book book;
    private final LocalDate borrowedDate;
    private LocalDate returnedDate;

    public BorrowRecord(Book book, LocalDate borrowedDate, LocalDate returnedDate) {
        this.book = book;
        this.borrowedDate = borrowedDate;
        this.returnedDate = returnedDate;
    }

    public void markAsReturned(LocalDate returnDate) {
        returnedDate = returnDate;
        book.markAsReturned();
    }

    public boolean isReturned() {
        return returnedDate != null;
    }

    public Optional<LocalDate> getReturnedDate() {
        return Optional.ofNullable(returnedDate);
    }

    public Book getBook() {
        return book;
    }


    public LocalDate getBorrowedDate() {
        return borrowedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BorrowRecord that = (BorrowRecord) o;
        return Objects.equals(book, that.book) && Objects.equals(borrowedDate, that.borrowedDate) && Objects.equals(returnedDate, that.returnedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(book, borrowedDate, returnedDate);
    }
}
