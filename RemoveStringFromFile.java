import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RemoveStringFromFile {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java RemoveStringFromFile <string> <filename>");
            System.exit(1);
        }

        String stringToRemove = args[0];
        String filename = args[1];

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename + ".tmp"));

            String line;
            while ((line = reader.readLine()) != null) {
                line = line.replaceAll(stringToRemove, "");
                writer.write(line);
                writer.newLine();
            }
            reader.close();
            writer.close();

            if (!new File(filename).delete()) {
                System.out.println("Failed to delete the original file.");
                System.exit(1);
            }

            if (!new File(filename + ".tmp").renameTo(new File(filename))) {
                System.out.println("Failed to rename the temporary file.");
                System.exit(1);
            }

            System.out.println("All occurrences of \"" + stringToRemove + "\" have been removed from " + filename + ".");
        } catch (IOException e) {
            System.out.println("An error occurred while processing the file: " + e.getMessage());
            System.exit(1);
        }
    }
}


