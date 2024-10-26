import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MultiplicationTablesToFile {
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

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("ou3.txt"))) {
            for (int i = start; i <= end; i++) {
                writer.write("Multiplication Table for " + i + ":\n");
                for (int j = 1; j <= 10; j++) {
                    writer.write(i + " x " + j + " = " + (i * j) + "\n");
                }
                writer.write("\n");
            }
        } catch (IOException e) {
            System.out.println("Error writing to ou3.txt: " + e.getMessage());
        }
    }
}
