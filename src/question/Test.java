package question;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        String text = "12321.";
        Pattern pattern = Pattern.compile("\\d{2}\\. \\(.*\\.*");
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
