package bank.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@Table(name = "persons")
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Person extends BaseEntity {

    private String uid;
    private String name;
    private String email;

}
