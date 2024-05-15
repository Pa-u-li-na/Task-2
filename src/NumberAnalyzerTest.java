import static org.junit.Assert.*;
import org.junit.Test;

import java.io.IOException;
import java.io.FileWriter;
import java.util.*;



public class NumberAnalyzerTest {

    // Тестирование нахождения минимума
    @Test
    public void testFindMin() {
        List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 9);
        assertEquals(1, Main._min(numbers));
    }

    // Тестировние нахождения максимума
    @Test
    public void testFindMax() {
        List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 9);
        assertEquals(9, Main._max(numbers));
    }

    // Тестирование суммирования
    @Test
    public void testSum() {
        List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 9);
        assertEquals(25, Main._sum(numbers));
    }

    // Тестирование произведения
    @Test
    public void testMultiply() {
        List<Integer> numbers = Arrays.asList(2, 3, 4);
        assertEquals(24, Main._mult(numbers));
    }

    // Тестирование всех функций
    @Test
    public void testMinMaxSumMultInt() throws IOException {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 4, 2, 3));
        assertEquals(1, Main._min(numbers));
        assertEquals(4, Main._max(numbers));
        assertEquals(10, Main._sum(numbers));
        assertEquals(24, Main._mult(numbers));
    }

    // Тестирование скорости при увеличении размера файла
    @Test
    public void testPerformanceSum() throws IOException {
        for (int size = 1; size <= 1000000; size *= 10) {
            createFileWithNumbers("numbers.txt", size);
            ArrayList<Integer> numbers = Main.readNumbersFromFile("numbers.txt");
            long startTime = System.currentTimeMillis();
            Main._sum(numbers);
            long endTime = System.currentTimeMillis();
            long duration = (endTime - startTime);
            System.out.println("Размер файла: " + size + ", Время выполнения: " + duration + " мс");
        }
    }

    @Test
    public void testPerformanceMin() throws IOException {
        for (int size = 1; size <= 1000000; size *= 10) {
            createFileWithNumbers("numbers.txt", size);
            ArrayList<Integer> numbers = Main.readNumbersFromFile("numbers.txt");
            long startTime = System.nanoTime();
            Main._min(numbers);
            long endTime = System.nanoTime();
            long duration = (endTime - startTime) / 1000000; // milliseconds
            System.out.println("Размер файла: " + size + ", Время выполнения: " + duration + " мс");
        }
    }

    @Test
    public void testPerformanceMax() throws IOException {
        for (int size = 1; size <= 1000000; size *= 10) {
            createFileWithNumbers("numbers.txt", size);
            ArrayList<Integer> numbers = Main.readNumbersFromFile("numbers.txt");
            long startTime = System.nanoTime();
            Main._max(numbers);
            long endTime = System.nanoTime();
            long duration = (endTime - startTime) / 1000000; // milliseconds
            System.out.println("Размер файла: " + size + ", Время выполнения: " + duration + " мс");
        }
    }

    @Test
    public void testPerformanceMult() throws IOException {
        for (int size = 1; size <= 1000000; size *= 10) {
            createFileWithNumbers("numbers.txt", size);
            ArrayList<Integer> numbers = Main.readNumbersFromFile("numbers.txt");
            long startTime = System.nanoTime();
            Main._mult(numbers);
            long endTime = System.nanoTime();
            long duration = (endTime - startTime) / 1000000; // milliseconds
            System.out.println("Размер файла: " + size + ", Время выполнения: " + duration + " мс");
        }
    }

    // Тестировние использования нецелых чисел для всех функций
    @Test
    public void testMinMaxSumMultDouble() throws IOException {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 4, 2, 3));
        assertEquals(1.5, Main._min(numbers));
        assertEquals(4.2, Main._max(numbers));
        assertEquals(11.6, Main._sum(numbers));
        assertEquals(49.932, Main._mult(numbers));
    }

    private void createFileWithNumbers(String fileName, int size) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName);
        for (int i = 0; i < size; i++) {
            fileWriter.write(i + " ");
        }
        fileWriter.close();
    }
}
