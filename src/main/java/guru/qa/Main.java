package guru.qa;



public class Main {
    public static void main(String[] args) {

        // 0) Арифметика с двумя int
        System.out.println("=== 0) int + int ===");
        int a = 10;
        int b = 3;
        System.out.println("a + b = " + (a + b));   // 13
        System.out.println("a - b = " + (a - b));   // 7
        System.out.println("a * b = " + (a * b));   // 30
        System.out.println("a / b = " + (a / b));   // 3
        System.out.println("a % b = " + (a % b));   // 1

        // 1) Арифметика с int и double
        System.out.println("\n=== 1) int + double ===");
        int x = 7;
        double y = 2.5;
        System.out.println("x + y = " + (x + y));   // 9.5
        System.out.println("x - y = " + (x - y));   // 4.5
        System.out.println("x * y = " + (x * y));   // 17.5
        System.out.println("x / y = " + (x / y));   // 2.8

        // 2) Логические операции сравнения
        System.out.println("\n=== 2) Сравнения ===");
        int p = 5;
        int q = 10;
        System.out.println("p < q:  " + (p < q));    // true
        System.out.println("p > q:  " + (p > q));    // false
        System.out.println("p <= 5: " + (p <= 5));   // true
        System.out.println("q >= 10:" + (q >= 10));  // true
        System.out.println("p == q: " + (p == q));   // false
        System.out.println("p != q: " + (p != q));   // true

        // 3) Диапазоны типов
        System.out.println("\n=== 3) Диапазоны ===");
        System.out.println("int max:    " + Integer.MAX_VALUE);   //  2147483647
        System.out.println("int min:    " + Integer.MIN_VALUE);   // -2147483648
        System.out.println("long max:   " + Long.MAX_VALUE);
        System.out.println("float max:  " + Float.MAX_VALUE);
        System.out.println("float min:  " + Float.MIN_VALUE);     // мин. положительное
        System.out.println("double max: " + Double.MAX_VALUE);
        System.out.println("double min: " + Double.MIN_VALUE);
        System.out.println("double +inf:" + Double.POSITIVE_INFINITY);
        System.out.println("double NaN: " + Double.NaN);

        // 4) Переполнение
        System.out.println("\n=== 4) Переполнение ===");
        int maxInt = Integer.MAX_VALUE;
        System.out.println("MAX_VALUE:     " + maxInt);           //  2147483647
        System.out.println("MAX_VALUE + 1: " + (maxInt + 1));    // -2147483648 (!)

        int minInt = Integer.MIN_VALUE;
        System.out.println("MIN_VALUE:     " + minInt);           // -2147483648
        System.out.println("MIN_VALUE - 1: " + (minInt - 1));    //  2147483647 (!)

        double bigDouble = Double.MAX_VALUE;
        System.out.println("double overflow: " + (bigDouble * 2)); // Infinity


        }

    }




