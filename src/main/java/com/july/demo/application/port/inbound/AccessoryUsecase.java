package com.july.demo.application.port.inbound;

import com.july.demo.domain.Accessory;
import com.july.demo.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AccessoryUsecase {

    List<User> getall();

    User findByid(String id);

    String deleteByid(String id);

    String add(Accessory accessory);

    String update(String id,Accessory accessory);
}
