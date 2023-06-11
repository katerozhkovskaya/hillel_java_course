package lesson28.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpringDataUserRepository extends JpaRepository<SpringDataUser, Long> {
    Optional<SpringDataUser> findByUid(String id);
}
