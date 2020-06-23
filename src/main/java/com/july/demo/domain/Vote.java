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
public class Vote {
    @EmbeddedId
    Jid id;
    String projectid;
    String socre;
    Date time;
}
