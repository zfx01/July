package com.july.demo.application;

import com.july.demo.adpter.outbound.JpaUserRepository;
import com.july.demo.application.port.inbound.OtherControllerUsecase;
import com.july.demo.domain.User;
import com.july.demo.other.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OtherServices implements OtherControllerUsecase {

    @Autowired
    EmailSender sender;

    @Autowired
    JpaUserRepository repository;

    public String getcode(String userto){
//        String activationCode = MD5.getMd5(new Date().toLocaleString(),32);
        //发送邮件：第一个参数是用户注册的邮箱，第二个参数是激活码
        String activationCode=String.valueOf((int)((Math.random() * 9 + 1) * 100000));
        sender.sendActivationMail(userto,activationCode);
//        //新增一条用户注册信息到数据库中，但是activated字段为0（表示为激活）
//        itripUserMapper.insertItripUser(user);

        return activationCode;
    }

    public String register(User user){
        return repository.register(user);
    }

    @Override
    public String login(String email, String password) {
        return repository.login(email,password);
    }
}
