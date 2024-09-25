package regex.homework.task4;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class LargeTextGenerator {
    public static void main(String[] args) {
        int targetLength = 100_000;
        char[] symbols = {'$', '&', '#', '*'};
        StringBuilder textBuilder = getStringBuilder(targetLength, symbols);

        try (FileWriter writer = new FileWriter("regexes/largeText.txt")) {
            writer.write(textBuilder.toString());
            System.out.println("Text created and placed to: largeText.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static StringBuilder getStringBuilder(int targetLength, char[] symbols) {
        StringBuilder textBuilder = new StringBuilder(targetLength);

        Random random = new Random();

        for (int i = 0; i < targetLength; i++) {

            if (random.nextInt(20) == 0) {
                textBuilder.append(symbols[random.nextInt(symbols.length)]);
            } else {
                char randomChar = (char) (random.nextInt(26) + 'a');
                textBuilder.append(randomChar);
            }

            if (random.nextInt(15) == 0) {
                textBuilder.append(' ');
            }
        }
        return textBuilder;
    }
}

