package ir.chica.task.model;

import ir.chica.task.dto.TaskDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
@Entity
@Setter
@Getter
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Date createAt;
    private Date updateAt;
    private Date deleteAt;
    private Date done;
    @Column(nullable = false)
    private boolean deleted;

    @ManyToOne(optional = false,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User member;

    public Task(String taskName) {
    }


    @PrePersist
    public void prePersist() {
        this.setCreateAt(new Date());
    }

    @PreUpdate
    public void preUpdate(){
       this.setUpdateAt(new Date());
    }



    @Override
    public boolean equals(Object object) {
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        if (((Task) object).getId() != null) {
            Task task = (Task) object;
            return (this.getId().equals(task.getId()));
        } else {
            return false;
        }
    }

}
