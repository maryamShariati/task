package ir.chica.task.model;

import ir.chica.task.dto.TaskDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
public class Task {
    @Id
    @Column(unique = true,updatable =false,name = "task_id")
    private Long id;
    private String name;
    @Column(nullable = false)
    private Date createAt;
    private Date updateAt;
    private Date deleteAt;
    private Date done;
    @Column(nullable = false)
    private boolean deleted;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private User member;

    public static Task fromTaskDto(TaskDto taskDto){
        Task task=new Task();
        task.setName(taskDto.name());
        task.setCreateAt(taskDto.createAt());
        return task;
    }
//    public static Task TimeMoment(){
//        Date date = new Date();
//        Task task=new Task();
//        System.out.println(date.toString());
//        task.setDone(date);
//        return task;
//    }



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
