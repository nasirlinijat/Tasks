package personal;

public class Book {
    private final String title;
    private final String author;
    private final String isbn;
    protected int totalCopies;
    protected int availableCopies;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.totalCopies = 1;
        this.availableCopies = 1;
    }

    {
        System.out.println("New book created!");
    }

    public static void libraryRules() {
        System.out.println("Max 3 books can be borrowed per person.");
    }

    public void borrowBook() {
        if (this.availableCopies > 0) {
            this.availableCopies--;
            System.out.println("Book borrowed successfully.");
        } else
            System.out.println("Sorry, no copies available.");
    }

    public void returnBook() {
        if (this.availableCopies < this.totalCopies) {
            this.availableCopies++;
            System.out.println("Book returned successfully.");
        } else System.out.println("All copies are already in the library.");
    }

    public void printInfo() {
        System.out.println("Title: " + this.title
                           + "\nAuthor: " + this.author
                           + "\nISBN: " + this.isbn
                           + "\nTotal Copies: " + this.totalCopies
                           + "\nAvailable Copies: " + this.availableCopies
        );
    }

    public final void bookType() {
        System.out.println("This is a regular book.");
    }


    private static class Main {
        public static void main(String[] args) {
            Book book = new Book("Clean Code", "Robert C. Martin", "978-0132350884");

            book.printInfo();
            book.borrowBook();
            book.returnBook();
            Book.libraryRules();
            book.bookType();
        }
    }
}


