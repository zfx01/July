package com.july.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.util.Date;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity

public class Award {
    @EmbeddedId
    Jid id;
    String name;
    String detail;
    Date datefrom;
    Date dateto;
    String award;
    String belongto;
    String expertgroup;
}
