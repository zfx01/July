package com.july.demo.application;

import com.july.demo.application.port.inbound.AdminUsecase;
import com.july.demo.application.port.outbound.AdminRepository;
import com.july.demo.domain.Admin;
import com.july.demo.domain.Jid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AdminServices implements AdminUsecase {

    @Autowired
    AdminRepository repository;

    @Override
    public List<Admin> getall() {
        return repository.findall();
    }

    @Override
    public Admin findByid(String id) {
        return repository.findbyid(new Jid().of(id));
    }

    @Override
    public String deleteByid(String id) {
        return repository.deletebyid(new Jid().of(id));
    }

    @Override
    public String add(Admin admin) {
        return repository.add(admin);
    }

    @Override
    public String update(String id, Admin admin) {
        return repository.updatebyid(new Jid().of(id),admin);
    }
}
