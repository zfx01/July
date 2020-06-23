package com.july.demo.adpter.inbound;

import com.july.demo.application.port.inbound.ProjectUsecase;
import com.july.demo.domain.Projects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Project")
@CrossOrigin("*")
public class ProjectController {

    @Autowired
    ProjectUsecase usecase;

    @GetMapping("getallproject")
    public List<Projects> getallProject(){
        return usecase.getall();
    }

    @PostMapping("addproject")
    public String addProject(Projects project){
        return usecase.add(project);
    }

    @GetMapping("getProjectbyid")
    public Projects findByid(String id){
        return usecase.findByid(id);
    }

    @DeleteMapping("deleteProjectbyid")
    public String deleteProjectbyid(String id){
        return usecase.deleteByid(id);
    }

    @PutMapping("updateProjectbyid")
    public String updateProjectbyid(String id,Projects project){
        return usecase.update(id,project);
    }
}
