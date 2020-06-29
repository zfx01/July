package com.july.demo.application.port.outbound;

import com.july.demo.domain.Notice;
import com.july.demo.domain.Jid;

import java.util.List;

public interface NoticeRepository {
    String add(Notice notice);

    String deletebyid(Jid id);

    String updatebyid(Jid id, Notice notice);

    Notice findbyid(Jid id);

    List<Notice> findall();
}
