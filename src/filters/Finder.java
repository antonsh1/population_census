package filters;

import classes.Education;
import classes.Person;
import classes.Sex;

import java.util.*;
import java.util.stream.Collectors;

public class Finder {
    private Collection<Person> persons;
    private Integer lowWorkableAge = 18;
    private Integer highManWorkableAge = 60;
    private Integer highWomanWorkableAge = 65;

    public Finder(Collection<Person> persons) {
        this.persons = persons;
    }

    public long countYounger(int age) {
        return persons.stream().filter(person -> person.getAge() < age).count();
    }

    public List<String> findBetween(int low, int high) {
        return persons
                .stream()
                .filter(person -> person.getAge() >= low)
                .filter(person -> person.getAge() <= high)
                .map(Person::getFamily)
                .collect(Collectors.toList());
    }

    public Collection<Person> getHighEducationWorkable() {
        return persons
                .stream()
                .filter(person -> person.getEducation() == Education.HIGHER)
                .filter(person -> person.getAge() >= lowWorkableAge)
                .filter(person ->
                        (person.getSex() == Sex.MAN && person.getAge() <= highManWorkableAge)
                                || (person.getSex() == Sex.WOMAN && person.getAge() <= highWomanWorkableAge))
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public int findMaxAge() {
        Optional<Person> result = persons.stream().max(Comparator.comparing(Person::getAge));
        if (result.isPresent()) {
            return result.get().getAge();
        }
        return 0;
    }

    public int findMaxAgeHighEducation() {
        Optional<Person> result = persons.stream().filter(person -> person.getEducation() == Education.HIGHER && person.getSex() == Sex.MAN).max(Comparator.comparing(Person::getAge));
        if (result.isPresent()) {
            return result.get().getAge();
        }
        return 0;
    }

}
