package com.july.demo.adpter.inbound;

import com.july.demo.application.port.inbound.ProjectUsecase;
import com.july.demo.domain.Member;
import com.july.demo.domain.Projects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/Project")
@CrossOrigin("*")
public class ProjectController {

    @Autowired
    ProjectUsecase usecase;

    @GetMapping("getallproject")
    @ResponseBody
    public List<Projects> getallProject(){
        return usecase.getall();
    }

    @PostMapping("addproject")
    @ResponseBody
    public String addProject(@RequestBody Projects project, HttpServletRequest request){
//        String m1=request.getParameter("member1");
//        String m2=request.getParameter("member2");
//        String m3=request.getParameter("member3");
//        String m4=request.getParameter("member4");
//        project.setMember(new Member(m1,m2,m3,m4,project.getOwer()));
        return usecase.add(project);
    }

    @GetMapping("getProjectbyid")
    @ResponseBody
    public Projects findByid(String id){
        return usecase.findByid(id);
    }

    @DeleteMapping("deleteProjectbyid")
    @ResponseBody
    public void deleteProjectbyid(@RequestParam String id) {
        usecase.deleteByid(id);
    }

    @PutMapping("updateProjectbyid")
    @ResponseBody
    public String updateProjectbyid(String id,Projects project){
        return usecase.update(id,project);
    }


    @GetMapping("getproject")
    public String getproject(Model model,@RequestParam String id){
        model.addAttribute("obj",usecase.findByid(id));
        return "lzy/review";
    }

    @GetMapping("pass")
    public String pass(@RequestParam String id,@RequestParam String id2){
        usecase.pass(id,usecase.findByid(id));
        return "admin_index/projects?id="+id2;
    }
    @GetMapping("fail")
    public String fail(@RequestParam String id,Projects projects,@RequestParam String id2){
        usecase.fail(id,usecase.findByid(id));
        return "admin_index/projects?id="+id2;
    }

    @GetMapping("findbyower")
    @ResponseBody
    public List<Projects> findbyower(@RequestParam String id) {
        return usecase.findByower(id);
    }

}
