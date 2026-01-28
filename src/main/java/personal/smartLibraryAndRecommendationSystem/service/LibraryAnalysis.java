package personal.smartLibraryAndRecommendationSystem.service;

import personal.smartLibraryAndRecommendationSystem.model.Book;
import personal.smartLibraryAndRecommendationSystem.model.BorrowRecord;
import personal.smartLibraryAndRecommendationSystem.model.Library;
import personal.smartLibraryAndRecommendationSystem.model.User;

import java.util.*;
import java.util.stream.Collectors;

public class LibraryAnalysis {
    private final Library library;

    public LibraryAnalysis(Library library) {
        this.library = library;
    }

    public double getAverageRating() {
        return library.getAvailableBooks()
                .mapToDouble(Book::getRating)
                .average()
                .orElse(0.0);
    }

    public Map<User, List<Book>> getCurrentlyUserReadings() {
        return library.getUsers().stream()
                .collect(Collectors.toMap(
                        user -> user, // key = user
                        user -> user.getBorrowHistory().stream()
                                .filter(record -> !record.isReturned()) // only active borrowings
                                .map(BorrowRecord::getBook)
                                .toList()
                ));
    }

    public Optional<Map.Entry<Book, Long>> findTheMostBorrowedBook() {
        return library.getUsers().stream()
                .flatMap(user -> user.getBorrowHistory().stream())
                .map(BorrowRecord::getBook)
                .collect(Collectors.groupingBy(book -> book, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue());
    }

    public Map<String, List<Book>> getUserNameAndNotReturnedBooksMap() {
        return library
                .getUsers()
                .stream()
                .collect(Collectors.toMap(
                        User::getName,
                        user -> user.getBorrowHistory()
                                .stream()
                                .filter(borrowRecord -> !borrowRecord.isReturned())
                                .map(BorrowRecord::getBook)
                                .collect(Collectors.toList())
                ));

    }

    public List<Book> getBooksByPublishYearMap(int year) {
        return library.getAvailableBooks()
                .filter(book -> book.getYear() > year)
                .collect(Collectors.toList());
    }

    public Optional<String> getTheMostBorrowedBookOfAuthorByUser(User user) {
        return user.getBorrowHistory()
                .stream()
                .map(borrowRecord -> borrowRecord.getBook().getAuthor())
                .collect(Collectors.groupingBy(
                        author -> author,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
    }

    public Optional<Book> getTheHighestRatingBookByAuthor(String author) {
        return library.getAvailableBooks()
                .filter(book -> book.getAuthor().equals(author))
                .max(Comparator.comparingDouble(Book::getRating));
    }

    public Set<String> getAllUniqueAuthors() {
        return library.getUsers()
                .stream()
                .flatMap(user -> user.getBorrowHistory().stream())
                .map(record -> record.getBook().getAuthor())
                .collect(Collectors.toSet());
    }

    public Optional<User> findTopReaderOfMonth(int month, int year) {
        return library.getUsers()
                .stream()
                .max(Comparator.comparingLong(user ->
                        user.getBorrowHistory().stream()
                                .filter(borrowRecord ->
                                        borrowRecord.getBorrowedDate().getYear() == year &&
                                        borrowRecord.getBorrowedDate().getMonth().getValue() == month)
                                .count()));
    }

    public Map<String, Book> getBooksAuthorMapByYear(int year) {
        return library.getAllBooks()
                .stream()
                .filter(book -> book.getYear() > year)
                .collect(Collectors.toMap(
                        Book::getAuthor,
                        book -> book
                ));
    }

    public Optional<Book> getMostRecentBookOfAuthor(String author) {
        return library.getAvailableBooks()
                .filter(book -> book.getAuthor().equals(author))
                .max(Comparator.comparingInt(Book::getYear));
    }

    public List<Book> getBooksByAuthor(String author) {
        return library.getAvailableBooks()
                .filter(book -> book.getAuthor().equals(author))
                .collect(Collectors.toList());
    }

}
