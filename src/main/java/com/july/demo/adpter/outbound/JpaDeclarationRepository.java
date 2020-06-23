package com.july.demo.adpter.outbound;

import com.july.demo.application.port.outbound.DeclarationRepository;
import com.july.demo.domain.Declaration;
import com.july.demo.domain.Jid;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaDeclarationRepository extends DeclarationRepository, JpaRepository<Declaration, Jid> {

    @Override
    default String deletebyid(Jid id){
        this.deleteById(id);
        return id.getValue();
    }

    @Override
    default String add(Declaration declaration){
        this.save(declaration);
        return declaration.getId().getValue();
    }

    @Override
    default List<Declaration> findall (){
        return this.findAll();
    }

    @Override
    default Declaration findbyid(Jid id){
        return this.findById(id).get();
    }

    @Override
    default String updatebyid(Jid id,Declaration declaration){
        declaration.setId(id);
        this.save(declaration);
        return id.getValue();
    }


}
