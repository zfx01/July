package com.july.demo.adpter.inbound;

import com.july.demo.application.port.inbound.ProjectUsecase;
import com.july.demo.domain.Member;
import com.july.demo.domain.Projects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
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
    public String addProject(@RequestBody Projects project, HttpServletRequest request, @RequestParam("file") MultipartFile file){
        String m1=request.getParameter("member1");
        String m2=request.getParameter("member2");
        String m3=request.getParameter("member3");
        String m4=request.getParameter("member4");
        project.setMember(new Member(m1,m2,m3,m4,project.getOwer()));
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
