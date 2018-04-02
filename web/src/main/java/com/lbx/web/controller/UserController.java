package com.lbx.web.controller;

import com.lbx.domain.TUser;
import com.lbx.utils.PageBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Create by lbx on 2018/4/2  21:53
 **/
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/page")
    public String page(){
        return "admin/userlist";
    }

    @RequestMapping("/list")
    @ResponseBody
    public String list(PageBean pageBean){

        return "admin/userindex";
    }

    @RequestMapping("/addPage")
    public String addPage(TUser user,String[] roleIds ){
        return "admin/userinfo";
    }
}
