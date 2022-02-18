package ir.chica.task.repository;

import ir.chica.task.enumTest.Gender;
import ir.chica.task.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query(value = "FROM User WHERE  username = :username ")
    Optional<User> findByUsername(@Param("username") String username);

    Optional<User> findByIdAndDeletedFalse(@Param("id") Long id);


    Optional<User> findByUsernameAndDeletedIsFalse(String username);

    @Query(value = "SELECT name and surname FROM user WHERE sex = :gender",nativeQuery = true)
    List<String> findBySex(@Param("gender") Gender gender);

}
