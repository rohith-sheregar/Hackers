import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SimpleCalculatorfromFile {

    public static void main(String[] args) {
        double a = 0, b = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader("in1.txt"));
            a = Double.parseDouble(br.readLine());
            b = Double.parseDouble(br.readLine());
            br.close();
        } catch (IOException e) {
            System.out.println("Error reading in1.txt");
            return;
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader("in2.txt"));
            String line = br.readLine();
            String[] numbers = line.split(",");
            a = Double.parseDouble(numbers[0]);
            b = Double.parseDouble(numbers[1]);
            br.close();
        } catch (IOException e) {
            System.out.println("Error reading in2.txt");
            return;
        }

        System.out.println("Sum: " + (a + b));
        System.out.println("Difference: " + (a - b));
        System.out.println("Product: " + (a * b));
        System.out.println("Division: " + (b != 0 ? (a / b) : "Cannot divide by zero."));
    }
}
