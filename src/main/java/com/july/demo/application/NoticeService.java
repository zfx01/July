package com.july.demo.application;

import com.july.demo.application.port.inbound.NoticeUsecase;
import com.july.demo.application.port.outbound.NoticeRepository;
import com.july.demo.domain.Notice;
import com.july.demo.domain.Jid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NoticeService implements NoticeUsecase {
    @Autowired
    NoticeRepository repository;

    @Override
    public List<Notice> getall() {
        return repository.findall();
    }

    @Override
    public Notice findByid(String id) {
        return repository.findbyid(new Jid().of(id));
    }

    @Override
    public String deleteByid(String id) {
        return repository.deletebyid(new Jid().of(id));
    }

    @Override
    public String add(Notice notice) {
        return repository.add(notice);
    }

    @Override
    public String update(String id, Notice notice) {
        return repository.updatebyid(new Jid().of(id),notice);
    }
}
