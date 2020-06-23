package com.july.demo.application.port.inbound;

import com.july.demo.domain.Projects;
import com.july.demo.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProjectUsecase {

    List<User> getall();

    User findByid(String id);

    String deleteByid(String id);

    String add(Projects projects);

    String update(String id,Projects projects);
}
