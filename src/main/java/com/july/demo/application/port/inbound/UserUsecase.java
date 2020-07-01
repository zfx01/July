package com.july.demo.application.port.inbound;

import com.july.demo.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserUsecase {

    List<User> getall();

    User findByid(String id);

    String deleteByid(String id);

    String add(User user);

    String update(String id,User user);

}
