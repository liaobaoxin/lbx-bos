package com.lbx.service.impl;

import com.lbx.domain.Orderitems;
import com.lbx.domain.OrderitemsExample;
import com.lbx.mapper.OrderitemsMapper;
import com.lbx.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: lbx
 * @date 2018/3/2 9:56
 */
@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    OrderitemsMapper orderitemsMapper;

    @Override
    public Orderitems findAll() {
        OrderitemsExample example = new OrderitemsExample();
        List<Orderitems> orderitems = orderitemsMapper.selectByExample(example);
        return orderitems.get(0);
    }
}
