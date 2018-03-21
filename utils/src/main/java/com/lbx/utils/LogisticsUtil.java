package com.lbx.utils;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @Author: lbx
 * @date 2018/3/21 8:31
 */
public class LogisticsUtil {

    /**
     * 通过订单号查找快递公司
     *
     * @param orderNum
     * @return
     */
    private static String findComCodeByOrderNum(String orderNum) {
        //获取快递公司的comCode
        String autoCom = "http://www.kuaidi100.com/autonumber/autoComNum?resultv2=1&text=" + orderNum + "&temp=" + new Random().nextDouble() + "";
        AutoComJson autoComJson = JSON.parseObject(HttpClientUtil.httpGetRequest(autoCom), AutoComJson.class);
        List<AutoComJson.AutoBean> auto = autoComJson.getAuto();
        if (auto != null && auto.size() != 0) {
            String comCode = auto.get(0).getComCode();
            return comCode;
        }
        return null;
    }


    /**
     * 根据订单号查询物流信息和message
     */
    public static Map<String, Object> expressInforByOrderNum(String orderNum) {
        String comCode = findComCodeByOrderNum(orderNum);
        String url = "http://www.kuaidi100.com/query?type=" + comCode +
                "&postid=" + orderNum + "&temp=" + new Random().nextDouble() + "";
        String s = HttpClientUtil.httpGetRequest(url);
        ExpressJson expressJson = JSON.parseObject(s, ExpressJson.class);
        List<ExpressJson.DataEntity> tracking = expressJson.getData();
        String message = expressJson.getMessage();
        Map<String, Object> map = new HashMap<>();
        map.put("message", message);
        map.put("tracking", tracking);
        return map;
    }
}
