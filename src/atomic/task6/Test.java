package atomic.task6;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        var hm = new HashMap<>(Map.of("Math", 5,
                "Physics", 4,
                "Music", 4,
                "English", 5,
                "Literature", 3));

        var user = new ImmutablePupil("user1", "password1", hm);

        System.out.println("user = " + user);

        hm.put("Math", 3);
        hm.remove("Music");

        System.out.println("user = " + user);
    }
}
