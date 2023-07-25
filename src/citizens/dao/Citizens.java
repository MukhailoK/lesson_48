package citizens.dao;

import citizens.model.Person;

import java.util.List;

public interface Citizens {

    boolean add(Person person);

    boolean remove(int id);

    Person find(int id);

    List<Person> find(int minAge, int maxAge);

    List<Person> find(String lastName);

    List<Person> getAllSortedPersonById();

    List<Person> getAllSortedPersonByAge();

    List<Person> getAllSortedPersonByLastName();

    int size();
}
