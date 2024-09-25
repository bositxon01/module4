package io.task5;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Task5 {
    public static void main(String[] args) {
        String source = "task";
        String destination = "taskcopyfolder";

        copyFilesFromFolder(source, destination);
    }

    public static void copyFilesFromFolder(String sourceFolder, String destinationFolder) {
        File sourceDir = new File(sourceFolder);
        File destinationDir = new File(destinationFolder);

        if (!sourceDir.exists() || !sourceDir.isDirectory()) {
            System.out.println("Manba papka mavjud emas yoki papka emas.");
            return;
        }

        if (!destinationDir.exists()) {
            destinationDir.mkdirs();
        }

        File[] filesToCopy = sourceDir.listFiles();

        if (filesToCopy != null) {
            for (File file : filesToCopy) {
                if (file.isFile()) {
                    Path sourcePath = file.toPath();
                    Path destinationPath = Paths.get(destinationDir.getAbsolutePath(), file.getName());

                    try {
                        Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
                        System.out.println(file.getName() + " file copied successfully.");
                    } catch (IOException e) {
                        System.out.println("Error occurred: " + e.getMessage());
                    }
                }
            }
            System.out.println("All files are copied.");
        } else {
            System.out.println("No files found in source folder.");
        }
    }
}
