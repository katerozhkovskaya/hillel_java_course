package lesson2.part1.epmloyee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Employee {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private int age;

    @Override
    public String toString() {
        return "Employee Data: " +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", age=" + age;
    }
}
