package com.july.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
public class Expert {
    @EmbeddedId
    Jid id;
    String username;
    String password;
    String group;
    String tel;
    String sex;

}
