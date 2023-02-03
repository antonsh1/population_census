import classes.Person;
import classes.PersonGenerator;
import filters.Finder;

import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        Collection<Person> persons = PersonGenerator.getCollection();
        Finder finder = new Finder(persons);

        System.out.println("Размер коллекции " + persons.size());
        System.out.println("Несовершеннолетних " + finder.countYounger(18));
        System.out.println("Количество призывников " + finder.findBetween(18, 27).size());
        System.out.println("Первые 10 фамилий призывников " + finder.findBetween(18, 27).stream().limit(10).toList());
        System.out.println("Количество работоспособных " + finder.getHighEducationWorkable().size());
        System.out.println("Первые 10 работоспособных");
        finder.getHighEducationWorkable().stream().limit(10).forEach(System.out::println);
    }
}
