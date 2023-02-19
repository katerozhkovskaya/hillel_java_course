package lesson6.phonebook;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Data
public class Record {
    private String name;
    private String number;
}
