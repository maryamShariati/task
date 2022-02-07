package ir.chica.task.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class Serialization implements Serializable {
    int id;
    String username;
    String password;
    public Serialization(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password=password;
    }



}

