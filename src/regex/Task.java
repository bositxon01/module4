package regex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task {
    public static void main(String[] args) {
        String fileName = "src/regex/article_with_hidden_elements.txt";
        List<String> list = new ArrayList<>();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = fileReader.readLine()) != null) {
                list.add(line);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        String string = list.toString();

//        taskSolver("\\d", string);
//        taskSolver("\\d{2}", string);
//        taskSolver("[3-8]{3}", string);
//        taskSolver("\\b[a-z]{3,7}\\b", string);
        taskSolver("\\b[A-Z]{3,7}\\b", string);
        //taskSolver("\\bfree\\w*\\b", string);
        //taskSolver("\\b\\w*stu\\b", string);
    }

    private static void taskSolver(String regex, String string) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);

        int count = 0;
        while (matcher.find()) {
            count++;
            System.out.println(matcher.group());
        }
        System.out.println("count = " + count);
    }
}
