package classes;

import java.util.*;

public class PersonGenerator {
    static private List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
    static private List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
    static private Collection<Person> persons = new ArrayList<>();

    static public Collection<Person> getCollection() {
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }
        return persons;
    }
}
