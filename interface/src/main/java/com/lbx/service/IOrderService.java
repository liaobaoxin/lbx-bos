package com.lbx.service;

import com.lbx.domain.BaseOrder;

import java.util.List;

/**
 * Create by lbx on 2018/3/16  20:16
 **/
public interface IOrderService {
    List<BaseOrder> findAll();
}
