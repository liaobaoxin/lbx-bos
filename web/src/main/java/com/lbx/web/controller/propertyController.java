package com.lbx.web.controller;

import com.lbx.domain.BProperty;
import com.lbx.service.BpropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Create by lbx on 2018/4/8  20:07
 **/
@Controller
@RequestMapping("/property")
public class propertyController {


    @Autowired
    BpropertyService propertyService;

    @RequestMapping("/page")
    public String page() {
        return "financia/property";
    }


    @RequestMapping("/list")
    @ResponseBody
    public List<BProperty> list() {
        List<BProperty> propertyList = propertyService.findAll();
        return propertyList;
    }

    @RequestMapping("/addPage")
    public String addPage() {
        return "financia/property_add";
    }

    @RequestMapping("/add")
    public String add(BProperty bProperty) {
        Integer r=propertyService.insert(bProperty);
        return "financia/property";
    }


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        //true:允许输入空值，false:不能为空值
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

}
