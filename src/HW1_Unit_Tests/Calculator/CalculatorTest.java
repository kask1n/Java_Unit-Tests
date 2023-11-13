package HW1_Unit_Tests.Calculator;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class CalculatorTest {
    public static void main(String[] args) {
        // Проверка базового функционала с целыми числами:
        if (8 != Calculator.calculation(2, 6, '+')) {
            throw new AssertionError("Ошибка в методе");
        }

        if (0 != Calculator.calculation(2, 2, '-')) {
            throw new AssertionError("Ошибка в методе");
        }

        if (14 != Calculator.calculation(2, 7, '*')) {
            throw new AssertionError("Ошибка в методе");
        }

        if (2 != Calculator.calculation(100, 50, '/')) {
            throw new AssertionError("Ошибка в методе");
        }

        // Случаи с неправильными аргументами
        // аргумент operator типа char, должен вызывать исключение, если он получает не базовые символы (+-*/)
        // try {
        //     HW1_Unit_Tests.Calculator.Calculator.calculation(8, 4, '_');
        // } catch (IllegalStateException e) {
        //     if (!e.getMessage().equals("Unexpected value operator: _")) {
        //         throw new AssertionError("Ошибка в методе");
        //     }
        // }

        // Проверка базового функционала с целыми числами, с использованием утверждений:
        assert 8 == Calculator.calculation(2, 6, '+');
        assert 0 == Calculator.calculation(2, 2, '-');
        assert 14 == Calculator.calculation(2, 7, '*');
        assert 2 == Calculator.calculation(100, 50, '/');

        // Проверка базового функционала с целыми числами, с использованием утверждений AssertJ:
//        assertThat(Calculator.calculation(2, 6, '+')).isEqualTo(8);
//        assertThat(Calculator.calculation(2, 2, '-')).isEqualTo(0);
//        assertThat(Calculator.calculation(2, 7, '*')).isEqualTo(14);
//        assertThat(Calculator.calculation(100, 50, '/')).isEqualTo(2);

        // Проверка ожидаемого исключения, с использованием утверждений AssertJ:
//        assertThatThrownBy(() ->
//                Calculator.calculation(8, 4, '_')
//        ).isInstanceOf(IllegalStateException.class);

        System.out.println(Calculator.calculation(2_147_483_647, 1, '+')); // integer overflow
        System.out.println(Calculator.squareRootExtraction(169));

        // Примерные решения домашних заданий из 1 лекции:

        // HW1.1: Придумайте и опишите (можно в псевдокоде) функцию извлечения корня и
        // необходимые проверки для него используя граничные случаи
        // assertThatThrownBy(() ->
        //         HW1_Unit_Tests.Calculator.Calculator.squareRootExtraction(0, 1, -1)
        // ).isInstanceOf(SomeStateException.class);

        // HW1.2: Как будет выглядеть проверка для случая деления на ноль? (с использованием AssertJ)
        // assertThatThrownBy(() ->
        //        HW1_Unit_Tests.Calculator.Calculator.calculation(5, 0, '/')
        // ).isInstanceOf(ArithmeticException.class);

        // HW1.3: Сравните одну и ту же проверку с использованием условий, ассертов, AssertJ
        // в каком случае стандартное сообщение об ошибке будет более информативным?
        // if (0 != HW1_Unit_Tests.Calculator.Calculator.calculation(2, 6, '+')) {
        //     throw new AssertionError("Ошибка в методе");
        // }
        //   assert 0 == HW1_Unit_Tests.Calculator.Calculator.calculation(2, 6, '+');
        //    assertThat(HW1_Unit_Tests.Calculator.Calculator.calculation(2, 6, '+')).isEqualTo(0);
    }


    // ДОМАШНЯЯ РАБОТА:
    //Задание 1. ** В классе Calculator создайте метод calculateDiscount, который принимает сумму
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

    //тест1. Проверяем правильность расчета суммы со скидкой
    @org.junit.jupiter.api.Test
    public void test1CalculatingDiscount() {
        Calculator calculator = new Calculator();

        double res1 = Calculator.calculatingDiscount(100, 10);
        assertThat(res1, equalTo(90.0));
    }

    //тест2. Если сумма покупок = 0, результатом будет 0.
    @org.junit.jupiter.api.Test
    public void test2CalculatingDiscount() {
        Calculator calculator = new Calculator();

        double res1 = Calculator.calculatingDiscount(00.0, 10);
        assertThat(res1, equalTo(0.0));
    }

    //тест3. Проверка выброса ошибки при недопустимых аргументах путем сравнения с ожидаемой
    @org.junit.jupiter.api.Test
    public void test3CalculatingDiscount() {
        Calculator calculator = new Calculator();
        String message = "invalid arguments";
        Exception exception = assertThrows(ArithmeticException.class, () ->
                Calculator.calculatingDiscount(-100, 2));
        assertEquals(message, exception.getMessage());
    }
}