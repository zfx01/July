package com.july.demo.application.port.inbound;

import com.july.demo.domain.Accessory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AccessoryUsecase {

    List<Accessory> getall();

    Accessory findByid(String id);

    String deleteByid(String id);

    String add(Accessory accessory);

    String update(String id,Accessory accessory);
}
