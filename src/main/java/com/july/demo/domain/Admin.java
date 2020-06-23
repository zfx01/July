package com.july.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity

public class Admin {
    @EmbeddedId
    Jid id;
    String username;
    String password;
    String rights;
}
