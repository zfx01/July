package com.july.demo.adpter.inbound;

import com.july.demo.application.port.inbound.AccessoryUsecase;
import com.july.demo.application.port.inbound.AccessoryUsecase;
import com.july.demo.domain.Accessory;
import com.july.demo.domain.Accessory;
import com.july.demo.domain.Jid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Access;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/Accessory")
@CrossOrigin("*")
public class AccessoryController {

    @Autowired
    AccessoryUsecase usecase;

    @GetMapping("getallaccessory")
    public List<Accessory> getallAccessory(){
        return usecase.getall();
    }

    @PostMapping("upload")
    public String upload(@RequestParam("file") MultipartFile file, HttpServletRequest req){
        String destFileName="";
        try {
            //2.根据时间戳创建新的文件名，这样即便是第二次上传相同名称的文件，也不会把第一次的文件覆盖了
            String fileName = System.currentTimeMillis() + file.getOriginalFilename();
            //3.通过req.getServletContext().getRealPath("") 获取当前项目的真实路径，然后拼接前面的文件名
            destFileName= ResourceUtils.getURL("static").getPath()+"uploaded/" + fileName;
//            destFileName= ResourceUtils.getURL("static").getPath()+"/uploaded/" + fileName;
            //4.第一次运行的时候，这个文件所在的目录往往是不存在的，这里需要创建一下目录（创建到了webapp下uploaded文件夹下）
            File destFile = new File(destFileName);

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


        return addAccessory(new Accessory(new Jid(),destFileName.split("static")[1]));
    }

    @PostMapping("uploadimg")
    public String uploadimg(@RequestParam("file") MultipartFile file, HttpServletRequest req){
        String destFileName="";
        try {
            //2.根据时间戳创建新的文件名，这样即便是第二次上传相同名称的文件，也不会把第一次的文件覆盖了
            String fileName = System.currentTimeMillis() + file.getOriginalFilename();
            //3.通过req.getServletContext().getRealPath("") 获取当前项目的真实路径，然后拼接前面的文件名
            destFileName=ResourceUtils.getURL("static").getPath()+"uploaded/" + fileName;

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
        addAccessory(new Accessory(new Jid(),destFileName.split("static")[1]));
        String[] s= destFileName.split("/");

        return destFileName.split("static")[1];
    }

    @PostMapping("addaccessory")
    public String addAccessory(Accessory accessory){
        return usecase.add(accessory);
    }

    @GetMapping("getAccessorybyid")
    public Accessory findByid(String id){
        return usecase.findByid(id);
    }

    @DeleteMapping("deleteAccessorybyid")
    public String deleteAccessorybyid(String id){
        return usecase.deleteByid(id);
    }

    @PutMapping("updateAccessorybyid")
    public String updateAccessorybyid(String id,Accessory accessory){
        return usecase.update(id,accessory);
    }
}
