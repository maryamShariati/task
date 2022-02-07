package ir.chica.task.repository;

import ir.chica.task.enumTest.Gender;
import ir.chica.task.model.Profile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfileRepository {

    @Query(value = "SELECT name and surname FROM profile WHERE sex = :gender",nativeQuery = true)
    List<String>findBySex(@Param("gender")Gender gender);



}
