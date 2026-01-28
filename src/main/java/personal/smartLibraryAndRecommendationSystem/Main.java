package personal.smartLibraryAndRecommendationSystem;

import personal.smartLibraryAndRecommendationSystem.model.Book;
import personal.smartLibraryAndRecommendationSystem.model.BorrowRecord;
import personal.smartLibraryAndRecommendationSystem.model.Library;
import personal.smartLibraryAndRecommendationSystem.model.User;
import personal.smartLibraryAndRecommendationSystem.service.LibraryAnalysis;
import personal.smartLibraryAndRecommendationSystem.service.LibraryService;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // --- Books ---
        Book b1 = new Book("1984", "George Orwell", 1949, 4.9, true);
        Book b2 = new Book("Animal Farm", "George Orwell", 1945, 4.8, false);
        Book b3 = new Book("Clean Code", "Robert Martin", 2008, 4.7, true);
        Book b4 = new Book("Effective Java", "Joshua Bloch", 2018, 4.9, true);
        Book b5 = new Book("The Pragmatic Programmer", "Andy Hunt", 1999, 4.6, true);
        Book b6 = new Book("Java Concurrency in Practice", "Brian Goetz", 2006, 4.5, false);

        List<Book> books = Arrays.asList(b1, b2, b3, b4, b5, b6);

        // --- Users ---
        User u1 = new User("Aydin", 25, Arrays.asList(
                new BorrowRecord(b1, LocalDate.of(2025, 9, 1), LocalDate.of(2025, 9, 10)),
                new BorrowRecord(b3, LocalDate.of(2025, 10, 5), null)
        ));

        User u2 = new User("Leyla", 22, Arrays.asList(
                new BorrowRecord(b4, LocalDate.of(2025, 10, 2), LocalDate.of(2025, 10, 20)),
                new BorrowRecord(b6, LocalDate.of(2025, 10, 12), null)
        ));

        User u3 = new User("Murad", 28, Arrays.asList(
                new BorrowRecord(b5, LocalDate.of(2025, 9, 10), LocalDate.of(2025, 9, 25))
        ));

        List<User> users = Arrays.asList(u1, u2, u3);

        // --- Library ---
        Library library = new Library(books, users);

        // --- Library Analysis ---
        LibraryAnalysis libraryAnalysis = new LibraryAnalysis(library);

        // --- Library Service ---
        LibraryService service = new LibraryService(library, libraryAnalysis);

        System.out.println("Sorted Books:");
        service.sortBooks()
                .forEach(System.out::println);


        System.out.println("\nLibrary Analysis:");
        System.out.println("Average rating: " + libraryAnalysis.getAverageRating());

        System.out.println("\nAvailable after 2000:");
        libraryAnalysis.getBooksByPublishYearMap(2000).forEach(System.out::println);

        System.out.println("\nMost borrowed book:");
        libraryAnalysis.findTheMostBorrowedBook()
                .ifPresent(bookLongEntry ->
                        System.out.println(
                                bookLongEntry.getKey() + " (" + bookLongEntry.getValue() + " times)"));


        System.out.println("\nCurrently reading:");
        libraryAnalysis.getCurrentlyUserReadings()
                .forEach((user, books1) ->
                        System.out.println(user.getName() + "->" + books1));


        System.out.println("\nBooks grouped by author (after 1950):");
        libraryAnalysis.getBooksAuthorMapByYear(1950)
                .forEach((author, books2) ->
                        System.out.println(author + "->" + books2));


        System.out.println("\nAuthors read by users:");
        System.out.println(libraryAnalysis.getAllUniqueAuthors());

        System.out.println("\nRecommendation for Aydin:");
        service.findRecommendedBookForUser(u1)
                .ifPresentOrElse(
                        b -> System.out.println("Recommended: " + b),
                        () -> System.out.println("No recommendation available.")
                );


        System.out.println("\nTop Reader of October 2025:");
        libraryAnalysis.findTopReaderOfMonth(10, 2025)
                .ifPresentOrElse(
                        u -> System.out.println("Top Reader: " + u.getName()),
                        () -> System.out.println("No reader found.")
                );



        // Bonus: calculate reading durations
        System.out.println("\n⏱ Reading Durations:");
        users.stream()
                .flatMap(u -> u.getBorrowHistory().stream())
                .filter(BorrowRecord::isReturned)
                .forEach(r -> {
                    long days = Duration.between(
                            r.getBorrowedDate().atStartOfDay(),
                            r.getReturnedDate().get().atStartOfDay()
                    ).toDays();
                    System.out.println(r.getBook().getTitle() + " read in " + days + " days");
                });

    }
}
