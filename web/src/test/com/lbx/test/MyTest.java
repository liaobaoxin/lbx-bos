package com.lbx.test;

import com.lbx.domain.BaseOrder;
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
    public void  fun1(){
        BaseOrder baseOrder = baseOrderMapper.selectByPrimaryKey(33);
        System.out.println(baseOrder);
    }
}
