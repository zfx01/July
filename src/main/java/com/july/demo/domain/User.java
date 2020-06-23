package com.july.demo.domain;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Data
@NoArgsConstructor
@Table(name = "user")
public class User {
    @EmbeddedId
    private Jid id;
    @NonNull
    private String username;
    @NonNull
    private String password;
    @NonNull
    private String email;
    private String phone;
    private String image;
    public User(String username,String password,String email,String phone){
        this.id=new Jid();
        this.username=username;
        this.password=password;
        this.email=email;
        this.phone=phone;
    }



}
