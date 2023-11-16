package Seminar_1.Examples;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Case1Tests {
    @BeforeAll
    public static void globalSetup() {
        // Инициализация
    }

    @AfterAll
    public static void globalTeardown() {
        // Очистка
    }

    @BeforeEach
    public void setup() {
        // Инициализация ресурсов
    }

    @AfterEach
    public void teardown() {
        // Очистка ресурсов
    }

    @Test
    public void testMethod1() {
        Assertions.assertEquals(5, 2 + 3);
    }

    @Test
    @DisplayName("Тест суммирования")
    public void testSum() {
        Assertions.assertEquals(5, 2 + 3);
    }

    @Test
    @Disabled
    public void testMethod2() {
        // этот тест не будет запущен
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void testMethod3(int argument) {
        assertTrue(argument > 0);
    }
}
