package com.july.demo.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@Embeddable
public class Jid implements Serializable {
    @Column(name="id")
    private String value;
    public static Jid of(String id){
        Jid jid=new Jid();
        jid.value=UUID.fromString(id).toString();
        return jid;
    }

    public Jid(){
        this.value=UUID.randomUUID().toString();
    }

    public String getValue() {
        return value;
    }
}
