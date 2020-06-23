package com.july.demo.adpter.inbound;

import com.july.demo.application.port.inbound.OtherControllerUsecase;
import com.july.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

@Controller
@CrossOrigin("*")
public class OtherController {


    @Autowired
    OtherControllerUsecase usecase;


    @GetMapping("register")
    public String register_page(){
        return "registration";
    }

    @PostMapping("register")
    public String register(@RequestParam String username,@RequestParam String password,@RequestParam String email,@RequestParam String phone){

        usecase.register(new User(username,password,email,phone));
        return "login";
    }

    //获取邮箱验证码
    @ResponseBody
    @RequestMapping("getcode")
    public String getcode(@RequestParam String userto){
        return usecase.getcode(userto);
    }

    @GetMapping("login")
    public String login_page(){
        return "login";
    }


    @PostMapping("login")
    public String login(@RequestParam("email") String email,@RequestParam("password") String password ){
        System.out.println(email+password);
        String id= usecase.login(email,password);
        if(!id.equals(""))
            return "index";
        else
            return "login";
    }

    @RequestMapping("face")
    public String face(){
        return "face";
    }

    @RequestMapping("face2")
    public String face2(){
        return "face2";
    }

    @PostMapping("getimage")
    public String getimage(HttpServletRequest req,@RequestParam String card,@RequestParam MultipartFile file){
        String destFileName="";
        String card1=(String) req.getAttribute("card");
        MultipartFile file1=(MultipartFile) req.getAttribute("file");
        try {
            //2.根据时间戳创建新的文件名，这样即便是第二次上传相同名称的文件，也不会把第一次的文件覆盖了
            String fileName = System.currentTimeMillis() + file.getOriginalFilename();
            //3.通过req.getServletContext().getRealPath("") 获取当前项目的真实路径，然后拼接前面的文件名
            destFileName= req.getServletContext().getRealPath("") + "uploaded" + File.separator + fileName;
            //4.第一次运行的时候，这个文件所在的目录往往是不存在的，这里需要创建一下目录（创建到了webapp下uploaded文件夹下）
            File destFile = new File(destFileName);
            destFile.getParentFile().mkdirs();
            //5.把浏览器上传的文件复制到希望的位置
            file.transferTo(destFile);
            //6.把文件名放在model里，以便后续显示用
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "上传失败," + e.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
            return "上传失败," + e.getMessage();
        }
        System.out.println(destFileName);
        return "login";
    }


}
