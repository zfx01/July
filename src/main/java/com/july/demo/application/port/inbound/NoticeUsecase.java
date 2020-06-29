package com.july.demo.application.port.inbound;

import com.july.demo.domain.Notice;

import java.util.List;

public interface NoticeUsecase {

    List<Notice> getall();

    Notice findByid(String id);

    String deleteByid(String id);

    String add(Notice notice);

    String update(String id,Notice notice);
}
