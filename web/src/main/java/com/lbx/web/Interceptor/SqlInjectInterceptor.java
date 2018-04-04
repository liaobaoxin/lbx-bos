package com.lbx.web.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * @Author:
 * @date 2018/3/30 17:42
 */
public class SqlInjectInterceptor implements HandlerInterceptor {


    /**
     * 处理字符转义 * * @param value * @return
     */
    private String clearXss(String value) {
        if (value == null || "".equals(value)) {
            return value;
        }
        value = value.replaceAll("<", "<").replaceAll(">", ">");
        value = value.replaceAll("\\(", "(").replace("\\)", ")");
        value = value.replaceAll("'", "'");
        value = value.replaceAll("eval\\((.*)\\)", "");
        value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");
        value = value.replace("script", "");
        return value;
    }




    @Override

    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {

            Enumeration<String> names = arg0.getParameterNames();
            while (names.hasMoreElements()) {
                String name = names.nextElement();
                String[] values = arg0.getParameterValues(name);
                for (String value : values) {
                    if (judgeXSS(value.toLowerCase())) {
                        System.out.println("非法字符");
                        arg1.setContentType("text/html;charset=UTF-8");
                        arg1.getWriter().print("参数含有非法攻击字符,已禁止继续访问！");
                        return false;
                    }
                }
            }


        return true;
    }

    /**
     * 判断参数是否含有攻击串
     *
     * @param value
     * @return
     */
    public boolean judgeXSS(String value) {
        if (value == null || "".equals(value)) {
            return false;
        }
        String xssStr = "and|or|select|update|delete|drop|script|eval|truncate|%20|=|;|'|%|#|+|\\|!=|(|)";
        String[] xssArr = xssStr.split("\\|");
        for (int i = 0; i < xssArr.length; i++) {
            if (value.indexOf(xssArr[i]) > -1) {
                return true;
            }
        }
        return false;

    }
}
