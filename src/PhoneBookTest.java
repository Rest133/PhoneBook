import kotlin.collections.EmptySet;
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
        assertArrayEquals(equalsSet.toArray(), book.FindNumbers("Виктор Ремчиков").toArray());

    }

    @Test
    void findContact() {
        assertEquals("Виктор Ремчиков", book.FindContact("+79064656456"));
    }


    @Test
    void addPhone() {
        assertEquals(null, book.FindNumbers("Мария Сихорина"));
        book.addPhone("Мария Сихорина", "+7902300456");
        equalsSet.add("+7902300456");
        assertArrayEquals(book.FindNumbers("Мария Сихорина").toArray(), equalsSet.toArray());
    }

    @Test
    void deletePhone() {
        equalsSet.add("+79062684456");
        equalsSet.add("+79062984456");
        assertArrayEquals(book.FindNumbers("Владислав Сихорин").toArray(), equalsSet.toArray());
        book.deletePhone("Владислав Сихорин", "+79062984456");
        equalsSet.remove("+79062984456");
        assertArrayEquals(book.FindNumbers("Владислав Сихорин").toArray(), equalsSet.toArray());
    }

}