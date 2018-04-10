package com.lbx.service.impl;

import com.lbx.domain.BProperty;
import com.lbx.domain.BPropertyExample;
import com.lbx.mapper.BPropertyMapper;
import com.lbx.service.BpropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create by lbx on 2018/4/10  18:22
 **/
@Service
public class BpropertyServiceImpl implements BpropertyService {

    @Autowired
    BPropertyMapper bPropertyMapper;

    @Override
    public List<BProperty> findAll() {
        BPropertyExample example=new BPropertyExample();
        List<BProperty> propertyList = bPropertyMapper.selectByExample(example);
        return propertyList;
    }

    @Override
    public Integer insert(BProperty bProperty) {
        return bPropertyMapper.insert(bProperty);
    }
}
