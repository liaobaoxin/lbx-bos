package com.lbx.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Create by lbx on 2018/3/11  20:48
 **/
@Controller
@RequestMapping("items")
public class ItemsController {
    @RequestMapping("list")
    public String list(){
        System.out.println("test");
        return null;
    }
}
