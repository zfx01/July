package com.july.demo.adpter.inbound;

import com.july.demo.application.port.inbound.CommentUsecase;
import com.july.demo.domain.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/Comment")
@CrossOrigin("*")
public class CommentController {

    @Autowired
    CommentUsecase usecase;

    @GetMapping("getallcomment")
    public List<Comment> getallComment(){
        return usecase.getall();
    }

    @PostMapping("addcomment")
    public String addComment(@RequestBody Comment comment, HttpServletRequest request){
        return usecase.add(comment,request);
    }

    @GetMapping("getCommentbyid")
    public Comment findByid(String id){
        return usecase.findByid(id);
    }

    @DeleteMapping("deleteCommentbyid")
    public String deleteCommentbyid(String id){
        return usecase.deleteByid(id);
    }

    @PutMapping("updateCommentbyid")
    public String updateCommentbyid(String id,Comment comment){
        return usecase.update(id,comment);
    }


}
