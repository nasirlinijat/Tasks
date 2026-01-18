package personal.libraryManagementSystem;

import java.util.Comparator;

public class BookPublicationYearComparator implements Comparator<Book> {
    @Override
    public int compare(Book book1, Book book2) {
        return Integer.compare(book1.getPublicationYear(), book2.getPublicationYear());
    }
}
