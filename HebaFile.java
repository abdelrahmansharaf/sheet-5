import java.io.*;
import java.nio.file.*;
import java.util.*;

public class HebaFile {

    public static void main(String[] args) {
        String fileName = "Heba.txt";
        createFileIfNotExists(fileName);
        writeRandomIntegersToFile(fileName, 100);
        List<Integer> integers = readIntegersFromFile(fileName);
        Collections.sort(integers);
        displayIntegers(integers);
    }

    private static void createFileIfNotExists(String fileName) {
        Path filePath = Paths.get(fileName);
        if (!Files.exists(filePath)) {
            try {
                Files.createFile(filePath);
            } catch (IOException e) {
                System.err.println("Error creating file: " + e.getMessage());
            }
        }
    }

    private static void writeRandomIntegersToFile(String fileName, int count) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileName))) {
            Random random = new Random();
            for (int i = 0; i < count; i++) {
                int randomNumber = random.nextInt(1000);
                writer.write(Integer.toString(randomNumber));
                if (i < count - 1) {
                    writer.write(" ");
                }
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    private static List<Integer> readIntegersFromFile(String fileName) {
        List<Integer> integers = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(fileName))) {
            String[] integerStrings = reader.readLine().split(" ");
            for (String integerString : integerStrings) {
                integers.add(Integer.parseInt(integerString));
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
        return integers;
    }

    private static void displayIntegers(List<Integer> integers) {
        for (Integer integer : integers) {
            System.out.print(integer + " ");
        }
    }
}

