package ir.chica.task.service;

import ir.chica.task.dto.IdsDto;
import ir.chica.task.dto.TaskDto;
import ir.chica.task.exception.RecordNotFoundException;
import ir.chica.task.model.Task;
import ir.chica.task.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional

public class TaskService {
    private final TaskRepository taskRepository;


    public void save(TaskDto taskDto) {

        taskRepository.save(Task.fromTaskDto(taskDto));
    }

    public void deleteById(Long id) throws RecordNotFoundException {
        Task task = taskRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("record not found"));
        task.setDeleted(true);
        taskRepository.save(task);
    }

    public void updateDeleted(Long id) throws RecordNotFoundException {
        taskRepository.updateDeletedAt(id);
    }

    public void updateNameById(Long id, String name) {
        taskRepository.updateName(id, name);
    }

    public void updateDone(IdsDto id) {
        taskRepository.updateDone(id);
    }


    public Optional<Task> getById(Long id) {
        return taskRepository.findByIdAndDeletedFalse(id);
    }


}
