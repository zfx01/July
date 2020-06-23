package com.july.demo.application.port.outbound;

import com.july.demo.domain.Accessory;
import com.july.demo.domain.Jid;
import com.july.demo.domain.User;
import com.july.demo.domain.Vote;

import java.util.List;

public interface AccessoryRepository {


    String add(Accessory accessory);

    String deletebyid(Jid id);

    String updatebyid(Jid id, Accessory accessory);

    Accessory findbyid(Jid id);

    List<Accessory> findall();
}
