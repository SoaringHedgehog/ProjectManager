package com.example.demo.controller;

import com.example.demo.model.entity.ProjectEntity;
import com.example.demo.model.requestDTO.ProjectUpdateRequestDTO;
import com.example.demo.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService){
        this.projectService = projectService;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> create(@RequestBody ProjectEntity projectEntity){
        try{
            ProjectEntity projectEntityForResponse = projectService.create(projectEntity);
            return new ResponseEntity<>(projectEntityForResponse, HttpStatus.CREATED);
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable UUID id){
        try{
            ProjectEntity projectEntity = projectService.findById(id);
            return new ResponseEntity<>(projectEntity, HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/findByName/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name){
        try{
            ProjectEntity projectEntity = projectService.findByName(name);
            return new ResponseEntity<>(projectEntity, HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/updateById/{id}")
    public ResponseEntity<?> updateFieldById(@PathVariable UUID id, @RequestBody ProjectUpdateRequestDTO projectUpdateRequestDTO){
        try{
            ProjectEntity projectEntity = projectService.updateFieldById(id, projectUpdateRequestDTO);
            return new ResponseEntity<>(projectEntity, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<?> deleteById(@PathVariable UUID id){
        try{
            ProjectEntity projectEntity = projectService.deleteById(id);
            return new ResponseEntity<>(projectEntity, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteByName/{name}")
    public ResponseEntity<?> deleteByName(@PathVariable String name){
        try{
            int projectEntity = projectService.deleteByName(name);
            return new ResponseEntity<>(projectEntity, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/info")
    public List<ProjectEntity> getAllProjects(){
        return projectService.getAllProjects();
    }
}
