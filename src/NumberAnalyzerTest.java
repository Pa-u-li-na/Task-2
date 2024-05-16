import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.*;



public class NumberAnalyzerTest {

    @Test
    public void testFindMin() {
        List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 9);
        assertEquals(1, Main._min(numbers));
    }

    @Test
    public void testFindMax() {
        List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 9);
        assertEquals(9, Main._max(numbers));
    }

    @Test
    public void testSum() {
        List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 9);
        assertEquals(25, Main._sum(numbers));
    }

    @Test
    public void testMultiply() {
        List<Integer> numbers = Arrays.asList(2, 3, 4);
        assertEquals(24, Main._mult(numbers));
    }

    @Test
    public void testMinMaxSumMultInt() throws IOException {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 4, 2, 3));
        assertEquals(1, Main._min(numbers));
        assertEquals(4, Main._max(numbers));
        assertEquals(10, Main._sum(numbers));
        assertEquals(24, Main._mult(numbers));
    }

    @Test
    public void testPerformanceSum() throws IOException {
        for (int size = 1; size <= 1000000; size *= 10) {
            createFileWithNumbers("numbers.txt", size);
            ArrayList<Integer> numbers = Main.readNumbersFromFile("numbers.txt");
            long startTime = System.nanoTime();
            Main._sum(numbers);
            long endTime = System.nanoTime();
            double duration = (double) (endTime - startTime)/ 1000000;
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
            double duration = (double) (endTime - startTime)/ 1000000;
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
            double duration = (double) (endTime - startTime)/ 1000000;
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
            double duration = (double) (endTime - startTime)/ 1000000;
            System.out.println("Размер файла: " + size + ", Время выполнения: " + duration + " мс");
        }
    }

    @Test
    public void testNegativeNumbers() throws IOException {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, -9, 3, 5, -1));
        assertEquals(-9, Main._min(numbers));
        assertEquals(5, Main._max(numbers));
        assertEquals(-1, Main._sum(numbers));
        assertEquals(135, Main._mult(numbers));
    }

    @Test
    public void testReadNumbersFromFile() throws IOException {
        FileWriter fileWriter = new FileWriter("numbers.txt");
        for (int i = 1; i < 6; i ++) {
            fileWriter.write(i + " ");
        }
        fileWriter.close();
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> actual = Main.readNumbersFromFile("numbers.txt");
        assertEquals(expected, actual);
    }

    private void createFileWithNumbers(String fileName, int size) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName);
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            fileWriter.write(random.nextInt(1000000) + " ");
        }
        fileWriter.close();
    }
}
