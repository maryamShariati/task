package ir.chica.task.model;


import com.sun.istack.NotNull;
import ir.chica.task.customAnnotation.SexAnnotation;
import ir.chica.task.enumTest.Gender;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Setter
@Getter
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false)
    @NotNull
    private String name;
    @Column(nullable = false)
    @NotNull
    private String surName;
//    @SexAnnotation
    @NotBlank
    private Gender sex;
    @Column(nullable = false ,columnDefinition = "date")
    @NotNull
    private Date birthday;
    private String bio;
    private Boolean deleted;



    @OneToOne(cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
    private User user;


    @Override
    public  boolean equals(Object object){
        if (object==null || this.getClass() != object.getClass()){
            return false;
        }if (((Profile) object).getId() != null){
            Profile profile= (Profile) object;
            return (this.getId().equals(profile.getId()));
        }else {
            return false;
        }
    }
}
