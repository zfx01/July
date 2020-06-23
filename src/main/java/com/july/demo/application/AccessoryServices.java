package com.july.demo.application;

import com.july.demo.application.port.inbound.AccessoryUsecase;
import com.july.demo.application.port.inbound.UserUsecase;
import com.july.demo.application.port.outbound.AccessoryRepository;
import com.july.demo.application.port.outbound.UserRepository;
import com.july.demo.domain.Accessory;
import com.july.demo.domain.Jid;
import com.july.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.projection.Accessor;
import org.springframework.stereotype.Service;

import javax.persistence.Access;
import java.util.List;


@Service
public class AccessoryServices implements AccessoryUsecase {

    @Autowired
    AccessoryRepository repository;

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
    public String add(Accessory accessory) {
        return repository.add(accessory);
    }

    @Override
    public String update(String id, Accessory accessory) {
        return repository.updatebyid(new Jid().of(id),accessory);
    }
}
