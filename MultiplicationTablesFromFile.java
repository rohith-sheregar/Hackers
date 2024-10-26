import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MultiplicationTablesFromFile {
    public static void main(String[] args) {
        int start = 0;
        int end = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("in3.txt"))) {
            start = Integer.parseInt(br.readLine().trim());
            end = Integer.parseInt(br.readLine().trim());
        } catch (IOException e) {
            System.out.println("Error reading from in3.txt: " + e.getMessage());
            return;
        }

        for (int i = start; i <= end; i++) {
            System.out.println("Multiplication Table for " + i + ":");
            printTable(i);
            System.out.println();
        }
    }

    private static void printTable(int number) {
        for (int j = 1; j <= 10; j++) {
            System.out.println(number + " x " + j + " = " + (number * j));
        }
    }
}
