package com.july.demo.application;

import com.july.demo.application.port.inbound.DeclarationUsecase;
import com.july.demo.application.port.outbound.DeclarationRepository;
import com.july.demo.domain.Declaration;
import com.july.demo.domain.Jid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DeclarationServices implements DeclarationUsecase {

    @Autowired
    DeclarationRepository repository;

    @Override
    public List<Declaration> getall() {
        return repository.findall();
    }

    @Override
    public Declaration findByid(String id) {
        return repository.findbyid(new Jid().of(id));
    }

    @Override
    public String deleteByid(String id) {
        return repository.deletebyid(new Jid().of(id));
    }

    @Override
    public String add(Declaration declaration) {
        declaration.setId(new Jid());
        return repository.add(declaration);
    }

    @Override
    public String update(String id, Declaration declaration) {
        return repository.updatebyid(new Jid().of(id),declaration);
    }

    @Override
    public List<Declaration> findByawardid(String awardid) {
        return repository.findByawardid(awardid);
    }
}
