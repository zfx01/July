package com.july.demo.adpter.inbound;

import com.july.demo.application.port.inbound.ExpertUsecase;
import com.july.demo.domain.Expert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expert")
@CrossOrigin("*")
public class ExpertController {

    @Autowired
    ExpertUsecase usecase;

    @GetMapping("getallexpert")
    public List<Expert> getallexpert(){
        return usecase.getallexpert();
    }

    @PostMapping("addexpert")
    public String addexpert(Expert expert){
        return usecase.add(expert);
    }

    @GetMapping("getexpertbyid")
    public Expert findByid(String id){
        return usecase.findByid(id);
    }

    @DeleteMapping("deleteexpertbyid")
    public String deleteexpertbyid(String id){
        return usecase.deleteByid(id);
    }

    @PutMapping("updateexpertbyid")
    public String updateexpertbyid(String id,Expert expert){
        return usecase.update(id,expert);
    }
}
