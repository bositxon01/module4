package regex;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.*;
import java.util.regex.Pattern;

public class Task3 {

    public static void main(String[] args) throws InterruptedException, IOException {
        String fileName = "regexes/passwords.txt";
        Path path = Path.of(fileName);
        List<String> lines = Files.readAllLines(path);

        long start;
        try (ExecutorService executorService = Executors.newFixedThreadPool(10)) {
            start = System.currentTimeMillis();
            for (String line : lines) {
                String[] passwords = line.split("\\s+");
                for (String password : passwords) {
                    Runnable task = () -> checkPasswordValidation(password);
                    executorService.submit(task);
                }
            }
        }
        long end = System.currentTimeMillis();

        System.out.println("(end - start) = " + (end - start));
    }

    private static void checkPasswordValidation(String password) {
        if (password.length() < 8) {
            System.out.println(password + " -> " + "Not valid !");
        }

        Pattern letterPattern = Pattern.compile("[a-zA-Z]");
        Pattern digitPattern = Pattern.compile("[0-9]");
        Pattern specialPattern = Pattern.compile("[!@#$%^&*]");

        if (!letterPattern.matcher(password).find()) {
            System.out.println(password + " -> " + "Letters don't match");
        } else if (!digitPattern.matcher(password).find()) {
            System.out.println(password + " -> " + "Digits don't match");
        } else if (!specialPattern.matcher(password).find()) {
            System.out.println(password + " -> " + "Special chars don't match");
        } else {
            System.out.println(password + " -> " + "Password is valid");
        }
    }
}

