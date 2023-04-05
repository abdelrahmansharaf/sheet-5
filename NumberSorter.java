import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class NumberSorter {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter a number: ");
            int num = scanner.nextInt();
            numbers.add(num);
        }

        Collections.sort(numbers);

        System.out.println("The numbers in increasing order are:");
        for (int num : numbers) {
            System.out.println(num);
        }
    }
}

