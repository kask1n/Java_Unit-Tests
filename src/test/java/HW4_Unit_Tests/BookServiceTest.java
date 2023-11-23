package HW4_Unit_Tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceTest {
    private BookRepository bookRepositoryMock;
    private BookService bookService;
    private Book book;

    @BeforeEach
    public void setUp() {
        bookRepositoryMock = mock(BookRepository.class);
        bookService = new BookService(bookRepositoryMock);
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void findById() {
        when(bookService.findById("1")).thenReturn(new Book("1", "Book_1", "Author_1"));

        String expectIdBook = "1";
        String actualIdBook = bookService.findById("1").getId();

        verify(bookRepositoryMock).findById("1");

        assertEquals(expectIdBook, actualIdBook, "Метод findById возвращает Id другой книги.");
    }

    @Test
    public void findAll() {
        when(bookService.findAll()).thenReturn(new ArrayList<>(Arrays.asList(new Book("1"), new Book("2"), new Book("3"), new Book("4"))));

        int expectSizeList = 4;
        int actualSizeList = bookService.findAll().size();

        verify(bookRepositoryMock).findAll();

        assertEquals(expectSizeList, actualSizeList, "Метод findAll возвращает другой список книг.");
    }
}
