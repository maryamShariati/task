package ir.chica.task.model;

import ir.chica.task.dto.UserDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(unique = true)
    private Long id;
    @Column(nullable = false ,updatable = false,unique =true)
    private String username;
    @Column(nullable = false)
    private String password;
    private boolean deleted;

    @OneToMany(mappedBy = "member")
    private List<Task> tasks;




    public static User fromUserDto(UserDto userDto){
        User user=new User();
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
}
