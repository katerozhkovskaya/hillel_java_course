package lesson28.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lesson28.enums.UserRole;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SpringDataUser extends BaseEntity {
    private String uid;
    private String name;
    private String email;
    @Enumerated(EnumType.STRING)
    private UserRole role;
}
