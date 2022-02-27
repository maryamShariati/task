package ir.chica.task.model;

import ir.chica.task.dto.RoleDto;
import ir.chica.task.enumTest.CategoryEnum;
import ir.chica.task.enumTest.RoleEnum;
import lombok.*;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    @Enumerated(value = EnumType.ORDINAL)
    private RoleEnum main;

    @Enumerated(EnumType.STRING)
    private CategoryEnum category;

    private String name;


    @OneToMany(mappedBy = "role")
    private List<UserRole> userRoles;

    public Role(RoleEnum main, String category, Object name) {
    }


    public static Role fromDto(RoleDto roleDto) {
        Role role = new Role();
        role.setMain(roleDto.main());
        role.setCategory(roleDto.category());
        role.setName(roleDto.name());
        return role;
    }


    @Override
    public boolean equals(Object object) {
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        if (((Role) object).getId() != null) {
            Role role = (Role) object;
            return (this.getId().equals(role.getId()));
        } else {
            return false;
        }
    }
}
