package proj.hobby.collections;

import java.util.Comparator;
import java.util.TreeMap;

public class MyTreeMap {
    public static void main(String[] args) {
        // Creating a TreeMap
        TreeMap<String, Integer> ages = new TreeMap<>();

        // Adding elements
        ages.put("Alice", 30);
        ages.put("Bob", 25);
        ages.put("Charlie", 35);
        ages.put("David", 28);

        // Accessing elements
        System.out.println("Age of Alice: " + ages.get("Alice"));

        // Iterating over elements
        System.out.println("All ages:");
        ages.forEach((name, age) -> System.out.println(name + ": " + age));

        // Removing elements
        ages.remove("Bob");
        System.out.println("Ages after removing Bob:");
        ages.forEach((name, age) -> System.out.println(name + ": " + age));

        // Checking if a key exists
        System.out.println("Is Charlie present? " + ages.containsKey("Charlie"));

        // Size of the TreeMap
        System.out.println("Number of entries: " + ages.size());
    }
}
