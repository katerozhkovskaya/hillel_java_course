package main.java.lesson6.phonebook;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PhoneBook {
    private List<Record> recordList = new ArrayList<>();

    public void add(Record record) {
        recordList.add(record);
    }

    public Record find(String name) {
        return recordList.stream().filter(el -> el.getName().equals(name)).findFirst().orElse(null);
    }

    public List<Record> findAll(String name) {
        return recordList.stream().filter(el -> el.getName().equals(name)).collect(Collectors.toList());
    }
}
