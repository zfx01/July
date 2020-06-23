package com.july.demo.application.port.inbound;

import com.july.demo.domain.User;
import org.springframework.stereotype.Component;

@Component
public interface OtherControllerUsecase {

    String getcode(String userto);

    String register(User user);

    String login(String email,String password);
}
