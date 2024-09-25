package regex.homework.task4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ForkJoinPool;

public class Task4 {
    public static void main(String[] args) throws IOException {
        String filePath = "regexes/largeText.txt";
        String text = new String(Files.readAllBytes(Paths.get(filePath)));

        TextCleanerTask task = new TextCleanerTask(text);
        long start;
        String cleanedText;
        try (ForkJoinPool forkJoinPool = new ForkJoinPool()) {
            start = System.currentTimeMillis();
            cleanedText = forkJoinPool.invoke(task);
        }
        long end = System.currentTimeMillis();

        String outputPath = "regexes/output.txt";
        Files.write(Paths.get(outputPath), cleanedText.getBytes());

        System.out.println("(end - start) = " + (end - start));
    }
}
