import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        double[] array = generateRandomArray(100000000);
        Arrays.sort(array);
        System.out.println("Массив длиной: " + array.length + " отсортирован...");

        long time = System.currentTimeMillis();

        binarySearchRecursively(array, 0.5);
        System.out.println("Время работы программы: " + (System.currentTimeMillis() - time) + " мс");
    }

    private static int binarySearchRecursively(double[] sortedArray, double key) {
        System.out.println("Двоичный поиск запущен... ");
        return binarySearchRecursively(sortedArray, key, 0, sortedArray.length);
    }

    /**
     * Вспомогательный метод для {@link #binarySearchRecursively(double[], double)}
     *
     * Будем делить отрезок пополам, но не копировать, а просто "сдвигать границы",
     * и вызывать этот же метод рекурсивно. Для этого используем low и high
     *
     * @param sortedArray сортированный массив
     * @param key искомое значение
     * @param low от какого значения ищем
     * @param high до какого значения ищем
     * @return индекс элемента
     */
    private static int binarySearchRecursively(
            double[] sortedArray, double key, int low, int high) {
        int middle = (low + high) / 2; // середина

        if (high < low) { // больше делить нечего
            System.out.println(sortedArray[middle]);
            System.out.println("Элемент: + " +  key +  " не найден.\n Программа завершается...");
            return -1;
        }

        if (key == sortedArray[middle]) { // если нашелся, возвращаем элемент из середины
            System.out.println("Элемент: " + key + " найден - " + sortedArray[middle]);
            return middle;
        } else if (key < sortedArray[middle]) { // иначе смотрим в левой половине
            System.out.println(sortedArray[middle]);
            return binarySearchRecursively(
                    sortedArray, key, low, middle - 1);
        } else {
            System.out.println(sortedArray[middle]);
            return binarySearchRecursively( // иначе смотрим в правой половине
                    sortedArray, key, middle + 1, high);
        }
    }

    // Метод для генерации тестого массива
    private static double[] generateRandomArray(int length) {
        double[] array = new double[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Math.random() * 1000000;
        }
        System.out.println("Массив длиной: " + array.length + " сгенерирован...");
        return array;
    }
}
