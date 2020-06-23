package com.july.demo.adpter.outbound;

import com.july.demo.application.port.outbound.CommentRepository;
import com.july.demo.domain.Comment;
import com.july.demo.domain.Jid;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaCommentRepository extends CommentRepository, JpaRepository<Comment, Jid> {

    @Override
    default String deletebyid(Jid id){
        this.deleteById(id);
        return id.getValue();
    }

    @Override
    default String add(Comment comment){
        this.save(comment);
        return comment.getId().getValue();
    }

    @Override
    default List<Comment> findall (){
        return this.findAll();
    }

    @Override
    default Comment findbyid(Jid id){
        return this.findById(id).get();
    }

    @Override
    default String updatebyid(Jid id,Comment comment){
        comment.setId(id);
        this.save(comment);
        return id.getValue();
    }


}
