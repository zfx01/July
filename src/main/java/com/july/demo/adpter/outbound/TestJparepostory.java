package com.july.demo.adpter.outbound;

import com.july.demo.domain.Jid;
import com.july.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestJparepostory extends JpaRepository<User, Jid> {


}
