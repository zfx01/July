package com.july.demo.application.port.inbound;

import com.july.demo.domain.Comment;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Component
public interface CommentUsecase {

    List<Comment> getall();

    Comment findByid(String id);

    String deleteByid(String id);

    String add(Comment comment, HttpServletRequest request);

    String update(String id,Comment comment);

    List<Comment> getbyproject(String id);
}
