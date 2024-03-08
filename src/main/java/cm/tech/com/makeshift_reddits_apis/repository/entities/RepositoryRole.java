package cm.tech.com.makeshift_reddits_apis.repository.entities;


import cm.tech.com.makeshift_reddits_apis.entities.Role;
import cm.tech.com.makeshift_reddits_apis.repository.Implementation.RoleRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@AllArgsConstructor
public class RepositoryRole {


    private final RoleRepository roleRepository;


    public Role create(Role role) {
        Role role1= Role.builder().name(role.getName()).build();
        Role role2=roleRepository.save(role1);
        return role2;
    }

}
