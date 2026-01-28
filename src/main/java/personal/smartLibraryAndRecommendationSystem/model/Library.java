package personal.smartLibraryAndRecommendationSystem.model;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Library {
    private final List<Book> books;
    private final List<User> users;

    public Library(List<Book> books, List<User> users) {
        this.books = books;
        this.users = users;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addUser(User user) {
        users.add(user);
    }


    public void finishBorrowRecord(BorrowRecord borrowRecord, LocalDate returnDate) {
        borrowRecord.markAsReturned(returnDate);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public boolean containsBook(Book book) {
        return books.contains(book);
    }

    public boolean containsUser(User user) {
        return users.contains(user);
    }

    public boolean checkBookExistsByAuthor(String author) {
        return books.stream()
                .anyMatch(book -> book.getAuthor().equals(author));
    }


    public Stream<Book> getAvailableBooks() {
        return books.stream()
                .filter(Book::isAvailable);
    }

    public List<Book> getAllBooks() {
        return Collections.unmodifiableList(books);
    }

    public List<User> getUsers() {
        return Collections.unmodifiableList(users);
    }


}
