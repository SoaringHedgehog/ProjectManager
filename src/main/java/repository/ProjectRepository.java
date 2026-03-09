package repository;

import entity.Project;
import entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, String> {
    List<Project> finAllByUser(User user);
    Project create(int id, String name, String description, LocalDate dateStart, LocalDate dateFinish, int userId);
    Project findByName(String projectName);
    Project findById(int projectId);
    Project updateByName(String projectName, String fileForUpdate, String newValue);
    Project updateById(int projectId, String fileForUpdate, String newValue);
    Project delete(String projectName);
    int getRepositorySize();
}
