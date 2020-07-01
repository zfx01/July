package com.july.demo.adpter.outbound;

import com.july.demo.application.port.outbound.ExpertRepository;
import com.july.demo.domain.Jid;
import com.july.demo.domain.Expert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaExpertRepository extends ExpertRepository, JpaRepository<Expert, Jid> {

    List<Expert> findByUsernameAndPassword(String username,String password);


    @Override
    default String deletebyid(Jid id){
        this.deleteById(id);
        return id.getValue();
    }

    @Override
    default String add(Expert expert){
        this.save(expert);
        return expert.getId().getValue();
    }

    @Override
    default List<Expert> findall (){
        return this.findAll();
    }

    @Override
    default Expert findbyid(Jid id){
        return this.findById(id).get();
    }

    @Override
    default String updatebyid(Jid id,Expert expert){
        expert.setId(id);
        this.save(expert);
        return id.getValue();
    }

    @Override
    default List<Expert> findUsernameAndpassword(String username,String password){
        return this.findByUsernameAndPassword(username,password);
    }


}
