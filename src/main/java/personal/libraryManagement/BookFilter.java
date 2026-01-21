package personal.libraryManagement;

public interface BookFilter {
    boolean filter(Library<?>.Book book);
}
