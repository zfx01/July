package com.july.demo.application.port.inbound;

import com.july.demo.domain.Award;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AwardUsecase {

    List<Award> getall();

    Award findByid(String id);

    String deleteByid(String id);

    String add(Award award);

    String update(String id,Award award);

    List<Award> findBygroup(String groupid);
}
