package com.lbx.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Create by lbx on 2018/3/11  17:44
 **/
@Controller
public class IndexController {
    @RequestMapping("/index")
    public String index(){
        System.out.println("11");
        return "common/index";
    }
}
