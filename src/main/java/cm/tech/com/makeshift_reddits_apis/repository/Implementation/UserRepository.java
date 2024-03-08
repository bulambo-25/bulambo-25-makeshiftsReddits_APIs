package cm.tech.com.makeshift_reddits_apis.repository.Implementation;

import cm.tech.com.makeshift_reddits_apis.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.id = ?1")
    User UserFindById(Long id);

    @Query("SELECT u FROM User u WHERE u.username = ?1")
    User findUserByIdSurname(String username);

    boolean existsByUsername(String username);
    
}
