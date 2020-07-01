package com.july.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="project")
public class Projects {
    @EmbeddedId
    Jid id;
    String name;
    String ower;
    String detail;
    String belongto;
    String accessoryid;
    String isnew;
    String isfinish;
    String otherdetail;
    String img;
    String member1,member2,member3,member4;
    String status;

}
