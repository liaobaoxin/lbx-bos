package com.lbx.web.controller;

import com.lbx.domain.AuthFunction;
import com.lbx.service.AuthManageService;
import com.lbx.utils.PageBean;
import com.lbx.utils.ResultData;
import com.lbx.utils.SuperFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;

/**
 * Create by lbx on 2018/4/1  11:19
 **/
@Controller
@RequestMapping("/authManage")
public class AuthManageController {

    @Autowired
    AuthManageService authManageService;

    @RequestMapping("/page")
    public String page() {
        return "admin/function";
    }

    @RequestMapping("/addPage")
    public String addPage() {
        return "admin/function_add";
    }

    /**
     * 查找父功能点
     */
    @RequestMapping("/superFunction")
    @ResponseBody
    public List<SuperFunction> superFunction(HttpServletRequest request) {

        List<SuperFunction> superFunctionList = new LinkedList<>();
        List<AuthFunction> list = authManageService.findAllPIdIsNull();
        for (AuthFunction authFunction : list) {
            //查找出父结点的信息
            SuperFunction Persionfunction = new SuperFunction();
            Persionfunction.setId(authFunction.getId());
            Persionfunction.setText(authFunction.getName());

            //根据父结点的Id查找子结点
            List<SuperFunction> function = new LinkedList<>();
            String pid = authFunction.getId();
            List<AuthFunction> functions = authManageService.findAllByPId(pid);
            for (AuthFunction authFunction1 : functions) {
                SuperFunction functionSon = new SuperFunction();
                functionSon.setId(authFunction1.getId());
                functionSon.setText(authFunction1.getName());
                function.add(functionSon);
            }
            Persionfunction.setChildren(function);
            superFunctionList.add(Persionfunction);
        }

        return superFunctionList;

    }

    @RequestMapping("/add")
    public String add(AuthFunction authFunction) {
        authManageService.insert(authFunction);
        return "admin/function";
    }


    @RequestMapping("/list")
    @ResponseBody
    public ResultData list(PageBean pageBean) {
        authManageService.findAll(pageBean);
        return ResultData.pageData(pageBean.getTotal(), pageBean.getRowList());
    }

    @RequestMapping("/delete")
    @ResponseBody
    public ResultData delete(String id) {
        Integer r=authManageService.delete(id);
        return ResultData.ok();
    }


}
