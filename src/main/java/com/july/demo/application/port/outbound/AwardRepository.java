package com.july.demo.application.port.outbound;

import com.july.demo.domain.Award;
import com.july.demo.domain.Jid;
import com.july.demo.domain.User;
import com.july.demo.domain.Vote;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface AwardRepository {


    String add(Award award);

    String deletebyid(Jid id);

    String updatebyid(Jid id, Award award);

    Award findbyid(Jid id);

    List<Award> findall();

    List<Award> findbygroup(String groupid);
}
