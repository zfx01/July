package com.july.demo.application.port.outbound;

import com.july.demo.domain.Jid;
import com.july.demo.domain.Projects;
import com.july.demo.domain.User;
import com.july.demo.domain.Vote;

import java.util.List;

public interface ProjectRepository {


    String add(Projects projects);

    String deletebyid(Jid id);

    String updatebyid(Jid id, Projects projects);

    User findbyid(Jid id);

    List<User> findall();
}
