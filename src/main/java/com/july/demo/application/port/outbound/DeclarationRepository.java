package com.july.demo.application.port.outbound;

import com.july.demo.domain.Declaration;
import com.july.demo.domain.Jid;

import java.util.List;

public interface DeclarationRepository {


    String add(Declaration declaration);

    String deletebyid(Jid id);

    String updatebyid(Jid id, Declaration declaration);

    Declaration findbyid(Jid id);

    List<Declaration> findall();
}
