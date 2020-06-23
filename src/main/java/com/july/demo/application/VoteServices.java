package com.july.demo.application;

import com.july.demo.application.port.inbound.VoteUsecase;
import com.july.demo.application.port.outbound.VoteRepository;
import com.july.demo.domain.Jid;
import com.july.demo.domain.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VoteServices implements VoteUsecase {

    @Autowired
    VoteRepository repository;

    @Override
    public List<Vote> getall() {
        return repository.findall();
    }

    @Override
    public Vote findByid(String id) {
        return repository.findbyid(new Jid().of(id));
    }

    @Override
    public String deleteByid(String id) {
        return repository.deletebyid(new Jid().of(id));
    }

    @Override
    public String add(Vote vote) {
        return repository.add(vote);
    }

    @Override
    public String update(String id, Vote vote) {
        return repository.updatebyid(new Jid().of(id),vote);
    }
}
