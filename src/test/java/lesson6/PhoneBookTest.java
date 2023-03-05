package lesson6;

import lesson6.phonebook.PhoneBook;
import lesson6.phonebook.Record;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PhoneBookTest {

    @Test
    public void checkAdd() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add(new Record("Kate", "1234"));
        assertEquals(phoneBook.getRecordList().size(), 1);
        phoneBook.add(new Record("Alice", "8888"));
        assertEquals(phoneBook.getRecordList().size(), 2);

    }

    @Test
    public void checkFind() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add(new Record("Kate", "1234"));
        assertEquals(phoneBook.find("Kate"), new Record("Kate", "1234"));
        assertNull(phoneBook.find("Alice"));

    }

    @Test
    public void checkFindAll() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add(new Record("Kate", "1111"));
        phoneBook.add(new Record("Kate", "2222"));
        phoneBook.add(new Record("Alice", "4444"));
        phoneBook.add(new Record("Alice", "5555"));
        phoneBook.add(new Record("Alice", "6666"));

        assertEquals(phoneBook.findAll("Kate").size(), 2);
        assertEquals(phoneBook.findAll("Alice").size(), 3);
        assertEquals(phoneBook.findAll("Marta").size(), 0);
    }
}
