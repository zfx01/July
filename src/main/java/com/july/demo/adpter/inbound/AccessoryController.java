package com.july.demo.adpter.inbound;

import com.july.demo.application.port.inbound.AccessoryUsecase;
import com.july.demo.application.port.inbound.AccessoryUsecase;
import com.july.demo.domain.Accessory;
import com.july.demo.domain.Accessory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Access;
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
    public String upload(@RequestParam("file") MultipartFile file){
        return file.getOriginalFilename();
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
