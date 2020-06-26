package com.july.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Data
@NoArgsConstructor
@Entity
public class Declaration {
    @EmbeddedId
    Jid id;
    String projectid;
    String awardid;
    String reason;
    String username;
    String email;
    String phone;
    String accessory;
    String filename;
    public Declaration(String projectid,String filename,String username,String phone,String email,String awardid,String reason,String accessory){
        this.id=new Jid();
        this.accessory=accessory;
        this.awardid=awardid;
        this.projectid=projectid;
        this.reason=reason;
        this.phone=phone;
        this.email=email;
        this.username=username;
        this.filename=filename;
    }
}
