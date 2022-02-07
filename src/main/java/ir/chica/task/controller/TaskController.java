package ir.chica.task.controller;

import ir.chica.task.dto.IdsDto;
import ir.chica.task.dto.TaskDto;
import ir.chica.task.exception.RecordNotFoundException;
import ir.chica.task.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/task")
@Validated
public class TaskController {

    private final TaskService service;

    @PostMapping("/save")
    public void save(@RequestBody @Valid TaskDto taskDto) {
        service.save(taskDto);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) throws RecordNotFoundException {
        service.deleteById(id);
    }

    @PatchMapping("/update/{id}/{name}")
    public void updateName(@PathVariable Long id, @PathVariable String name) throws RecordNotFoundException {
        service.updateNameById(id, name);
    }

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
