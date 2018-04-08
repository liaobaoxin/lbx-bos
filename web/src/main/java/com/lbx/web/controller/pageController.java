package com.lbx.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author:
 * @date 2018/4/8 11:30
 */
@RequestMapping("/page")
@Controller
public class pageController {


    @RequestMapping("/workTable")
    public String workTable(){
        return "common/home";
    }
}
