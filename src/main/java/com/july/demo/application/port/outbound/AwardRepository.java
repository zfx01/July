package com.july.demo.application.port.outbound;

import com.july.demo.domain.Award;
import com.july.demo.domain.Jid;
import com.july.demo.domain.User;
import com.july.demo.domain.Vote;

import java.util.List;

public interface AwardRepository {


    String add(Award award);

    String deletebyid(Jid id);

    String updatebyid(Jid id, Award award);

    Award findbyid(Jid id);

    List<Award> findall();
}
