package personal.libraryManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private final ArrayList<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public void removeBook(Book book) {
        this.books.remove(book);
    }

    public List<Book> findByTitle(String title) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : this.books) {
            if (book.getTitle().equals(title)) foundBooks.add(book);
        }
        return foundBooks;
    }

    public List<Book> findByAuthor(String author) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : this.books) {
            if (book.getAuthor().equals(author)) foundBooks.add(book);
        }
        return foundBooks;
    }

    public List<Book> findByGenre(String genre) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : this.books) {
            if (book.getGenre().equals(genre)) foundBooks.add(book);
        }
        return foundBooks;
    }

    public void displayAll() {
        System.out.println("{");
        for (Book book : this.books) {
            System.out.println(book.toString());
        }
        System.out.println("}");
    }

    public long totalCount() {
        return this.books.size();
    }

    @Override
    public String toString() {
        return "Library{" +
               "books=" + this.books +
               '}';
    }
}
