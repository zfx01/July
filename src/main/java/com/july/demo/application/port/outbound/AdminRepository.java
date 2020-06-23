package com.july.demo.application.port.outbound;

import com.july.demo.domain.Admin;
import com.july.demo.domain.Jid;
import com.july.demo.domain.User;
import com.july.demo.domain.Vote;

import java.util.List;

public interface AdminRepository {


    String add(Admin admin);

    String deletebyid(Jid id);

    String updatebyid(Jid id, Admin admin);

    Admin findbyid(Jid id);

    List<Admin> findall();
}
