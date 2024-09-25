package atomic.tests;

import java.util.concurrent.ConcurrentHashMap;

public class CountriesMap {
    public static void main(String[] args) {
        ConcurrentHashMap<Integer, String> hm = new ConcurrentHashMap<>();
        hm.put(0, "Albania");
        hm.put(1, "Belgium");
        hm.put(2, "Czech");
        hm.put(3, "Denmark");
        hm.put(4, "England");
        hm.put(5, "France");
        hm.put(6, "Greece");
        hm.put(7, "Hungary");
        hm.put(8, "Italy");
        hm.put(9, "Jordan");
        hm.put(10, "Kenya");
        hm.put(11, "Luxembourg");
        hm.put(12, "Montenegro");
        hm.put(13, "Netherlands");
        hm.put(14, "Oman");
        hm.put(15, "Portugal");
        hm.put(16, "Qatar");
        hm.put(17, "Romania");
        hm.put(18, "Spain");
        hm.put(19, "Turkey");
        hm.put(20, "Ukraine");
        hm.put(21, "Vatican");
        hm.put(22, "Wales");
        hm.put(23, "");
        hm.put(24, "Yaman");
        hm.put(25, "Zimbabwe");

        hm.forEach((k, v) -> System.out.println(k + " -> " + v));
    }
}
