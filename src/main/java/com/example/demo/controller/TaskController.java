package com.example.demo.controller;

import com.example.demo.model.entity.TaskEntity;
import com.example.demo.model.requestDTO.TaskUpdateRequestDTO;
import com.example.demo.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> create(@RequestBody TaskEntity taskEntity){
        try{
            TaskEntity taskEntityForResponse = taskService.create(taskEntity);
            return new ResponseEntity<>(taskEntityForResponse, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable UUID id){
        try{
            TaskEntity taskEntity = taskService.findById(id);
            return new ResponseEntity<>(taskEntity, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/findByName/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name){
        try{
            TaskEntity taskEntity = taskService.findByName(name);
            return new ResponseEntity<>(taskEntity, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // Аннотация для частичного обновления сущности
    @PatchMapping(value = "/updateById/{id}")
    public ResponseEntity<?> updateFieldById(@PathVariable UUID id, @RequestBody TaskUpdateRequestDTO taskUpdateRequestDTO){
        try{
            TaskEntity taskEntity = taskService.updateFieldById(id, taskUpdateRequestDTO);
            return new ResponseEntity<>(taskEntity, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<?> deleteById(@PathVariable UUID id){
        try{
            TaskEntity taskEntity = taskService.deleteById(id);
            return new ResponseEntity<>(taskEntity, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteByName/{name}")
    public ResponseEntity<?> deleteByName(@PathVariable String name){
        try{
            int taskEntity = taskService.deleteByName(name);
            return new ResponseEntity<>(taskEntity, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/info")
    public List<TaskEntity> getAllTasks(){
        return taskService.getAllTasks();
    }
}
