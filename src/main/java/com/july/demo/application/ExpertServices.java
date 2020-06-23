package com.july.demo.application;

import com.july.demo.application.port.inbound.ExpertUsecase;
import com.july.demo.application.port.outbound.ExpertRepository;
import com.july.demo.domain.Expert;
import com.july.demo.domain.Jid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ExpertServices implements ExpertUsecase {

    @Autowired
    ExpertRepository repository;

    @Override
    public List<Expert> getallexpert() {
        return repository.findall();
    }

    @Override
    public Expert findByid(String id) {
        return repository.findbyid(new Jid().of(id));
    }

    @Override
    public String deleteByid(String id) {
        return repository.deletebyid(new Jid().of(id));
    }

    @Override
    public String add(Expert expert) {
        return repository.add(expert);
    }

    @Override
    public String update(String id, Expert expert) {
        return repository.updatebyid(new Jid().of(id),expert);
    }
}
