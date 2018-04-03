package com.lbx.web.controller;

import com.lbx.domain.TUser;
import com.lbx.service.UserService;
import com.lbx.utils.PageBean;
import com.lbx.utils.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Create by lbx on 2018/4/2  21:53
 **/
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/page")
    public String page(){
        return "admin/userlist";
    }

    @RequestMapping("/list")
    @ResponseBody
    public ResultData list(PageBean pageBean){
       userService.findAll(pageBean);
        return ResultData.pageData(pageBean.getTotal(),pageBean.getRowList());
    }

    @RequestMapping("/addPage")
    public String addPage(){
        return "admin/userinfo";
    }

    @RequestMapping("/addUser")
    public String addUser(TUser user,String[] roleIds ){
        Integer r=userService.insert(user,roleIds);
        return "admin/userinfo";
    }


    @RequestMapping("/deleteUser")
    public String deleteUser(String id){
        userService.delete(id);
        return "admin/userlist";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        //true:允许输入空值，false:不能为空值
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
