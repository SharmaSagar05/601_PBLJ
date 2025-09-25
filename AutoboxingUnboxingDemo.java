import java.util.ArrayList;
import java.util.Scanner;

public class AutoboxingUnboxingDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter numbers separated by commas:");
        String input = sc.nextLine();

        ArrayList<Integer> numbers = new ArrayList<>();
        String[] parts = input.split(",");

        for (String part : parts) {
            String trimmed = part.trim();
            if (!trimmed.isEmpty()) {
                Integer num = Integer.valueOf(trimmed); // Wrapper method
                numbers.add(num); // Autoboxing
            }
        }

        int sum = 0;
        for (Integer num : numbers) {
            sum += num; // Unboxing
        }

        System.out.println("Sum of numbers = " + sum);

        sc.close();
    }
}