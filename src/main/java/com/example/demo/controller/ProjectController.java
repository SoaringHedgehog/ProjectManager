package com.example.demo.controller;

import com.example.demo.model.entity.Project;
import com.example.demo.service.ProjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService){
        this.projectService = projectService;
    }

    @PostMapping
    public Project create(@RequestBody Project project){
        return projectService.create(project);
    }

    @GetMapping(value = "/findById/{id}")
    public Project findById(@PathVariable int id){
        return projectService.findById(id);
    }

    @GetMapping(value = "/findByName/{name}")
    public Project findByName(@PathVariable String name){
        return projectService.findByName(name);
    }

    // Аннотация для частичного обновления сущности
    @PatchMapping("/updateById/{id}")
    public void updateFieldById(@PathVariable int id, @RequestParam String fieldForUpdate, @RequestParam String newValue){
        projectService.updateFieldById(id, fieldForUpdate, newValue);
    }

    @PatchMapping("/updateByName/{name}")
    public void updateFieldByName(@PathVariable String name, @RequestParam String fieldForUpdate, @RequestParam String newValue){
        projectService.updateFieldByName(name, fieldForUpdate, newValue);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable int id){
        return projectService.deleteById(id);
    }

    @DeleteMapping("/deleteByName/{name}")
    public Project updateByName(@PathVariable String name){
        return projectService.deleteByName(name);
    }

    @GetMapping("/info")
    public List<Project> getAllProjects(){
        return projectService.getAllProjects();
    }
}
