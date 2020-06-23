package com.july.demo.application.port.outbound;

import com.july.demo.domain.Comment;
import com.july.demo.domain.Jid;
import com.july.demo.domain.User;
import com.july.demo.domain.Vote;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface CommentRepository {


    String add(Comment comment);

    String deletebyid(Jid id);

    String updatebyid(Jid id, Comment comment);

    Comment findbyid(Jid id);

    List<Comment> findall();
}
