package ir.chica.task.repository;

import ir.chica.task.enumTest.CategoryEnum;
import ir.chica.task.enumTest.RoleEnum;
import ir.chica.task.model.Role;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends CrudRepository<Role,Long> {

    @Query(value = "select r.role from role as r INNER join userRole as ur on ur.role_id=r.id where ur.user_id= :id",
            nativeQuery = true)
    List<Role> getAllRoleByUserId(@Param("id") Long userId);


    @Modifying
    @Query(value = "update Role role set role.main=:main where role.id=:id")
    void updateMain(@Param("id") Long id,
                    @Param("main")
                            RoleEnum main);

    @Modifying
    @Query(value = "update Role role set role.category=:category where role.id=:id")
    void updateCategory(@Param("id") Long id,
                        @Param("category") CategoryEnum category);

    @Modifying
    @Query(value = "update Role role set role.name=:name where role.id=:id")
    void updateName(@Param("id") Long id,
                    @Param("name") String name);

    @Modifying
    @Query(value = "update Role role set role.main=:main ,role.category=:category,role.name=:name where role.id=:id")
    void updateRole(@Param("id") Long id,
                    @Param("main") RoleEnum main,
                    @Param("category") CategoryEnum category,
                    @Param("name") String name);



}
