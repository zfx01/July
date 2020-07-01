package com.july.demo.adpter.outbound;

import com.july.demo.application.port.outbound.UserRepository;
import com.july.demo.domain.Expert;
import com.july.demo.domain.Jid;
import com.july.demo.domain.User;
import lombok.Builder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaUserRepository  extends UserRepository,JpaRepository<User, Jid> {
    List<User> findByEmailAndPassword(String email, String password);
    List<User> findByEmail(String email);

    @Override
    default String register(User user){
        this.save(user);
        return user.getId().toString();
    }

    @Override
    default String login(String email,String password){
        List<User> list=findByEmailAndPassword(email,password);
        if(list.size()>0){
            return list.get(0).getId().getValue().toString();
        }
        return "";

    }

    @Override
    default String deletebyid(Jid id){
        this.deleteById(id);
        return id.getValue();
    }

    @Override
    default String add(User user){
        this.save(user);
        return user.getId().getValue();
    }

    @Override
    default List<User> findall (){
        return this.findAll();
    }

    @Override
    default User findbyid(Jid id){
        return this.findById(id).get();
    }

    @Override
    default String updatebyid(Jid id,User user){
        user.setId(id);
        this.save(user);
        return id.getValue();
    }

    @Override
    default String changepassword(String email,String password){
        User u= this.findByEmail(email).get(0);
        u.setPassword(password);
        return u.getId().toString();
    }




}