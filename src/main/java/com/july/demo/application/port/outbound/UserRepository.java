package com.july.demo.application.port.outbound;

import com.july.demo.domain.Expert;
import com.july.demo.domain.Jid;
import com.july.demo.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface UserRepository{

    String register(User user);

    String login(String email, String password);

    String add(User user);

    String deletebyid(Jid id);

    String updatebyid(Jid id,User user);

    User findbyid(Jid id);

    List<User> findall();

    String changepassword(String email,String password);
}
