package ir.chica.task.service;

import ir.chica.task.dto.UserDto;
import ir.chica.task.exception.RecordNotFoundException;
import ir.chica.task.model.User;
import ir.chica.task.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository repository;

    public void save(UserDto userDto){
        repository.save(User.fromUserDto(userDto));
    }

    public void updatePasswordByUsername(String username,String password) throws RecordNotFoundException {
        User user =repository.findByUsername(username).orElseThrow(RecordNotFoundException ::new);
        user.setPassword(password);
        repository.save(user);
    }

    public void deleteById(Long id)throws  RecordNotFoundException{
        User user =repository.findById(id).orElseThrow(RecordNotFoundException ::new);
        user.setDeleted(true);
        repository.save(user);
    }

    public Optional<User> getById(Long id) {

        return repository.findByIdAndDeletedFalse(id);
    }

}

