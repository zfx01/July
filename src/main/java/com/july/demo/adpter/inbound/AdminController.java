package com.july.demo.adpter.inbound;

import com.july.demo.application.port.inbound.AdminUsecase;
import com.july.demo.domain.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Admin")
@CrossOrigin("*")
public class AdminController {

    @Autowired
    AdminUsecase usecase;

    @GetMapping("getalladmin")
    public List<Admin> getallAdmin(){
        return usecase.getall();
    }

    @PostMapping("addadmin")
    public String addAdmin(Admin admin){
        return usecase.add(admin);
    }

    @GetMapping("getAdminbyid")
    public Admin findByid(String id){
        return usecase.findByid(id);
    }

    @DeleteMapping("deleteAdminbyid")
    public String deleteAdminbyid(String id){
        return usecase.deleteByid(id);
    }

    @PutMapping("updateAdminbyid")
    public String updateAdminbyid(String id,Admin admin){
        return usecase.update(id,admin);
    }
}
