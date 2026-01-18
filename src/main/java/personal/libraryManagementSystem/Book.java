package personal.libraryManagementSystem;

import java.util.Objects;

public class Book implements Comparable<Book>{
    private final String title;
    private final String author;
    private final String genre;
    private final int publicationYear;

    public Book(String title, String author, String genre, int publicationYear) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publicationYear = publicationYear;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return publicationYear == book.publicationYear &&
               Objects.equals(title, book.title) &&
               Objects.equals(author, book.author) &&
               genre == book.genre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, genre, publicationYear);
    }

    @Override
    public String toString() {
        return "Book{" +
               "title='" + title + '\'' +
               ", author='" + author + '\'' +
               ", genre=" + genre +
               ", publicationYear=" + publicationYear +
               '}';
    }

    @Override
    public int compareTo(Book o) {
        return this.title.compareTo(o.title);
    }
}
