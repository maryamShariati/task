package ir.chica.task.controller;

import ir.chica.task.dto.UserDto;
import ir.chica.task.exception.RecordNotFoundException;
import ir.chica.task.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")


public class UserController {
    private final UserService userService;

    @PostMapping("/save")
    public void save(@RequestBody UserDto userDto){
        userService.save(userDto);
    }

    @PatchMapping("/update/{username}/{password}")
    public void updatePassword(@PathVariable String username,@PathVariable String password) throws RecordNotFoundException {
        userService.updatePasswordByUsername(username,password);

    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) throws RecordNotFoundException {
        userService.deleteById(id);
    }

    @GetMapping("/get/{id}")
    public void getById(@PathVariable Long id){
        userService.getById(id);
    }




}
