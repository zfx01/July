package com.july.demo.adpter.outbound;

import com.july.demo.application.port.outbound.AccessoryRepository;
import com.july.demo.domain.Jid;
import com.july.demo.domain.Accessory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaAccessoryRepository extends AccessoryRepository,JpaRepository<Accessory, Jid> {

    @Override
    default String deletebyid(Jid id){
        this.deleteById(id);
        return id.getValue();
    }

    @Override
    default String add(Accessory accessory){
        this.save(accessory);
        return accessory.getId().getValue();
    }

    @Override
    default List<Accessory> findall (){
        return this.findAll();
    }

    @Override
    default Accessory findbyid(Jid id){
        return this.findById(id).get();
    }

    @Override
    default String updatebyid(Jid id,Accessory accessory){
        accessory.setId(id);
        this.save(accessory);
        return id.getValue();
    }


}