package com.lbx.web.controller;

import com.lbx.domain.Property;
import com.lbx.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Create by lbx on 2018/4/8  20:07
 **/
@Controller
@RequestMapping("/property")
public class propertyController {


    @Autowired
    PropertyService propertyService;

    @RequestMapping("/page")
    public String page() {
        return "financia/property";
    }


    @RequestMapping("/list")
    @ResponseBody
    public List<Property> list() {
        List<Property> propertyList = propertyService.findAll();
        return propertyList;
    }

    @RequestMapping("/addPage")
    public String addPage() {
        return "financia/property_add";
    }

}
