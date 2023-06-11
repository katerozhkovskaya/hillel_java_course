package bank.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@Table(name = "accounts")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Account extends BaseEntity {

    private String uid;
    private String iban;
    private Long balance;
    @Column(name = "person_id")
    private String personId;
}
