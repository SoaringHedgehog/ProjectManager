package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.entity.Task;
import com.example.demo.service.TaskService;
import com.example.demo.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @PostMapping
    public Task create(@RequestBody Task task){
        return taskService.create(task);
    }

    @GetMapping(value = "/findById/{id}")
    public Task findById(@PathVariable int id){
        return taskService.findById(id);
    }

    @GetMapping(value = "/findByName/{name}")
    public Task findByName(@PathVariable String name){
        return taskService.findByName(name);
    }

    // Аннотация для частичного обновления сущности
    @PatchMapping(value = "/updateById/{id}")
    public int updateFieldById(@PathVariable int id, @RequestBody Map<String, Object> payload){
        String fieldForUpdate = (String) payload.get("fieldForUpdate");
        String newValue = (String) payload.get("newValue");
        return taskService.updateFieldById(id, fieldForUpdate, newValue);
    }

    @PatchMapping(value = "/updateByName/{name}")
    public int updateFieldByName(@PathVariable String name, @RequestBody Map<String, Object> payload){
        String fieldForUpdate = (String) payload.get("fieldForUpdate");
        String newValue = (String) payload.get("newValue");
        return taskService.updateFieldByName(name, fieldForUpdate, newValue);
    }

    @DeleteMapping("/deleteById/{id}")
    public Task deleteById(@PathVariable int id){
        return taskService.deleteById(id);
    }

    @DeleteMapping("/deleteByName/{name}")
    public Task updateByName(@PathVariable String name){
        return taskService.deleteByName(name);
    }

    @GetMapping("/info")
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }
}
