package com.lbx.service;

import com.lbx.domain.BProperty;

import java.util.List;

/**
 * Create by lbx on 2018/4/10  18:21
 **/
public interface BpropertyService {
    List<BProperty> findAll();

    Integer insert(BProperty bProperty);
}
