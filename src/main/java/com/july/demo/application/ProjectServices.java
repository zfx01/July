package com.july.demo.application;

import com.july.demo.application.port.inbound.ProjectUsecase;
import com.july.demo.application.port.outbound.ProjectRepository;
import com.july.demo.domain.Jid;
import com.july.demo.domain.Projects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProjectServices implements ProjectUsecase {

    @Autowired
    ProjectRepository repository;

    @Override
    public List<Projects> getall() {
        return repository.findall();
    }

    @Override
    public Projects findByid(String id) {
        return repository.findbyid(new Jid().of(id));
    }

    @Override
    public String deleteByid(String id) {
        return repository.deletebyid(new Jid().of(id));
    }

    @Override
    public String add(Projects projects) {
        return repository.add(projects);
    }

    @Override
    public String update(String id, Projects projects) {
        return repository.updatebyid(new Jid().of(id),projects);
    }
}
