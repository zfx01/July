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
public class Declaration {
    @EmbeddedId
    Jid id;
    String projectid;
    String awardid;
    String reason;
    String accessory;
}
