package com.july.demo.application.port.outbound;

import com.july.demo.domain.Jid;
import com.july.demo.domain.Projects;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface ProjectRepository {


    String add(Projects projects);

    String deletebyid(Jid id);

    String updatebyid(Jid id, Projects projects);

    Projects findbyid(Jid id);

    List<Projects> findall();
}
