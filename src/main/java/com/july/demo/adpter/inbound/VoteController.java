package com.july.demo.adpter.inbound;

import com.july.demo.application.port.inbound.VoteUsecase;
import com.july.demo.domain.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Vote")
@CrossOrigin("*")
public class VoteController {

    @Autowired
    VoteUsecase usecase;

    @GetMapping("getallvote")
    public List<Vote> getallVote(){
        return usecase.getall();
    }

    @PostMapping("addvote")
    public String addVote(Vote vote){
        return usecase.add(vote);
    }

    @GetMapping("getVotebyid")
    public Vote findByid(String id){
        return usecase.findByid(id);
    }

    @DeleteMapping("deleteVotebyid")
    public String deleteVotebyid(String id){
        return usecase.deleteByid(id);
    }

    @PutMapping("updateVotebyid")
    public String updateVotebyid(String id,Vote vote){
        return usecase.update(id,vote);
    }
}
