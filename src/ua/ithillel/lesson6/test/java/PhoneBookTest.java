import org.junit.jupiter.api.Test;
import phonebook.PhoneBook;
import phonebook.Record;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PhoneBookTest {

    @Test
    public void checkAdd() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add(new Record("Kate", "1234"));
        assertThat(phoneBook.getRecordList().size()).isEqualTo(1);
        phoneBook.add(new Record("Alice", "8888"));
        assertThat(phoneBook.getRecordList().size()).isEqualTo(2);

    }

    @Test
    public void checkFind() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add(new Record("Kate", "1234"));
        assertThat(phoneBook.find("Kate")).isEqualTo(new Record("Kate", "1234"));
        assertThat(phoneBook.find("Alice")).isNull();

    }

    @Test
    public void checkFindAll() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add(new Record("Kate", "1111"));
        phoneBook.add(new Record("Kate", "2222"));
        phoneBook.add(new Record("Alice", "4444"));
        phoneBook.add(new Record("Alice", "5555"));
        phoneBook.add(new Record("Alice", "6666"));

        assertThat(phoneBook.findAll("Kate").size()).isEqualTo(2);
        assertThat(phoneBook.findAll("Alice").size()).isEqualTo(3);
        assertThat(phoneBook.findAll("Marta").size()).isEqualTo(0);
    }
}
