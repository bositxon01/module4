package regex;

import java.io.File;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.regex.Pattern;

public class Task1 extends RecursiveTask<Void> {
    private final File directory;
    private final Pattern pattern;

    public Task1(File directory, Pattern pattern) {
        this.directory = directory;
        this.pattern = pattern;
    }

    @Override
    protected Void compute() {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    Task1 task = new Task1(file, pattern);
                    task.fork();
                } else {
                    if (pattern.matcher(file.getName()).find()) {
                        System.out.println(file.getAbsolutePath());
                    }
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String regex = "\\w*mp.3\\b";
        Pattern pattern1 = Pattern.compile(regex);
        File startDirectory = new File("D:/");

        try (ForkJoinPool forkJoinPool = new ForkJoinPool()) {
            Task1 search = new Task1(startDirectory, pattern1);
            forkJoinPool.invoke(search);
        }
    }
}

