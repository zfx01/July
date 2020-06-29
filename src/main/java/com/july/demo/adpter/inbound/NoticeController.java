package com.july.demo.adpter.inbound;


import com.july.demo.application.port.inbound.NoticeUsecase;
import com.july.demo.domain.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/Notice")
@CrossOrigin("*")

public class NoticeController {
    @Autowired
    NoticeUsecase usecase;

    @GetMapping("getallnotice")
    public List<Notice> getallNotice(){
        return usecase.getall();
    }

    @PostMapping("addnotice")
    public String addNotice(Notice notice){
        return usecase.add(notice);
    }

    @GetMapping("getNoticebyid")
    public Notice findByid(String id){
        return usecase.findByid(id);
    }

    @DeleteMapping("deleteNoticebyid")
    public String deleteNoticebyid(String id){
        return usecase.deleteByid(id);
    }

    @PutMapping("updateNoticebyid")
    public String updateNoticebyid(String id,Notice notice){
        return usecase.update(id,notice);
    }
}
