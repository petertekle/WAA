package N_tier.example.Lab1.repository;

import N_tier.example.Lab1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
