package com.july.demo.other;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailSender {

    @Autowired
    JavaMailSender mailSender;//发送邮件对象

    public void sendActivationMail(String maillTo, String activationCode) {
        //activationMailMessage 邮件信息对象
        SimpleMailMessage activationMailMessage = new SimpleMailMessage();
        String key = "activation"+maillTo;//收件方邮箱
        activationMailMessage.setSubject("July的注册验证码");//标题
        activationMailMessage.setFrom("2224185962@qq.com");//发送人
        //注入的简单邮件消息对象，设置收件方
        activationMailMessage.setTo(maillTo);
        //设置邮件正文
        activationMailMessage.setText("注册邮箱："+maillTo+"  激活码："+activationCode);
        //注入的邮件发送器，负责登录服务器，发送邮件
        mailSender.send(activationMailMessage);
//        //保存邮箱账号和激活码，到redis缓存中，30分钟后过期
//        redisService.set(key,activationCode,(long)30*60);
    }

}
