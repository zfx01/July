package com.july.demo.application.port.outbound;

import com.july.demo.domain.Expert;
import com.july.demo.domain.Jid;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ExpertRepository {

    String add(Expert expert);

    String deletebyid(Jid id);

    String updatebyid(Jid id,Expert expert);

    Expert findbyid(Jid id);

    List<Expert> findall();

}
