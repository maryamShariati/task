package ir.chica.task.model;

import ir.chica.task.dto.SerializeDto;
import ir.chica.task.dto.UserDto;
import ir.chica.task.enumTest.Gender;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "app_user")
@NoArgsConstructor
@AllArgsConstructor
@Access(AccessType.FIELD)
@Builder
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(unique = true)
    private Long id;
    @Column(nullable = false, updatable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    //    @SexAnnotation
    @NotBlank
    private Gender sex;
    private boolean deleted;

    @OneToMany(mappedBy = "member")
    private List<Task> tasks;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<UserRole> userRoles;


    public static User fromUserDto(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.username());
        user.setPassword(userDto.password());
        return user;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        if (((User) object).getId() != null) {
            User user = (User) object;
            return (this.getId().equals(user.getId()));
        } else {
            return false;
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
