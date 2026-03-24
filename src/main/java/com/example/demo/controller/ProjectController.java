package com.example.demo.controller;

import com.example.demo.model.entity.Project;
import com.example.demo.model.request.ProjectUpdateRequest;
import com.example.demo.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> create(@RequestBody Project project){
        try{
            Project projectForResponse = projectService.create(project);
            return new ResponseEntity<>(projectForResponse, HttpStatus.CREATED);
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable int id){
        try{
            Project project = projectService.findById(id);
            return new ResponseEntity<>(project, HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/findByName/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name){
        try{
            Project project = projectService.findByName(name);
            return new ResponseEntity<>(project, HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/updateById/{id}")
    public ResponseEntity<?> updateFieldById(@PathVariable int id, @RequestBody ProjectUpdateRequest projectUpdateRequest){
        try{
            Project project = projectService.updateFieldById(id, projectUpdateRequest);
            return new ResponseEntity<>(project, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id){
        try{
            Project project = projectService.deleteById(id);
            return new ResponseEntity<>(project, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteByName/{name}")
    public ResponseEntity<?> updateByName(@PathVariable String name){
        try{
            Project project = projectService.deleteByName(name);
            return new ResponseEntity<>(project, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // TODO Это нужно?
    @GetMapping("/info")
    public List<Project> getAllProjects(){
        return projectService.getAllProjects();
    }
}
