package com.july.demo.adpter.inbound;

import com.july.demo.application.port.inbound.UserUsecase;
import com.july.demo.application.port.inbound.UserUsecase;
import com.july.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
@CrossOrigin("*")
public class UserController {

    @Autowired
    UserUsecase usecase;

    @GetMapping("getalluser")
    public List<User> getallUser(){
        return usecase.getall();
    }

    @PostMapping("adduser")
    public String addUser(User user){
        return usecase.add(user);
    }

    @GetMapping("getUserbyid")
    public User findByid(String id){
        return usecase.findByid(id);
    }

    @DeleteMapping("deleteUserbyid")
    public String deleteUserbyid(@RequestParam  String id){
        return usecase.deleteByid(id);
    }

    @PutMapping("updateUserbyid")
    public String updateUserbyid(String id,User user){
        return usecase.update(id,user);
    }


}
