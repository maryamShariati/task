package ir.chica.task.repository;

import ir.chica.task.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query(value = "FROM User WHERE  username = :username ")
    Optional<User> findByUsername(@Param("username") String username);

    Optional<User> findByIdAndDeletedFalse(@Param("id") Long id);


    Optional<User> findByUsernameAndDeletedIsFalse(String username);




}
