package com.july.demo.application.port.outbound;

import com.july.demo.domain.Jid;
import com.july.demo.domain.User;
import com.july.demo.domain.Vote;

import java.util.List;

public interface VoteRepository {


    String add(Vote vote);

    String deletebyid(Jid id);

    String updatebyid(Jid id, Vote vote);

    Vote findbyid(Jid id);

    List<Vote> findall();
}
