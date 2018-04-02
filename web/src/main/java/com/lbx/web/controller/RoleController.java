package com.lbx.web.controller;

import com.lbx.domain.AuthFunction;
import com.lbx.domain.AuthRole;
import com.lbx.service.AuthManageService;
import com.lbx.service.RoleService;
import com.lbx.utils.PageBean;
import com.lbx.utils.ResultData;
import com.lbx.utils.ZtreeJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author:
 * @date 2018/4/2 14:37
 */
@Controller
@RequestMapping("/roleManage")
public class RoleController {

    @Autowired
    RoleService roleService;

    @Autowired
    AuthManageService authManageService;


    @RequestMapping("/page")
    public String page() {
        return "admin/role";
    }

    @RequestMapping("/addPage")
    public String add() {
        return "admin/role_add";
    }

    @RequestMapping("/list")
    @ResponseBody
    public ResultData list(PageBean pageBean) {
        roleService.findAll(pageBean);
        return ResultData.pageData(pageBean.getTotal(), pageBean.getRowList());
    }

    @RequestMapping("/auth")
    @ResponseBody
    public List<ZtreeJson> auth() {
        List<AuthFunction> functionList = authManageService.findAll();
        List<ZtreeJson> list = new LinkedList<>();
        for (AuthFunction AuthFunction : functionList) {
            list.add(new ZtreeJson(AuthFunction.getId(), AuthFunction.getPid(), AuthFunction.getName(), AuthFunction.getPid() == null ? "true" : "false"));
        }
        return list;
    }

    @RequestMapping("/addRole")
    public String addRole(AuthRole authRole,String functionIds) {
        roleService.insert(authRole,functionIds);
        return "admin/role";
    }


}
