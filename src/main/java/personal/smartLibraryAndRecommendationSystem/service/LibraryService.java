package personal.smartLibraryAndRecommendationSystem.service;

import personal.smartLibraryAndRecommendationSystem.model.Book;
import personal.smartLibraryAndRecommendationSystem.model.Library;
import personal.smartLibraryAndRecommendationSystem.model.User;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LibraryService {
    private final Library library;
    private final LibraryAnalysis libraryAnalysis;

    public LibraryService(Library library, LibraryAnalysis libraryAnalysis) {
        this.library = library;
        this.libraryAnalysis = libraryAnalysis;
    }

    public Optional<Book> findRecommendedBookForUser(User user) {
        if (user.getBorrowHistory().isEmpty()) return Optional.empty();
        if (!library.containsUser(user)) return Optional.empty();
        return this.getHighestRatingBookFromUsersFavoriteAuthor(user)
                .filter(library::containsBook);
    }

    public List<Book> sortBooks() {
        return library.getAvailableBooks()
                .sorted(
                        Comparator.comparing(Book::getRating).reversed()
                                .thenComparing(Book::getYear)
                                .thenComparing(Book::getTitle)
                )
                .collect(Collectors.toList());
    }

    private Optional<Book> getHighestRatingBookFromUsersFavoriteAuthor(User user) {
        return libraryAnalysis.getTheMostBorrowedBookOfAuthorByUser(user)
                .flatMap(libraryAnalysis::getTheHighestRatingBookByAuthor);
    }


}
