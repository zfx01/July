package com.july.demo.application;

import com.july.demo.application.port.inbound.CommentUsecase;
import com.july.demo.application.port.outbound.CommentRepository;
import com.july.demo.domain.Comment;
import com.july.demo.domain.Jid;
import com.july.demo.other.Gettime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Service
public class CommentServices implements CommentUsecase {

    @Autowired
    CommentRepository repository;

    @Override
    public List<Comment> getall() {
        return repository.findall();
    }

    @Override
    public Comment findByid(String id) {
        return repository.findbyid(new Jid().of(id));
    }

    @Override
    public String deleteByid(String id) {
        return repository.deletebyid(new Jid().of(id));
    }

    @Override
    public String add(@RequestBody Comment comment, HttpServletRequest request) {
        HttpSession session=request.getSession();
        String id=(String) session.getAttribute("id");
        comment.setId(new Jid());
        comment.setExpect(id);
        comment.setTime(Gettime.time());
        return repository.add(comment);
    }

    @Override
    public String update(String id, Comment comment) {
        return repository.updatebyid(new Jid().of(id),comment);
    }

    @Override
    public List<Comment> getbyproject(String id) {

        return repository.getbyproject(id);
    }
}
