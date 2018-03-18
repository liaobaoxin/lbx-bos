package com.lbx.service.impl;


import com.lbx.domain.BaseOrder;
import com.lbx.domain.BaseOrderExample;
import com.lbx.mapper.BaseOrderMapper;
import com.lbx.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create by lbx on 2018/3/16  20:21
 **/
@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    BaseOrderMapper baseOrderMapper;
    @Override
    public List<BaseOrder> findAll() {
        BaseOrderExample example = new BaseOrderExample();
        List<BaseOrder> orderList = baseOrderMapper.selectByExample(example);
        return orderList;
    }
}
