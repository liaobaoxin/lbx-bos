package com.lbx.web.controller;

import com.github.pagehelper.StringUtil;
import com.lbx.domain.AuthFunction;
import com.lbx.domain.AuthFunctionExample;
import com.lbx.domain.TUser;
import com.lbx.service.AuthManageService;
import com.lbx.utils.ZtreeJson;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedList;
import java.util.List;

/**
 * Create by lbx on 2018/3/11  17:44
 **/
@Controller
public class IndexController {

    @Autowired
    AuthManageService authManageService;

    @RequestMapping("/index")
    public String index() {
        return "common/index";
    }

    @RequestMapping("/user/menu")
    @ResponseBody
    public List<ZtreeJson> menu() {
        TUser user = (TUser) SecurityUtils.getSubject().getPrincipal();
        List<AuthFunction> authFunctionList ;
        List<ZtreeJson> ztreeJsonList=new LinkedList<>();
        if (user.getUsername().equals("admin")) {
            //查找全部菜单
            AuthFunctionExample example=new AuthFunctionExample();
            example.setOrderByClause(" zindex ASC");
            example.setDistinct(true);
            AuthFunctionExample.Criteria criteria = example.createCriteria();
            criteria.andGeneratemenuEqualTo(true);
            authFunctionList = authManageService.findAll(example);
        } else {
            //根据用户ID查找菜单
            authFunctionList = authManageService.findMenuByUserId(user.getId());
        }
        for (AuthFunction authFunction : authFunctionList) {
            ZtreeJson ztreeJson = new ZtreeJson();
            ztreeJson.setName(authFunction.getName());
            ztreeJson.setId(authFunction.getId());
            if (StringUtil.isNotEmpty(authFunction.getPid())) {
                ztreeJson.setpId(authFunction.getPid());
                ztreeJson.setPage(authFunction.getPage());
            }
            ztreeJsonList.add(ztreeJson);
        }
        return ztreeJsonList;
    }





}
