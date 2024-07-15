package ru.gb.vending_machine.family_tree.model;


import java.io.Serial;
import java.io.Serializable;
import java.util.*;

public class FamilyTree implements Serializable, Iterable<Person> {
    @Serial
    private static final long serialVersionUID = 1L;

    private final Map<String, Person> people;

    public FamilyTree() {
        this.people = new HashMap<>();
    }

    public void addPerson(Person person) {
        people.put(person.getName(), person);
    }

    public Person getPerson(String name) {
        return people.get(name);
    }

    public List<Person> getChildren(String name) {
        Person person = people.get(name);
        if (person != null) {
            return person.getChildren();
        }
        return null;
    }

    @Override
    public Iterator<Person> iterator() {
        return people.values().iterator();
    }

    public List<Person> getPeopleSortedByName() {
        List<Person> sortedPeople = new ArrayList<>(people.values());
        sortedPeople.sort(Comparator.comparing(Person::getName));
        return sortedPeople;
    }

    public List<Person> getPeopleSortedByBirthDate() {
        List<Person> sortedPeople = new ArrayList<>(people.values());
        sortedPeople.sort(Comparator.comparing(Person::getBirthDate));
        return sortedPeople;
    }

    @Override
    public String toString() {
        return "FamilyTree{" +
                "people=" + people.values() +
                '}';
    }
}


