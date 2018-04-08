package com.lbx.service.impl;

import com.lbx.domain.Property;
import com.lbx.domain.PropertyExample;
import com.lbx.mapper.PropertyMapper;
import com.lbx.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create by lbx on 2018/4/8  20:14
 **/
@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    PropertyMapper propertyMapper;

    @Override
    public List<Property> findAll() {
        PropertyExample example = new PropertyExample();
        List<Property> list = propertyMapper.selectByExample(example);
        return list;
    }
}
