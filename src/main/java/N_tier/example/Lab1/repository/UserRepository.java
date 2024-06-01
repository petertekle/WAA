package N_tier.example.Lab1.repository;

import N_tier.example.Lab1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u JOIN u.posts p GROUP BY u HAVING COUNT(p) > :postCount")
    List<User> getUsersWithMoreThanNPosts(@Param("postCount") long postCount);

}
