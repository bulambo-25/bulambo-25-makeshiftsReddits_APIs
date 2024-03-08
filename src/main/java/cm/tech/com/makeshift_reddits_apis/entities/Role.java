package cm.tech.com.makeshift_reddits_apis.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name = "Role", uniqueConstraints = {@UniqueConstraint(columnNames = "name")})
public class Role {
    @javax.persistence.Id
    @SequenceGenerator(name = "role", sequenceName = "ORACLE_DB_SEQ_ID",
            allocationSize = 7, initialValue = 3001)
    @GeneratedValue(strategy = SEQUENCE, generator = "role")
    private int Id;
    private String name;

}
