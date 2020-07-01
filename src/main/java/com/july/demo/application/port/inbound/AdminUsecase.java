package com.july.demo.application.port.inbound;

import com.july.demo.domain.Admin;
import com.july.demo.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AdminUsecase {

    List<Admin> getall();

    Admin findByid(String id);

    String deleteByid(String id);

    String add(Admin admin);

    String update(String id,Admin admin);

    List<Admin> findUsernameAndPassword(String username, String password);
}
