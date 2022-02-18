package ir.chica.task.service;

import ir.chica.task.dto.UserDto;
import ir.chica.task.exception.RecordNotFoundException;
import ir.chica.task.model.User;
import ir.chica.task.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService implements UserDetailsService {

    private final UserRepository repository;

    public void save(UserDto userDto)  {
        repository.save(User.fromUserDto(userDto));
    }

    public void updatePasswordByUsername(String username,String password) throws RecordNotFoundException {
        User user =repository.findByUsername(username).orElseThrow(() -> new RecordNotFoundException(username));
        user.setPassword(password);
        repository.save(user);
    }
    public User getUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsernameAndDeletedIsFalse(username)
                .orElseThrow(() -> new UsernameNotFoundException("Invalid credential"));
    }

    public void deleteById(Long id)throws  RecordNotFoundException{
        User user =repository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
        user.setDeleted(true);
        repository.save(user);
    }

    public Optional<User> getById(Long id) {

        return repository.findByIdAndDeletedFalse(id);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsernameAndDeletedIsFalse(username)
                .orElseThrow(() -> new UsernameNotFoundException("Invalid credential"));
    }




}

