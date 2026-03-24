package com.example.demo.controller;

import com.example.demo.model.entity.Task;
import com.example.demo.model.request.TaskUpdateRequest;
import com.example.demo.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Task task){
        try{
            Task taskForResponse = taskService.create(task);
            return new ResponseEntity<>(taskForResponse, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable int id){
        try{
            Task task = taskService.findById(id);
            return new ResponseEntity<>(task, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/findByName/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name){
        try{
            Task task = taskService.findByName(name);
            return new ResponseEntity<>(task, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // Аннотация для частичного обновления сущности
    @PatchMapping(value = "/updateById/{id}")
    public ResponseEntity<?> updateFieldById(@PathVariable int id, @RequestBody TaskUpdateRequest taskUpdateRequest){
        try{
            Task task = taskService.updateFieldById(id, taskUpdateRequest);
            return new ResponseEntity<>(task, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id){
        try{
            Task task = taskService.deleteById(id);
            return new ResponseEntity<>(task, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteByName/{name}")
    public ResponseEntity<?> deleteByName(@PathVariable String name){
        try{
            Task task = taskService.deleteByName(name);
            return new ResponseEntity<>(task, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/info")
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }
}
