package ir.chica.task.model;

import ir.chica.task.dto.SerializeDto;
import ir.chica.task.dto.UserDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "app_user")
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(unique = true)
    private Long id;
    @Column(nullable = false, updatable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    private boolean deleted;

    @OneToMany(mappedBy = "member")
    private List<Task> tasks;


    public static User fromUserDto(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.username());
        user.setPassword(userDto.password());
        return user;
    }

    public static void save(SerializeDto serializeDto) throws IOException {
        Serialization serialize1=new Serialization(Math.toIntExact(serializeDto.id()),serializeDto.username(),serializeDto.password());
        FileOutputStream stash =new FileOutputStream("f.txt");
        ObjectOutputStream out=new ObjectOutputStream(stash);
        out.writeObject(serialize1);
        out.close();
        System.out.println("success");
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
