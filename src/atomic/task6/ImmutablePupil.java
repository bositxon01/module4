package atomic.task6;

import java.util.HashMap;

public record ImmutablePupil(String username, String password, HashMap<String, Integer> subjects) {
    public ImmutablePupil(String username, String password, HashMap<String, Integer> subjects) {
        this.username = username;
        this.password = password;
        this.subjects = new HashMap<>(subjects);
    }

    public HashMap<String, Integer> subjects() {
        return new HashMap<>(subjects);
    }

    @Override
    public String toString() {
        return "ImmutablePupil{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", subjects=" + subjects +
                '}';
    }
}
