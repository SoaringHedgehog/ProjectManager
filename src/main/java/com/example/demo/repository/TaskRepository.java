package com.example.demo.repository;

import com.example.demo.model.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface TaskRepository extends JpaRepository<Task, String> {
    //Чтобы очистить контекст после выполнения запроса, иначе при последующем чтении можно получить устаревшие данные
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE tasks SET ?2 = ?3 WHERE id = ?1", nativeQuery = true)
    int updateFieldById(int id, String fieldName, String newValue);

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE tasks SET ?2 = ?3 WHERE name = ?1", nativeQuery = true)
    int updateFieldByName(String name, String fieldName, String newValue);

    Task findById(int id);
    Task findByName(String name);
    Task deleteById(int id);
    Task deleteByName(String name);
}
