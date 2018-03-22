package com.lbx.web.controller;

import com.lbx.domain.BaseOrder;
import com.lbx.service.QuickService;
import com.lbx.utils.ZtreeJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: lbx
 * @date 2018/3/22 10:09
 */
@Controller
@RequestMapping("/zTree")
public class ZtreeController {

    @Autowired
    QuickService quickService;

    @RequestMapping("/page")
    public String page() {
        return "qupai/zTree";
    }

    @RequestMapping("/allNodes")
    @ResponseBody
    public List<ZtreeJson> getAllNodes() {
        List<String> differentYear = quickService.getDifferentYear();
        List<ZtreeJson> list = new LinkedList<>();
        for (String year : differentYear) {
            ZtreeJson json = new ZtreeJson(year, year+"年", "true");
            list.add(json);
        }
        Collections.sort(list);

        return list;
    }

    @RequestMapping("/loadTree")
    @ResponseBody
    public LinkedList<ZtreeJson> getloadTree(String id) {
        if (id.matches("^2[0-9]{3}$")) {
            List<String> months = quickService.getMonthByYear(id);
            LinkedList<ZtreeJson> list = new LinkedList<>();
            for (String month : months) {
                ZtreeJson json = new ZtreeJson(id + "-" + month, id, month+"月", "true");
                list.add(json);
            }
            return list;
        } else if (id.matches("^2[0-9]{3}-[0-9]{2}$")) {
            List<String> days = quickService.getDayByYearAndMonth(id);
            LinkedList<ZtreeJson> list = new LinkedList<>();
            for (String day : days) {
                ZtreeJson json = new ZtreeJson(id + "-" + day, id, day, "true");
                list.add(json);
            }
            return list;
        }else if (id.matches("^2[0-9]{3}-[0-9]{2}-[0-9]{2}$")) {
            List<BaseOrder> baseOrderList = quickService.getBaseOrderByYearAndMonthAndDay(id);
            LinkedList<ZtreeJson> list = new LinkedList<>();
            for (BaseOrder baseOrder : baseOrderList) {
                ZtreeJson json = new ZtreeJson(baseOrder.getId()+"",baseOrder.getName(),"false");
                list.add(json);
            }
            return list;
        }
        return null;
    }


}
