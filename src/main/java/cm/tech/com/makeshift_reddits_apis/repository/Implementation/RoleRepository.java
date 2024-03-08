package cm.tech.com.makeshift_reddits_apis.repository.Implementation;


import cm.tech.com.makeshift_reddits_apis.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
