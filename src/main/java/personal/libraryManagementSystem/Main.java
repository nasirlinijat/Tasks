package personal.libraryManagementSystem;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Book book1 = new Book("1984", "George Orwell", "Science-fiction", 1949);
        Book book2 = new Book("1984", "George Orwell", "Science-fiction", 1949);
        Book book3 = new Book("Pride and Prejudice", "Jane Austen", "Romance", 1813);
        Book book4 = new Book("To Kill a Mockingbird", "Harper Lee", "Fiction", 1960);
        Book book5 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "Classic", 1925);
        Book book6 = new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy", 1937);
        Book book7 = new Book("A Brief History of Time", "Stephen Hawking", "Science", 1988);
        Book book8 = new Book("The Da Vinci Code", "Dan Brown", "Thriller", 2003);


        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);
        library.addBook(book6);
        library.addBook(book7);
        library.addBook(book8);


        part1(book1, book2, book3);
        part2(library, book4);
        part3(library);


    }

    private static void part3(Library library) {
//        Collections.sort(library.getBooks());//compareTo()

//        Collections.sort(library.getBooks(), new BookPublicationYearComparator());
//        Collections.sort(library.getBooks(), new BookAuthorComparator());

        library.displayAll();

    }

    private static void part2(Library library, Book book4) {
        library.displayAll();

        library.removeBook(book4);

        System.out.println(library.findByTitle("The Great Gatsby"));
        System.out.println(library.findByAuthor("F. Scott Fitzgerald"));
        System.out.println(library.findByGenre("Classic"));

        System.out.println(library.totalCount());
    }

    private static void part1(Book book1, Book book2, Book book3) {
        System.out.println(book1);
        System.out.println(book3);

        System.out.println("book1 == book2: " + (book1 == book2)); //f
        System.out.println("book1 == book3: " + (book1 == book3)); //f

        System.out.println("book1.equals(book2): " + book1.equals(book2)); //t
        System.out.println("book1.equals(book3): " + book1.equals(book3)); //f
    }
}
