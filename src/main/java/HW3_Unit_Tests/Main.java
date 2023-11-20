package HW3_Unit_Tests;

public class Main {
    static class MathOperations {
        public static boolean evenOddNumber(int n) {
            return (n % 2 == 0);
        }

        public static boolean numberInInterval(int num) {
            return num > 25 && num < 100;
        }
    }
}
