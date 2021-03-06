package com.july.demo.application.port.inbound;

import com.july.demo.domain.Projects;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProjectUsecase {

    List<Projects> getall();

    Projects findByid(String id);

    String deleteByid(String id);

    String add(Projects projects);

    String update(String id,Projects projects);

    List<Projects> findByower(String ower);

    String pass(String id,Projects projects);

    String fail(String id,Projects projects);

    Projects findByidandstatus(String id,String status);
}
