package com.july.demo.application.port.inbound;

import com.july.demo.domain.Declaration;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DeclarationUsecase {

    List<Declaration> getall();

    Declaration findByid(String id);

    String deleteByid(String id);

    String add(Declaration declartion);

    String update(String id,Declaration declartion);

    List<Declaration> findByawardid(String awardid);

}
