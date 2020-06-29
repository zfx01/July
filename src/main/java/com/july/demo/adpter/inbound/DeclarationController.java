package com.july.demo.adpter.inbound;

import com.july.demo.application.port.inbound.DeclarationUsecase;
import com.july.demo.domain.Declaration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/Declaration")
@CrossOrigin("*")
public class DeclarationController {

    @Autowired
    DeclarationUsecase usecase;

    @GetMapping("getalldeclaration")
    public List<Declaration> getallDeclaration(){
        return usecase.getall();
    }

    @PostMapping("adddeclaration")
    public String addDeclaration(@RequestBody Declaration declaration,@RequestParam("file") MultipartFile file ){
        return usecase.add(declaration);
    }

    @GetMapping("getDeclarationbyid")
    public Declaration findByid(String id){
        return usecase.findByid(id);
    }

    @DeleteMapping("deleteDeclarationbyid")
    public String deleteDeclarationbyid(String id){
        return usecase.deleteByid(id);
    }

    @PutMapping("updateDeclarationbyid")
    public String updateDeclarationbyid(String id,Declaration declaration){
        return usecase.update(id,declaration);
    }
}
