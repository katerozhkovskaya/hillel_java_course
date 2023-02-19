package ua.ithillel.lesson6.main.java;

import ua.ithillel.lesson6.main.java.phonebook.PhoneBook;
import ua.ithillel.lesson6.main.java.phonebook.Record;

import java.util.List;


public class TaskMain {
    public static void main(String[] args) {
        System.out.println(MethodsClass.calcOccurance(List.of("one", "two", "three", "four", "five", "one",
                "two", "four", "one", "one", "two")));
        System.out.println(MethodsClass.findOccurance(List.of("one", "two", "three", "four", "five", "one",
                "two", "four", "one", "one", "two")));

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add(new Record("Kate","11111"));
        phoneBook.add(new Record("Kate","22222"));
        phoneBook.add(new Record("Alice","33333"));
        System.out.println(phoneBook);
        System.out.println(phoneBook.find("Kate"));
        System.out.println(phoneBook.findAll("Kate"));
        System.out.println(phoneBook.find("Petr"));
        System.out.println(phoneBook.findAll("Petr"));
    }
}

