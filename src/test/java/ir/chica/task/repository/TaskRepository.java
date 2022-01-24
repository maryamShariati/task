package ir.chica.task.repository;

import ir.chica.task.dto.IdsDto;
import ir.chica.task.model.Task;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends CrudRepository<Task,Long> {



    @Modifying
    @Query("update Task task set task.name= :name where task.id= :id")
    void updateName(@Param("id") Long id, @Param("name") String name);

    @Modifying
    @Query("update Task task set task.done=current_timestamp where task.id IN :ids")
    void updateTime(@Param("ids") IdsDto ids);

    @Query("select t.name from task as t join user on t.user_id = :id")
    List<Task>getTaskByUserId(Long id);


    Optional<Task>findByIdAndDeletedFalse(Long id);



}
