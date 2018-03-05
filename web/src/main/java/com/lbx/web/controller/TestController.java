package com.lbx.web.controller;

import com.lbx.domain.Orderitems;
import com.lbx.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: lbx
 * @date 2018/3/2 9:46
 */
@Controller
public class TestController {

    @Autowired
    IOrderService orderService;

    @RequestMapping("/test")
    @ResponseBody
    public Orderitems test(){
        Orderitems all = orderService.findAll();
        System.out.println(all);
        return all;
    }

}
