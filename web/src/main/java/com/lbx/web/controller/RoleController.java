package com.lbx.web.controller;

import com.alibaba.fastjson.JSON;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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


    @RequestMapping(value = "/findAll", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<AuthRole> findAll() {
        List<AuthRole> list = roleService.findAll();
        return list;
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
    public String addRole(AuthRole authRole, String functionIds) {
        roleService.insert(authRole, functionIds);
        return "admin/role";
    }

    @RequestMapping("/editRolePage")
    public ModelAndView editRolePage(String id, ModelAndView modelAndView) {
        AuthRole role = roleService.findById(id);


        List<AuthFunction> authFunctionList = authManageService.findByRoleId(id);
        List<ZtreeJson> list = new LinkedList<>();
        for (AuthFunction AuthFunction : authFunctionList) {
            if (AuthFunction.getPid() != null) {
                list.add(new ZtreeJson(AuthFunction.getId(), AuthFunction.getPid(), AuthFunction.getName(), AuthFunction.getPid() == null ? "true" : "false"));
            }
        }

        modelAndView.setViewName("/admin/role_edit");
        modelAndView.addObject("role", role);
        modelAndView.addObject("checkJson", JSON.toJSONString(list));

        return modelAndView;
    }

    @RequestMapping("/editRole")
    public String editRole(AuthRole authRole, String functionIds) {
        roleService.update(authRole, functionIds);
        return "admin/role";
    }

    @RequestMapping("/deleteRole")
    public String deleteRole(String id) {
        roleService.delete(id);
        return "admin/role";
    }


}
