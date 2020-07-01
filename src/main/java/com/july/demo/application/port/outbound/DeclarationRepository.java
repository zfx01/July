package com.july.demo.application.port.outbound;

import com.july.demo.domain.Declaration;
import com.july.demo.domain.Jid;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface DeclarationRepository {


    String add(Declaration declaration);

    String deletebyid(Jid id);

    String updatebyid(Jid id, Declaration declaration);

    Declaration findbyid(Jid id);

    List<Declaration> findall();

    List<Declaration> findByawardid(String awardid);
}
