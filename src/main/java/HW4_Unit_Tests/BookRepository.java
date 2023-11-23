package HW4_Unit_Tests;

import java.util.List;

public interface BookRepository {
    Book findById(String id);

    List<Book> findAll();
}
