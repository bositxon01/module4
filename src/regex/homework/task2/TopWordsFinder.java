package regex.homework.task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class TopWordsFinder {

    private static final int NUM_THREADS = 4;
    private static final int CHUNK_SIZE = 10_000;

    public static void main(String[] args) throws IOException, InterruptedException {

        Path filePath = Path.of("regexes/largeText.txt");
        String text = Files.readString(filePath);

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        Map<String, Integer> wordCounts = new ConcurrentHashMap<>();

        for (int start = 0; start < text.length(); start += CHUNK_SIZE) {
            int end = Math.min(start + CHUNK_SIZE, text.length());
            String chunk = text.substring(start, end);

            executorService.submit(() -> processChunk(chunk, wordCounts));
        }

        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);

        List<Map.Entry<String, Integer>> topWords = getTop5Words(wordCounts);

        System.out.println("The most used 5 words:");
        for (Map.Entry<String, Integer> entry : topWords) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    private static void processChunk(String chunk, Map<String, Integer> wordCounts) {

        String[] words = chunk.toLowerCase().split("[^a-zA-Z]+");

        for (String word : words) {
            if (!word.isBlank()) {
                wordCounts.merge(word, 1, Integer::sum);
            }
        }
    }

    private static List<Map.Entry<String, Integer>> getTop5Words(Map<String, Integer> wordCounts) {

        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(wordCounts.entrySet());

        entryList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        List<Map.Entry<String, Integer>> top5Words = new ArrayList<>();

        for (int i = 0; i < 5 && i < entryList.size(); i++) {
            top5Words.add(entryList.get(i));
        }

        return top5Words;
    }

}

