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
    @OneToOne
    Member member;

}
