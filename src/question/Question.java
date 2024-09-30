package question;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Question {
    private String text;

    private QuestionLevelEnum level;

    private List<Option> options;

    public Question(String text, QuestionLevelEnum level, List<Option> options) {
        this.text = text;
        this.level = level;
        this.options = options;
    }

    public String getText() {
        return text;
    }

    public QuestionLevelEnum getLevel() {
        return level;
    }

    public List<Option> getOptions() {
        return options;
    }

    @Override
    public String toString() {
        return "Question{" +
                "text='" + text + '\'' +
                ", level=" + level +
                ", options=" + options +
                '}';
    }

    public static void main(String[] args) throws IOException {
        List<Question> questions = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/questions.txt"))) {
            String line;
            String currentQuestion = null;

            List<Option> currentOptions = new ArrayList<>();
            QuestionLevelEnum currentLevel = null;

            while ((line = bufferedReader.readLine()) != null) {
                line = line.trim();

                if (line.matches("\\d+\\. \\(.*\\).*")) {
                    if (currentQuestion != null) {
                        questions.add(new Question(currentQuestion, currentLevel, new ArrayList<>(currentOptions)));
                    }

                    currentQuestion = line.split(":")[0].trim();
                    currentOptions.clear();

                    if (line.contains("HARD")) {
                        currentLevel = QuestionLevelEnum.HARD;
                    } else if (line.contains("MEDIUM")) {
                        currentLevel = QuestionLevelEnum.MEDIUM;
                    } else if (line.contains("EASY")) {
                        currentLevel = QuestionLevelEnum.EASY;
                    }
                } else if (line.startsWith("D)") || line.startsWith("A)") || line.startsWith("B)") || line.startsWith("C)")) {
                    boolean isCorrect = line.startsWith("D)");
                    String optionText = line.substring(2).trim();

                    currentOptions.add(new Option(optionText, isCorrect));
                }
            }

            if (currentQuestion != null) {
                questions.add(new Question(currentQuestion, currentLevel, new ArrayList<>(currentOptions)));
            }

            questions.forEach(System.out::println);
        }
    }

}
