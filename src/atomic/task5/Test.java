package atomic.task5;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        var address = new Address("Tashkent", "Apples", "Biruni");
        var subjects = new ArrayList<>(List.of("Math", "Physics", "English"));

        var student = new ImmutableStudent("John", 22, address, subjects);
        System.out.println("student = " + student);
        student.address().setCity("London");
        System.out.println("subjects = " + subjects);
        subjects.remove("Math");
        System.out.println("student = " + student);
        System.out.println("subjects = " + subjects);
    }
}
