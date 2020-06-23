package com.july.demo.application.port.outbound;

import com.july.demo.domain.User;

public interface UserRepository{

    String register(User user);

    String login(String email, String password);
}
