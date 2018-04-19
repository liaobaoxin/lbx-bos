package com.lbx.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author:
 * @date 2018/4/8 11:30
 */
@RequestMapping("/page/portal")
@Controller
public class pageController {


    @RequestMapping("/workTable")
    public String workTable() {
        return "common/home";
    }


    @RequestMapping("/bug")
    public String bug() {
        return "portal/bug";
    }

    @RequestMapping("/gonggao")
    public String gonggao() {
        return "portal/gonggao";
    }

     @RequestMapping("/daiban")
    public String daiban(){
        return "portal/daiban";
    }

    @RequestMapping("/yujing")
    public String yujing(){
        return "portal/yujing";
    }

    @RequestMapping("/noticebillAdd")
    public String noticebillAdd(){
        return "qupai/noticebill_add";
    }
}
