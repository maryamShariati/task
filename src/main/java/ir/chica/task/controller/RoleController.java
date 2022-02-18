package ir.chica.task.controller;

import ir.chica.task.dto.RoleDto;
import ir.chica.task.enumTest.CategoryEnum;
import ir.chica.task.enumTest.RoleEnum;
import ir.chica.task.exception.RecordNotFoundException;
import ir.chica.task.model.Role;
import ir.chica.task.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/role")
public class RoleController {

    private final RoleService service;
    @PostMapping
    public void saveRole(
            @RequestBody @Valid RoleDto roleDto) {service.saveRole(roleDto);
    }

    @GetMapping("/{userId}")
    @ResponseBody
    @Validated
    public List<Role> getAllRoleByUserId(@PathVariable @Positive Long userId) {
        return service.getAllRoleByUserId(userId);
    }

    @PatchMapping("/update/{id}/{main}")
    @Validated
    public void updateMain(@PathVariable @Positive Long id,
            @PathVariable @NotBlank RoleEnum main) throws RecordNotFoundException {service.updateMain(id, main);
    }

    @PatchMapping("/update/{id}/{category}")
    @Validated
    public void updateCategory(@PathVariable @Positive Long id,
            @PathVariable @NotBlank CategoryEnum category) throws RecordNotFoundException {service.updateCategory(id, category);
    }

    @PatchMapping("/update/{id}/{name}")
    @Validated
    public void updateName(@PathVariable @Positive Long id,
            @PathVariable @NotBlank String name) throws RecordNotFoundException {
        service.updateName(id, name);
    }


    @PatchMapping("/update/{id}")
    public void updateCategory(
            @PathVariable @Positive Long id,
            @RequestBody @Valid RoleDto roleDto) throws RecordNotFoundException {
        service.updateRole(id, roleDto);
    }

}

