package phonebook;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Record {
    private String name;
    private String number;
}
