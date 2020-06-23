package com.july.demo.application;

import com.july.demo.application.port.inbound.AwardUsecase;
import com.july.demo.application.port.outbound.AwardRepository;
import com.july.demo.domain.Award;
import com.july.demo.domain.Jid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AwardServices implements AwardUsecase {

    @Autowired
    AwardRepository repository;

    @Override
    public List<Award> getall() {
        return repository.findall();
    }

    @Override
    public Award findByid(String id) {
        return repository.findbyid(new Jid().of(id));
    }

    @Override
    public String deleteByid(String id) {
        return repository.deletebyid(new Jid().of(id));
    }

    @Override
    public String add(Award award) {
        return repository.add(award);
    }

    @Override
    public String update(String id, Award award) {
        return repository.updatebyid(new Jid().of(id),award);
    }
}
