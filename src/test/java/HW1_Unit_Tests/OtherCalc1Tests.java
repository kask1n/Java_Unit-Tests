package HW1_Unit_Tests;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OtherCalc1Tests {
    public static void main(String[] args) {
        // Проверка базового функционала с целыми числами:
        if (8 != OtherCalc.calculation(2, 6, '+')) {
            throw new AssertionError("Ошибка в методе");
        }

        if (0 != OtherCalc.calculation(2, 2, '-')) {
            throw new AssertionError("Ошибка в методе");
        }

        if (14 != OtherCalc.calculation(2, 7, '*')) {
            throw new AssertionError("Ошибка в методе");
        }

        if (2 != OtherCalc.calculation(100, 50, '/')) {
            throw new AssertionError("Ошибка в методе");
        }

        // Случаи с неправильными аргументами
        // аргумент operator типа char, должен вызывать исключение, если он получает не базовые символы (+-*/)
        try {
            OtherCalc.calculation(8, 4, '_');
        } catch (IllegalStateException e) {
            if (!e.getMessage().equals("Unexpected value operator: _")) {
                throw new AssertionError("Ошибка в методе");
            }
        }

        // Проверка базового функционала с целыми числами, с использованием утверждений:
        assert 8 == OtherCalc.calculation(2, 6, '+');
        assert 0 == OtherCalc.calculation(2, 2, '-');
        assert 14 == OtherCalc.calculation(2, 7, '*');
        assert 2 == OtherCalc.calculation(100, 50, '/');

        // Проверка базового функционала с целыми числами, с использованием утверждений AssertJ:
        assertThat(OtherCalc.calculation(2, 6, '+')).isEqualTo(8);
        assertThat(OtherCalc.calculation(2, 2, '-')).isEqualTo(0);
        assertThat(OtherCalc.calculation(2, 7, '*')).isEqualTo(14);
        assertThat(OtherCalc.calculation(100, 50, '/')).isEqualTo(2);

        // Проверка ожидаемого исключения, с использованием утверждений AssertJ:
        assertThatThrownBy(() ->
                OtherCalc.calculation(8, 4, '_')
        ).isInstanceOf(IllegalStateException.class);

        System.out.println(OtherCalc.calculation(2_147_483_647, 1, '+')); // integer overflow
        System.out.println(OtherCalc.squareRootExtraction(169));

        // Примерные решения домашних заданий из 1 лекции:

        // HW1.1: Придумайте и опишите (можно в псевдокоде) функцию извлечения корня и
        // необходимые проверки для него используя граничные случаи
        assertThatThrownBy(() ->
                OtherCalc.squareRootExtraction(-1)
        ).isInstanceOf(IllegalArgumentException.class);

        // HW1.2: Как будет выглядеть проверка для случая деления на ноль? (с использованием AssertJ)
        assertThatThrownBy(() ->
                OtherCalc.calculation(5, 0, '/')
        ).isInstanceOf(ArithmeticException.class);

        // HW1.3: Сравните одну и ту же проверку с использованием условий, утверждений, AssertJ
        // в каком случае стандартное сообщение об ошибке будет более информативным?
        if (0 != OtherCalc.calculation(2, 6, '+')) {
            throw new AssertionError("Ошибка в методе");
        }
        assert 0 == OtherCalc.calculation(2, 6, '+');
        assertThat(OtherCalc.calculation(2, 6, '+')).isEqualTo(0);
    }


    // ДОМАШНЯЯ РАБОТА:
    //Задание 1. ** В классе OtherCalc создайте метод calculateDiscount, который принимает сумму
    // покупки и процент скидки и возвращает сумму с учетом скидки. Ваша задача - проверить этот метод
    // с использованием библиотеки AssertJ. Если метод calculateDiscount получает недопустимые аргументы,
    // он должен выбрасывать исключение ArithmeticException. Не забудьте написать тесты для проверки этого
    // поведения.

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    // Тест1. Проверяем правильность расчета суммы со скидкой
    @org.junit.jupiter.api.Test
    public void test1CalculatingDiscount() {

        double res1 = OtherCalc.calculatingDiscount(100, 10);
        MatcherAssert.assertThat(res1, equalTo(90.0));
    }

    // Тест2. Если сумма покупок = 0, результатом будет 0.
    @org.junit.jupiter.api.Test
    public void test2CalculatingDiscount() {

        double res1 = OtherCalc.calculatingDiscount(00.0, 10);
        MatcherAssert.assertThat(res1, equalTo(0.0));
    }

    // Тест3. Проверка выброса ошибки при недопустимых аргументах путем сравнения с ожидаемой
    @org.junit.jupiter.api.Test
    public void test3CalculatingDiscount() {
        String message = "invalid arguments";
        Exception exception = assertThrows(ArithmeticException.class, () ->
                OtherCalc.calculatingDiscount(-100, 2));
        Assertions.assertEquals(message, exception.getMessage());
    }
}
