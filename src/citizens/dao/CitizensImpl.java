package citizens.dao;

import citizens.model.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CitizensImpl implements Citizens {
    private static Comparator<Person> lastNameComparator;
    private static Comparator<Person> ageComparator;
    private List<Person> citizens;
    private List<Person> idList;
    private List<Person> lastNameList;
    private List<Person> ageList;
    private int size;

    public CitizensImpl() {
        citizens = new ArrayList<>();
        size = 0;
    }

    public CitizensImpl(List<Person> citizens) {
        this.citizens = citizens;
        size = citizens.size();
    }

    @Override
    public boolean add(Person person) {
        return false;
    }

    @Override
    public boolean remove(int id) {
        return false;
    }

    @Override
    public Person find(int id) {
        return null;
    }

    @Override
    public List<Person> find(int minAge, int maxAge) {
        return null;
    }

    @Override
    public List<Person> find(String lastName) {
        return null;
    }

    @Override
    public List<Person> getAllSortedPersonById() {
        return null;
    }

    @Override
    public List<Person> getAllSortedPersonByAge() {
        return null;
    }

    @Override
    public List<Person> getAllSortedPersonByLastName() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
