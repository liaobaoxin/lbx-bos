package com.lbx.utils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @Author: lbx
 * @date 2018/3/21 10:49
 */
public class log4jlistener implements ServletContextListener {
    public static final String log4jdirkey = "log4jdir";
    public void contextDestroyed(ServletContextEvent servletcontextevent) {
        System.getProperties().remove(log4jdirkey);
    }
    public void contextInitialized(ServletContextEvent servletcontextevent) {
        String log4jdir = servletcontextevent.getServletContext().getRealPath("/");
        //System.out.println("log4jdir:"+log4jdir);
        System.setProperty(log4jdirkey, log4jdir);
    }
}
