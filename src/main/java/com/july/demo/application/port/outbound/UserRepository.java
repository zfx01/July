package com.july.demo.application.port.outbound;

import com.july.demo.domain.Expert;
import com.july.demo.domain.Jid;
import com.july.demo.domain.User;

import java.util.List;

public interface UserRepository{

    String register(User user);

    String login(String email, String password);

    String add(User user);

    String deletebyid(Jid id);

    String updatebyid(Jid id,User user);

    User findbyid(Jid id);

    List<User> findall();
}
