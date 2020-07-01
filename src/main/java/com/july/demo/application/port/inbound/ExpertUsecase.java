package com.july.demo.application.port.inbound;

import com.july.demo.domain.Expert;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ExpertUsecase {

    List<Expert> getall();

    Expert findByid(String id);

    String deleteByid(String id);

    String add(Expert expert);

    String update(String id,Expert expert);

    List<Expert> findUsernameAndPassword(String email, String password);
}
