package personal.libraryManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library<T extends Library.Section> {
    private List<T> sections;

    public Library() {
        this.sections = new ArrayList<>();
    }

    public List<T> getSections() {
        return sections;
    }

    public void addSection(T section) {
        this.sections.add(section);
    }

    public void displayAllSections() {
        this.sections.forEach(section -> {
            System.out.println("\nSection: " + section.getName());
            section.displayBooks();
        });
    }

    public List<Library<?>.Book> filterBooks(BookFilter filter) {
        return this.sections
                .stream()
                .flatMap(section -> section.getBooks().stream())
                .filter(book -> filter.filter(book))
                .collect(Collectors.toList());
    }


    public class Book {
        private String title;
        private String author;
        private int year;

        public Book(String title, String author, int year) {
            this.title = title;
            this.author = author;
            this.year = year;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public int getYear() {
            return year;
        }


        @Override
        public String toString() {
            return "-Book{" +
                   "title='" + title + '\'' +
                   ", author='" + author + '\'' +
                   ", year=" + year +
                   '}';
        }
    }

    public static class Section {
        private String name;
        private List<Library<?>.Book> books;

        public Section(String name) {
            this.name = name;
            this.books = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public List<Library<?>.Book> getBooks() {
            return books;
        }

        public void addBook(Library<?>.Book book) {
            this.books.add(book);
        }

        public void displayBooks() {
            this.books.forEach(System.out::println);
        }

    }
}
