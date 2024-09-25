package io.task3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadNumbersArray {

    public static void main(String[] args) {
        String fileName = "task/numbers2.txt";
        readNumbersFromFile(fileName);
    }

    public static void readNumbersFromFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            int lineNumber = 1;
            while ((line = br.readLine()) != null) {

                String[] numbers = line.split(",");

                List<Integer> numberList = new ArrayList<>();
                for (String number : numbers) {
                    numberList.add(Integer.parseInt(number.trim()));
                }

                System.out.println("Qator " + lineNumber + ": " + numberList);

                lineNumber++;
            }
        } catch (IOException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}

