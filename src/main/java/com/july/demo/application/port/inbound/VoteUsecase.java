package com.july.demo.application.port.inbound;

import com.july.demo.domain.User;
import com.july.demo.domain.Vote;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface VoteUsecase {

    List<Vote> getall();

    Vote findByid(String id);

    String deleteByid(String id);

    String add(Vote vote);

    String update(String id,Vote vote);
}
