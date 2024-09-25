package io.task4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Task4 {
    public static void main(String[] args) throws IOException {
        List<Employee> employees = addingEmployees();

        writingToFile(employees);

        readingFromFile();
    }

    private static List<Employee> addingEmployees() {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee("John", "Stones", 25, "Manager"));
        employees.add(new Employee("Brian", "Gill", 27, "Sales assistant"));
        employees.add(new Employee("Bill", "Tudor", 23, "Programmer"));
        employees.add(new Employee("Peter", "Parker", 32, "Designer"));
        employees.add(new Employee("Vanessa", "Johnson", 22, "Secretary"));

        return employees;
    }

    private static void readingFromFile() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("task/Employees"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("line = " + line);
            }
        }
    }

    private static void writingToFile(List<Employee> employees) {
        try (FileWriter fileWriter = new FileWriter("task/Employees")) {
            for (Employee employee : employees) {
                fileWriter.write(employee.toString() + "\n");
            }
            System.out.println("Employees written to file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred" + e.getMessage());
        }
    }
}
