package atomic.task5;

import java.util.ArrayList;

public record ImmutableStudent(String name, int age, Address address, ArrayList<String> subjects) {
    public ImmutableStudent(String name, int age, Address address, ArrayList<String> subjects) {
        this.name = name;
        this.age = age;
        this.address = address.clone();
        this.subjects = new ArrayList<>(subjects);
    }

    @Override
    public Address address() {
        return address.clone();
    }

    @Override
    public ArrayList<String> subjects() {
        return new ArrayList<>(subjects);
    }

    @Override
    public String toString() {
        return "ImmutableStudent{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                ", subjects=" + subjects +
                '}';
    }
}
