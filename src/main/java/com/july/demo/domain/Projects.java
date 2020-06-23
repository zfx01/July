package com.july.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

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

}
