package repository;

import entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface TaskRepository extends JpaRepository<Task, String> {
    Task create(int id, String name, String description, LocalDate dateStart, LocalDate dateFinish, int projectId);
    Task findByName(String taskName);
    Task findById(int projectId);
    Task updateByName(String taskName, String fieldForUpdate, String newValue);
    Task updateById(int taskId, String fileForUpdate, String newValue);
    Task deleteByName(String taskName);
    int getRepositorySize();
}
