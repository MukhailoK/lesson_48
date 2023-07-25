package citizens.test;

import citizens.dao.Citizens;
import citizens.dao.CitizensImpl;
import citizens.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CitizensImplTest {
    Citizens citizens;
    LocalDate now = LocalDate.now();

    @BeforeEach
    void setUp() {
        citizens = new CitizensImpl();
        Person person = new Person(2, "Andrew", "White", now.minusYears(24));
        citizens.add(person);
        person = new Person(1, "Alex", "Brawn", now.minusYears(30));
        citizens.add(person);
        person = new Person(4, "Ostin", "Power", now.minusYears(13));
        citizens.add(person);
        person = new Person(3, "Alex", "White", now.minusYears(56));
        citizens.add(person);
    }

    @Test
    void add() {
        int size = citizens.size();
        Person excepted = new Person(5, "Michael", "Test", now.minusYears(26));
        assertTrue(citizens.add(excepted));
        assertEquals(excepted, citizens.find(excepted.getId()));
        assertEquals(size + 1, citizens.size());
    }

    @Test
    void addNullPerson() {
        assertThrows(NullPointerException.class, () -> citizens.add(null));
    }

    @Test
    void addExistPerson() {
        int size = citizens.size();
        Person person = new Person(2, "Andrew", "White", now.minusYears(24));
        assertFalse(citizens.add(person));
        assertEquals(size, citizens.size());
    }

    @Test
    void remove() {
        int size = citizens.size();
        assertTrue(citizens.remove(1));
        assertEquals(size - 1, citizens.size());
    }

    @Test
    void removeNotExistPerson() {
        assertFalse(citizens.remove(0));
        assertFalse(citizens.remove(citizens.size() + 1));
    }

    @Test
    void find() {
        Person excepted = new Person(1, "Alex", "Brawn", now.minusYears(30));
        assertEquals(excepted, citizens.find(1));
    }

    @Test
    void findNotExistPerson() {
        assertNull(citizens.find(0));
        assertNull(citizens.find(citizens.size() + 1));
    }

    @Test
    void testFindByLastName() {
        List<Person> excepted = new ArrayList<>();
        Person person = new Person(2, "Andrew", "White", now.minusYears(24));
        excepted.add(person);
        person = new Person(3, "Alex", "White", now.minusYears(56));
        excepted.add(person);
        assertEquals(excepted, citizens.find("White"));
    }

    @Test
    void testFindByLastNameNotFound() {
        assertNull(citizens.find(" "));
    }

    @Test
    void testFindByAges() {
        List<Person> excepted = new ArrayList<>();
        Person person = new Person(1, "Alex", "Brawn", now.minusYears(30));
        excepted.add(person);
        person = new Person(2, "Andrew", "White", now.minusYears(24));
        excepted.add(person);
        assertEquals(excepted, citizens.find(20, 30));
    }

    @Test
    void testFindByAgeNotFound() {
        assertNull(citizens.find(1000, 10001));
    }

    @Test
    void getAllSortedPersonById() {
        List<Person> excepted = new ArrayList<>();
        Person person = new Person(1, "Alex", "Brawn", now.minusYears(30));
        excepted.add(person);
        person = new Person(2, "Andrew", "White", now.minusYears(24));
        excepted.add(person);
        person = new Person(3, "Alex", "White", now.minusYears(56));
        excepted.add(person);
        person = new Person(4, "Ostin", "Power", now.minusYears(13));
        excepted.add(person);
        assertEquals(excepted, citizens.getAllSortedPersonById());
    }

    @Test
    void getAllSortedPersonByAge() {
        List<Person> excepted = new ArrayList<>();
        Person person = new Person(4, "Ostin", "Power", now.minusYears(13));
        excepted.add(person);
        person = new Person(2, "Andrew", "White", now.minusYears(24));
        excepted.add(person);
        person = new Person(1, "Alex", "Brawn", now.minusYears(30));
        excepted.add(person);
        person = new Person(3, "Alex", "White", now.minusYears(56));
        excepted.add(person);
        assertEquals(excepted, citizens.getAllSortedPersonByAge());
    }

    @Test
    void getAllSortedPersonByLastName() {
        List<Person> excepted = new ArrayList<>();
        Person person = new Person(1, "Alex", "Brawn", now.minusYears(30));
        excepted.add(person);
        person = new Person(4, "Ostin", "Power", now.minusYears(13));
        excepted.add(person);
        person = new Person(3, "Alex", "White", now.minusYears(56));
        excepted.add(person);
        person = new Person(2, "Andrew", "White", now.minusYears(24));
        excepted.add(person);
        assertEquals(excepted, citizens.getAllSortedPersonByLastName());

    }

    @Test
    void size() {
        assertEquals(4, citizens.size());
    }
}