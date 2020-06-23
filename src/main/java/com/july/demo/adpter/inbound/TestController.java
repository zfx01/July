package com.july.demo.adpter.inbound;

import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin("*")
@RequestMapping("test")
public class TestController {

    @GetMapping("hello")
    public String test(@RequestParam String name,@RequestParam String pass){
        return "hello"+name+pass;
    }

    @RequestMapping("/test")
    public String test2(){
        return "index";
    }
}
