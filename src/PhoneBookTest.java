import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class PhoneBookTest {
    private PhoneBook book = new PhoneBook();
    private HashSet<String> equalsSet = new HashSet<>();

    @BeforeEach
    void setUp() {
        book.addContact("Виктор Ремчиков");
        book.addContact("Владислав Сихорин");
        book.addContact("Мария Сихорина");
        book.addPhone("Владислав Сихорин", "+79062684456");
        book.addPhone("Владислав Сихорин", "+79062984456");
        book.addPhone("Виктор Ремчиков", "+79064656456");
    }

    @Test
    void addContact() {
        assertFalse(book.keys.contains("Игорь Семерявин"));
        book.addContact("Игорь Семерявин");
        assertTrue(book.keys.contains("Игорь Семерявин"));
    }

    @Test
    void deleteContact() {
        assertTrue(book.keys.contains("Владислав Сихорин"));
        book.deleteContact("Владислав Сихорин");
        assertFalse(book.keys.contains("Владислав Сихорин"));
    }


    @Test
    void findNumbers() {
        equalsSet.add("+79064656456");
        assertEquals(equalsSet, book.findNumbers("Виктор Ремчиков"));

    }

    @Test
    void findContact() {
        assertEquals("Виктор Ремчиков", book.findContact("+79064656456"));
    }


    @Test
    void addPhone() {
        assertEquals(null, book.findNumbers("Мария Сихорина"));
        book.addPhone("Мария Сихорина", "+7902300456");
        assertEquals(book.findContact("+7902300456"), "Мария Сихорина");
    }

    @Test
    void deletePhone() {
        equalsSet.add("+79062684456");
        equalsSet.add("+79062984456");
        assertEquals(book.findNumbers("Владислав Сихорин"), equalsSet);
        book.deletePhone("Владислав Сихорин", "+79062984456");
        equalsSet.remove("+79062984456");
        assertEquals(book.findNumbers("Владислав Сихорин"), equalsSet);
    }

