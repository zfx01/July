package com.july.demo.adpter.outbound;

import com.july.demo.application.port.outbound.VoteRepository;
import com.july.demo.domain.Vote;
import com.july.demo.domain.Jid;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaVoteRepository extends VoteRepository, JpaRepository<Vote, Jid> {

    @Override
    default String deletebyid(Jid id){
        this.deleteById(id);
        return id.getValue();
    }

    @Override
    default String add(Vote vote){
        this.save(vote);
        return vote.getId().getValue();
    }

    @Override
    default List<Vote> findall (){
        return this.findAll();
    }

    @Override
    default Vote findbyid(Jid id){
        return this.findById(id).get();
    }

    @Override
    default String updatebyid(Jid id,Vote vote){
        vote.setId(id);
        this.save(vote);
        return id.getValue();
    }


}
