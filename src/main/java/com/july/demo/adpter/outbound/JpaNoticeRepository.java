package com.july.demo.adpter.outbound;

import com.july.demo.application.port.outbound.NoticeRepository;
import com.july.demo.domain.Notice;
import com.july.demo.domain.Jid;
import com.july.demo.domain.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaNoticeRepository extends JpaRepository<Notice,Jid>, NoticeRepository {

    @Override
    default String deletebyid(Jid id){
        this.deleteById(id);
        return id.getValue();
    }

    @Override
    default String add(Notice notice){
        this.save(notice);
        return notice.getId().getValue();
    }

    @Override
    default List<Notice> findall (){
        return this.findAll();
    }

    @Override
    default Notice findbyid(Jid id){
        return this.findById(id).get();
    }

    @Override
    default String updatebyid(Jid id,Notice notice){
        notice.setId(id);
        this.save(notice);
        return id.getValue();
    }
}
