package com.july.demo.adpter.inbound;

import com.july.demo.application.port.inbound.OtherControllerUsecase;
import com.july.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
@CrossOrigin("*")
public class OtherController {

    private String path=null;
    {
        try {
            path = ResourceUtils.getURL("classpath:").getPath()+"static/Source/";
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

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

    //下载文件
    @ResponseBody
    @RequestMapping("download")
    private String downloadFile(HttpServletResponse response){
        String downloadFilePath = null;
        downloadFilePath = path+"test.docx";//被下载的文件在服务器中的路径,;
        String fileName = "test.docx";//被下载文件的名称
        File file = new File(downloadFilePath);
        System.out.println(downloadFilePath);
        if (file.exists()) {
            response.setContentType("application/force-download");// 设置强制下载不打开            
            response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream outputStream = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    outputStream.write(buffer, 0, i);
                    i = bis.read(buffer);
                }
                return "下载成功";
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return "下载失败";

    }

    //上传文件

    @ResponseBody
    @RequestMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) {
        try {
            if (file.isEmpty()) {
                return "文件为空";
            }
            // 获取文件名
            String fileName = file.getOriginalFilename();
            //log.info("上传的文件名为：" + fileName);
            // 获取文件的后缀名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            //log.info("文件的后缀名为：" + suffixName);
            // 设置文件存储路径
            path = path + fileName;
            File dest = new File(path);
            // 检测是否存在目录
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();// 新建文件夹
            }
            file.transferTo(dest);// 文件写入
            return "上传成功";
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传失败";
    }

    //获取图片
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

    @GetMapping("findpassword")
    public String findpassword(){
        return "findpassword";
    }

    @PutMapping("findpassword")
    public String findpasswordput(@RequestParam String password,@RequestParam String email){
        return usecase.changepassword(email,password);
    }



}
