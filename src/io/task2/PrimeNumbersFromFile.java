package io.task2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PrimeNumbersFromFile {

    public static void main(String[] args) {
        String fileName = "task/numbers.txt";
        List<Integer> numbers = readNumbersFromFile(fileName);

        System.out.println("Prime numbers:");
        for (int number : numbers) {
            if (isPrime(number)) {
                System.out.print(number + " ");
            }
        }
    }

    public static List<Integer> readNumbersFromFile(String fileName) {
        List<Integer> numbers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();

            String[] numStrings = line.split(",");

            for (String numStr : numStrings) {
                numbers.add(Integer.parseInt(numStr.trim()));
            }
        } catch (IOException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
        return numbers;
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
