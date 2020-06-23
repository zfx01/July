package com.july.demo.application;

import com.july.demo.application.port.inbound.AccessoryUsecase;
import com.july.demo.application.port.outbound.AccessoryRepository;
import com.july.demo.domain.Accessory;
import com.july.demo.domain.Jid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AccessoryServices implements AccessoryUsecase {

    @Autowired
    AccessoryRepository repository;

    @Override
    public List<Accessory> getall() {
        return repository.findall();
    }

    @Override
    public Accessory findByid(String id) {
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
