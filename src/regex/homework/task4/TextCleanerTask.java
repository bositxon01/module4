package regex.homework.task4;

import java.util.concurrent.RecursiveTask;

public class TextCleanerTask extends RecursiveTask<String> {

    private static final int THRESHOLD = 1000;
    private final String text;

    public TextCleanerTask(String text) {
        this.text = text;
    }

    @Override
    protected String compute() {
        if (text.length() <= THRESHOLD) {
            return cleanerText(text);
        } else {
            int middle = text.length() / 2;
            TextCleanerTask left = new TextCleanerTask(text.substring(0, middle));
            TextCleanerTask right = new TextCleanerTask(text.substring(middle));

            invokeAll(left, right);

            return left.join() + right.join();
        }
    }

    private String cleanerText(String text) {
        text = text.replaceAll("[$&#*]","");
        text = text.replaceAll("\\s+"," ");
        return text;
    }
}
