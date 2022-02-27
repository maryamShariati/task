package ir.chica.task.service;

import ir.chica.task.dto.RoleDto;
import ir.chica.task.enumTest.CategoryEnum;
import ir.chica.task.enumTest.RoleEnum;
import ir.chica.task.exception.RecordNotFoundException;
import ir.chica.task.model.Role;
import ir.chica.task.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class RoleService {

    private final RoleRepository repository;

//    public void saveRole(RoleEnum main, String category, Object name){
//        Role role=new Role(main,category,name);
//        repository.save(role);
//
//    }
    public void saveRole(RoleDto roleDto) {
        repository.save(Role.fromDto(roleDto));
    }


    public List<Role> getAllRoleByUserId(Long userId){
        return new ArrayList<>(repository.getAllRoleByUserId(userId));
    }

    public void updateMain(Long id, @NotBlank RoleEnum main) throws RecordNotFoundException {
        repository.findById(id).orElseThrow(() -> new RecordNotFoundException(main));
        repository.updateMain(id, main);
    }

    public void updateCategory(Long id, CategoryEnum category) throws RecordNotFoundException {
        repository.findById(id).orElseThrow(() -> new RecordNotFoundException(category));
        repository.updateCategory(id, category);
    }

    public void updateName(Long id, String name) throws RecordNotFoundException {
        repository.findById(id).orElseThrow(() -> new RecordNotFoundException(name));
        repository.updateName(id, name);
    }

    public void updateRole(Long id, RoleDto roleDto) throws RecordNotFoundException {
        repository.findById(id).orElseThrow(() -> new RecordNotFoundException(roleDto));
        var main = roleDto.main();
        var category = roleDto.category();
        var name = roleDto.name();
        repository.updateRole(id, main, category, name);
    }




}
