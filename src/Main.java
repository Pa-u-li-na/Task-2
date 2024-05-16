import java.io.*;
import java.util.*;
public class Main {
    public static ArrayList<Integer> readNumbersFromFile(String fileName) throws IOException {
        ArrayList<Integer> numbers = new ArrayList<>();
        Scanner scanner = new Scanner(new File(fileName));
        while (scanner.hasNextInt()) {
            numbers.add(scanner.nextInt());
        }
        scanner.close();
        return numbers;
    }

    public static int _min(List<Integer> numbers) {
        int min = numbers.get(0);
        for (int num : numbers) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    public static int _max(List<Integer> numbers) {
        int max = numbers.get(0);
        for (int num : numbers) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public static int _sum(List<Integer> numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }

    public static long _mult(List<Integer> numbers) {
        long product = 1;
        for (int num : numbers) {
            product *= num;
        }
        return product;
    }

    public static void main(String[] args) throws IOException {
        String filename = "numbers.txt";
        List<Integer> numbers = readNumbersFromFile(filename);

        System.out.println("Минимальное: " + _min(numbers));
        System.out.println("Максимальное: " + _max(numbers));
        System.out.println("Сумма: " + _sum(numbers));
        System.out.println("Произведение: " + _mult(numbers));
    }
}
