package com.lbx.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author:
 * @date 2018/4/2 14:37
 */
@Controller
@RequestMapping("/roleManage")
public class RoleController {



    @RequestMapping("/page")
    public String page(){
        return "admin/role";
    }

    @RequestMapping("/addPage")
    public String add(){
        return "admin/role_add";
    }


}
