package com.july.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
public class Member {
    @EmbeddedId
    Jid id;
    String member1;
    String member2;
    String member3;
    String member4;
    String leader;
    public Member(String m1,String m2,String m3,String m4,String leader){
        this.id=new Jid();
        this.member1=m1;
        this.member2=m2;
        this.member3=m3;
        this.member4=m4;
        this.leader=leader;
    }
}
