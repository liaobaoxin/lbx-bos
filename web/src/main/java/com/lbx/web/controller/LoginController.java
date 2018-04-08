package com.lbx.web.controller;

import com.github.pagehelper.StringUtil;
import com.lbx.domain.TUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Create by lbx on 2018/3/31  19:48
 **/
@Controller
public class LoginController {

    private org.slf4j.Logger logger = LoggerFactory.getLogger(LoginController.class);


    @RequestMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response, String name, String password) {
        if (StringUtil.isNotEmpty(name) && StringUtil.isNotEmpty(password)) {
            //使用shiro框架提供的方式进行认证
            Subject subject = SecurityUtils.getSubject();//获取当前登陆用户对象，现在状态是"未认证"
            //用户密码令牌
            AuthenticationToken token = new UsernamePasswordToken(name, password);
            try {
                subject.login(token);
                TUser user = (TUser) subject.getPrincipal();
                request.getSession().setAttribute("user", user);
                request.setAttribute("user", user);
                return "/common/index";
            } catch (Exception ex) {
                ex.printStackTrace();
                return "redirect/login.jsp";
            }
        }
        return "redirect/login.jsp";
    }

    @RequestMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Subject subject = SecurityUtils.getSubject();
        TUser user = (TUser) subject.getPrincipal();
        if (subject.isAuthenticated()) {
            subject.logout(); // session 会销毁，在SessionListener监听session销毁，清理权限缓存
            if (logger.isDebugEnabled()) {
                logger.debug("用户" + user.getUsername() + "退出登录");
            }
        }
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }







}
