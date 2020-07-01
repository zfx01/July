package com.july.demo.adpter.outbound;

import com.july.demo.application.port.outbound.AdminRepository;
import com.july.demo.domain.Admin;
import com.july.demo.domain.Jid;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaAdminRepository extends AdminRepository, JpaRepository<Admin, Jid> {

    List<Admin> findByUsernameAndPassword(String username,String password);


    @Override
    default String deletebyid(Jid id){
        this.deleteById(id);
        return id.getValue();
    }

    @Override
    default String add(Admin admin){
        this.save(admin);
        return admin.getId().getValue();
    }

    @Override
    default List<Admin> findall (){
        return this.findAll();
    }

    @Override
    default Admin findbyid(Jid id){
        return this.findById(id).get();
    }

    @Override
    default String updatebyid(Jid id,Admin admin){
        admin.setId(id);
        this.save(admin);
        return id.getValue();
    }


    @Override
    default List<Admin> findByUsernameAndpassword(String username,String password){
        return this.findByUsernameAndPassword(username,password);
    }


}
