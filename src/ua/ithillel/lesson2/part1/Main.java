package ithillel.lesson2.part1;

import ithillel.lesson2.part1.epmloyee.Employee;

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee("Kate", "Rozhkovska", "kr@gmail.com",
                "+48515267721", 32);
        System.out.println(employee);
    }
}
