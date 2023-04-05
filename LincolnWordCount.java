import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class LincolnWordCount {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://cs.armstrong.edu/liang/data/Lincoln.txt");
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

        String line;
        int wordCount = 0;
        while ((line = in.readLine()) != null) {
            String[] words = line.trim().split("\\s+");
            wordCount += words.length;
        }

        in.close();

        System.out.println("The Gettysburg Address contains " + wordCount + " words.");
    }
}
