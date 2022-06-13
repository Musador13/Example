import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static int B = scanner.nextInt();
    static int H = scanner.nextInt();
    static boolean check = true;

    static {
        try {
            if (B <= 0 || H <= 0) {
                check = false;
                throw new Exception("Breadth and height must be positive");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        if (check) {
            System.out.println(B * H);
        }
    }

    /**
     * Нахождение и вывод в консоль максимального,
     * минимального и среднего числа в массиве случайных чисел
     */
    private static void test1() {
        int n = 100;
        double[] array = new double[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = Math.random();
        }
        double max = array[0];
        double min = array[0];
        double avg = 0;
        for (int i = 0; i < array.length; i++) {
            if (max < array[i])
                max = array[i];
            if (min > array[i])
                min = array[i];
            avg += array[i] / array.length;
        }
        System.out.println("max = " + max);
        System.out.println("min = " + min);
        System.out.println("avg = " + avg);
    }

    /**
     * Реализация алгоритма "сортировка пузырьком"
     */
    private static void test2() {
        int n = 100;
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 10000);
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    /**
     * Вывести все простые числа до 100
     */
    private static void test3() {
        for (int i = 2; i <= 100; i++) {
            boolean isPrime = true;

            for (int j = 2; j < i; j++) {
                if (i % 2 == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                System.out.println(i);
            }
        }
    }

    /**
     * Выводит все простые числа до 100, используя циклы с метаками
     */
    private static void test4() {
        out_for:
        for (int i = 2; i <= 100; i++) {
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    continue out_for;
                }
            }
            System.out.println(i);
        }

    }

    /**
     * Дан массив и число. Удаляет все вхождения числа в массив и не оставляет пропусков.
     */
    private static void test5() {
        int n = 100;
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        System.out.println(Arrays.toString(removeElement(array, 3)));
    }

    private static int[] removeElement(int[] nums, int val) {
        int offset = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                offset++;
            } else {
                nums[i - offset] = nums[i];
            }
        }

        // Arrays.copyOf копирует значение из массива nums в новый массив
        // с длинной nums.length - offset
        return Arrays.copyOf(nums, nums.length - offset);
    }

    public static class Vector {
        // Три приватных поля
        private double x;
        private double y;
        private double z;

        // Конструктор с тремя параметрами
        public Vector(double x, double y, double z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        //Длина вектора. Корень из суммы квадратов
        public double length() {
            return Math.sqrt(x * x + y * y + z * z);
        }

        // Метод, вычисляющий скалярное произведение
        public double scalarProduct(Vector vector) {
            return x * vector.x + y * vector.y + z * vector.z;
        }

        public Vector crossProduct(Vector vector) {
            return new Vector(
                    y * vector.z - z * vector.y,
                    z * vector.x - x * vector.z,
                    x * vector.y - y * vector.x);
        }

        // Косинус между двумя векторами
        public double cos(Vector vector) {
            // Для вычисления длины и произведения используются
            //методы multiply и length
            return scalarProduct(vector) / (length() * vector.length());
        }

        public Vector add(Vector vector) {
            return new Vector(
                    x + vector.x,
                    y + vector.y,
                    z + vector.z
            );
        }

        public Vector subtract(Vector vector) {
            return new Vector(
                    x - vector.x,
                    y - vector.y,
                    z - vector.z
            );
        }

        public static Vector[] generate(int n) {
            Vector[] vectors = new Vector[n];
            for (int i = 0; i < n; i++) {
                vectors[i] = new Vector(Math.random(), Math.random(), Math.random());
            }
            return vectors;
        }

        @Override
        public String toString() {
            return "Vector{" +
                    "x=" + x +
                    ", y=" + y +
                    ", z=" + z +
                    '}';
        }

    }

    /**
     * Метод проверяет перебором входит ли в массив заданный элемент или нет
     *
     * @param array заданный массив
     * @param key   элемент, который проверяется
     * @return возвращаем элемент если он есть в массиве или -1 если нет
     */
    private static int bruteForce(double[] array, double key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key)
                return i;
        }
        return -1;
    }


}
