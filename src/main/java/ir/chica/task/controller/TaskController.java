package ir.chica.task.controller;

import ir.chica.task.dto.IdsDto;
import ir.chica.task.dto.TaskDto;
import ir.chica.task.exception.RecordNotFoundException;
import ir.chica.task.service.TaskService;
import ir.chica.task.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/task")
@Validated
public class TaskController {

    private final TaskService service;


    @PostMapping("/save")
    @Secured("NORMAL_USER")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Map<String,Object> body) throws Exception {
        var taskName = body.get("name").toString();
        if (taskName == null || taskName.isBlank()) {
            throw new Exception("Invalid phrase entered");
        }
        service.persist(taskName);
    }

    @DeleteMapping("/delete/{id}")
    @Secured("ADMIN")
    public void delete(@PathVariable Long id) throws RecordNotFoundException {
        service.deleteById(id);
    }

    @PatchMapping("/update/{id}/{name}")
    public void updateName(@PathVariable Long id, @PathVariable String name) throws RecordNotFoundException {
        service.updateNameById(id, name);
    }

    @Secured("NORMAL_USER")
    @GetMapping("/get/{id}")
    public void getById(@PathVariable Long id) {
        service.getById(id);
    }

    @PutMapping("/update")
    public void updateDone(@RequestBody @Valid IdsDto idsDto) {
        service.updateDone(idsDto);
    }


    @PatchMapping("/update/{id}")
    public  void updateDeleteAt(@PathVariable Long id) throws RecordNotFoundException {
        service.updateDeleted(id);
    }
}
