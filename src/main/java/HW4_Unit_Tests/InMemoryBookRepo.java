package HW4_Unit_Tests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryBookRepo implements BookRepository {
    private final Map<String, Book> books;

    public InMemoryBookRepo() {
        this.books = new HashMap<>();
        books.put("1", new Book("1", "Book_1", "Author_1"));
        books.put("2", new Book("2", "Book_2", "Author_2"));
    }

    @Override
    public Book findById(String id) {
        return books.get(id);
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(books.values());
    }
}
