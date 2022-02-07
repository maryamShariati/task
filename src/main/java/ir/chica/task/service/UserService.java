package ir.chica.task.service;

import ir.chica.task.dto.SerializeDto;
import ir.chica.task.dto.UserDto;
import ir.chica.task.exception.RecordNotFoundException;
import ir.chica.task.exception.UsernameNotFoundException;
import ir.chica.task.model.Serialization;
import ir.chica.task.model.User;
import ir.chica.task.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository repository;

//    public void save(SerializeDto serializeDto) throws IOException {
//        repository.save(User.save(serializeDto));
//    }
//
//    public void getUserNameAndPasswordById(Long id) throws RecordNotFoundException, IOException, ClassNotFoundException {
//        User user =repository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
//        ObjectInputStream in=new ObjectInputStream(new FileInputStream("f.txt"));
//        Serialization s= (Serialization) in.readObject();
//        System.out.println("id:"+s.getId()+", username:"+s.getUsername()+", password:"+s.getPassword());
//        in.close();
//
//    }

    public void updatePasswordByUsername(String username,String password) throws RecordNotFoundException {
        User user =repository.findByUsername(username).orElseThrow(() -> new RecordNotFoundException(username));
        user.setPassword(password);
        repository.save(user);
    }

    public void deleteById(Long id)throws  RecordNotFoundException{
        User user =repository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
        user.setDeleted(true);
        repository.save(user);
    }

    public Optional<User> getById(Long id) {

        return repository.findByIdAndDeletedFalse(id);
    }

    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsernameAndDeletedIsFalse(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }




}

