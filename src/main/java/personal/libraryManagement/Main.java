package personal.libraryManagement;

import personal.libraryManagement.Library.Section;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Library<Section> library = new Library<>();

        // Bölmələr
        Section fiction = new Section("Fiction");
        Section science = new Section("Science");

        // Kitablar (inner class)
        Library<Section>.Book b1 = library.new Book("The Martian", "Andy Weir", 2011);
        Library<Section>.Book b2 = library.new Book("Project Hail Mary", "Andy Weir", 2021);
        Library<Section>.Book b3 = library.new Book("A Brief History of Time", "Stephen Hawking", 1988);

        // Kitabları bölmələrə əlavə et
        fiction.addBook(b1);
        fiction.addBook(b2);
        science.addBook(b3);

        // Bölmələri kitabxanaya əlavə et
        library.addSection(fiction);
        library.addSection(science);

        // Bölmələri göstər
        library.displayAllSections();

        // Anonymous class ilə filter
        System.out.println("\nFiltered books (Books years greater than 2015):");
        List<Library<?>.Book> filteredBooks = library.filterBooks(new BookFilter() {
            @Override
            public boolean filter(Library<?>.Book book) {
                return book.getYear() > 2015;
            }
        });
        filteredBooks.forEach(System.out::println);

    }
}
