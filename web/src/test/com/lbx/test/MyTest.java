package com.lbx.test;

import com.lbx.domain.BaseOrder;
import com.lbx.domain.BaseOrderExample;
import com.lbx.mapper.BaseOrderMapper;
import com.lbx.service.QuickService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Author: lbx
 * @date 2018/3/21 16:59
 */
@RunWith(SpringJUnit4ClassRunner.class) // 使用junit4进行测试
@ContextConfiguration(locations = "classpath:spring/spring-*.xml")//加载配置文件
public class MyTest {

    @Autowired
    BaseOrderMapper baseOrderMapper;

    @Test
    public void fun1() {
        List<String> stringList = baseOrderMapper.getDifferentYear();
        System.out.println(stringList);
    }

    @Test
    public void fun2() {
        List<String> stringList = baseOrderMapper.getMonthByYear("2018");
        System.out.println(stringList);
    }

    @Test
    public void fun3() {
        List<String> dayByYearAndMonth = baseOrderMapper.getDayByYearAndMonth("2018-03");
        System.out.println(dayByYearAndMonth);
    }

    @Test
    public void fun4() {
        List<BaseOrder> baseOrderList = baseOrderMapper.getBaseOrderByYearAndMonthAndDay("2018-03-22");
        System.out.println(baseOrderList);
    }
}
