package com.july.demo.application;

import com.july.demo.application.port.inbound.ExpertUsecase;
import com.july.demo.application.port.inbound.UserUsecase;
import com.july.demo.application.port.outbound.ExpertRepository;
import com.july.demo.application.port.outbound.UserRepository;
import com.july.demo.domain.Expert;
import com.july.demo.domain.Jid;
import com.july.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServices implements UserUsecase {

    @Autowired
    UserRepository repository;

    @Override
    public List<User> getall() {
        return repository.findall();
    }

    @Override
    public User findByid(String id) {
        return repository.findbyid(new Jid().of(id));
    }

    @Override
    public String deleteByid(String id) {
        return repository.deletebyid(new Jid().of(id));
    }

    @Override
    public String add(User user) {
        return repository.add(user);
    }

    @Override
    public String update(String id, User user) {
        return repository.updatebyid(new Jid().of(id),user);
    }
}
