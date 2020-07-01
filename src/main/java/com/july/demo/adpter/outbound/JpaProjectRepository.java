package com.july.demo.adpter.outbound;

import com.july.demo.application.port.outbound.ProjectRepository;
import com.july.demo.domain.Projects;
import com.july.demo.domain.Jid;
import com.july.demo.domain.Projects;
import com.sun.tools.corba.se.idl.StringGen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaProjectRepository extends ProjectRepository, JpaRepository<Projects, Jid> {

    List<Projects> findByOwer(String ower);



    @Override
    default String deletebyid(Jid id){
        this.deleteById(id);
        return id.getValue();
    }

    @Override
    default String add(Projects project){
        this.save(project);
        return project.getId().getValue();
    }

    @Override
    default List<Projects> findall (){
        return this.findAll();
    }

    @Override
    default Projects findbyid(Jid id){
        return this.findById(id).get();
    }

    @Override
    default String updatebyid(Jid id,Projects project){
        project.setId(id);
        this.save(project);
        return id.getValue();
    }

    @Override
    default List<Projects> findByower(String ower){
        return this.findByOwer(ower);
    }


}
