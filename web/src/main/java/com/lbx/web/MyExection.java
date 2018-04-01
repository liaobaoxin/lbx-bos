package com.lbx.web;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Create by lbx on 2018/4/1  9:01
 **/
public class MyExection implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView modelAndView=new ModelAndView();
        if(ex instanceof UnauthorizedException){
            System.out.println("没有权限");

            modelAndView.setViewName("/unauthorized");
           return modelAndView;
        }
        modelAndView.setViewName("/error");
        return modelAndView;
    }


}
