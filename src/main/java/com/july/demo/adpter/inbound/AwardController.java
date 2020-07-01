package com.july.demo.adpter.inbound;

import com.july.demo.application.port.inbound.AwardUsecase;
import com.july.demo.domain.Award;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Award")
@CrossOrigin("*")
public class AwardController {

    @Autowired
    AwardUsecase usecase;

    @GetMapping("getallaward")
    public List<Award> getallAward(){
        return usecase.getall();
    }

    @PostMapping("addaward")
    public String addAward(Award award){
        return usecase.add(award);
    }

    @GetMapping("getAwardbyid")
    public Award findByid(String id){
        return usecase.findByid(id);
    }

    @DeleteMapping("deleteAwardbyid")
    public String deleteAwardbyid(String id){
        return usecase.deleteByid(id);
    }

    @PutMapping("updateAwardbyid")
    public String updateAwardbyid(String id,Award award){
        return usecase.update(id,award);
    }

    @GetMapping("getbygroup")
    public List<Award> getbygroup(String expertgroupid){
        return usecase.findBygroup(expertgroupid);
    }
}
