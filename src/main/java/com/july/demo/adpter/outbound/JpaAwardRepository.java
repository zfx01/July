package com.july.demo.adpter.outbound;

import com.july.demo.application.port.outbound.AwardRepository;
import com.july.demo.domain.Award;
import com.july.demo.domain.Jid;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaAwardRepository extends AwardRepository, JpaRepository<Award, Jid> {

    List<Award> findByExpertgroup(String groupid);

    @Override
    default String deletebyid(Jid id){
        this.deleteById(id);
        return id.getValue();
    }

    @Override
    default String add(Award award){
        this.save(award);
        return award.getId().getValue();
    }

    @Override
    default List<Award> findall (){
        return this.findAll();
    }

    @Override
    default Award findbyid(Jid id){
        return this.findById(id).get();
    }

    @Override
    default String updatebyid(Jid id,Award award){
        award.setId(id);
        this.save(award);
        return id.getValue();
    }

    @Override
    default List<Award> findbygroup(String groupid){
        return this.findByExpertgroup(groupid);
    }


}
