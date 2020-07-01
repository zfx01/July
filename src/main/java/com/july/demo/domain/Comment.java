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

public class Comment {
    @EmbeddedId
    Jid id;
    String expect;
    String info;
    Date time;
    String projectid;
    String vote;
}
