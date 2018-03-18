package com.lbx.web.controller;

import com.lbx.domain.BaseOrder;
import com.lbx.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Create by lbx on 2018/3/16  20:00
 **/
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    IOrderService orderService;

    @RequestMapping("/page")
    public String page(){
        return "base/order";
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<BaseOrder> list(){
        List<BaseOrder> orderList = orderService.findAll();
        return orderList;
    }
}
