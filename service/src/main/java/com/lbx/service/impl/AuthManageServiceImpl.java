package com.lbx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lbx.domain.AuthFunction;
import com.lbx.domain.AuthFunctionExample;
import com.lbx.mapper.AuthFunctionMapper;
import com.lbx.service.AuthManageService;
import com.lbx.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create by lbx on 2018/4/1  13:38
 **/
@Service
public class AuthManageServiceImpl implements AuthManageService {

    @Autowired
    AuthFunctionMapper authFunctionMapper;

    @Override
    public List<AuthFunction> findAllPIdIsNull() {
        AuthFunctionExample example = new AuthFunctionExample();
        AuthFunctionExample.Criteria criteria = example.createCriteria();
        criteria.andPidIsNull();
        return authFunctionMapper.selectByExample(example);
    }

    @Override
    public List<AuthFunction> findAllByPId(String pId) {
        AuthFunctionExample example = new AuthFunctionExample();
        AuthFunctionExample.Criteria criteria = example.createCriteria();
        criteria.andPidEqualTo(pId);
        criteria.andGeneratemenuEqualTo(true);
        return authFunctionMapper.selectByExample(example);
    }

    @Override
    public Integer insert(AuthFunction authFunction) {
        return authFunctionMapper.insert(authFunction);
    }

    @Override
    public PageBean findAll(PageBean pageBean) {
        PageHelper.offsetPage(pageBean.getPage(),pageBean.getRows());

        AuthFunctionExample example = new AuthFunctionExample();
        List<AuthFunction> authFunctionList = authFunctionMapper.selectByExample(example);


        pageBean.setRowList(authFunctionList);
        PageInfo<AuthFunction> pageInfo = new PageInfo<>(authFunctionList);
        pageBean.setTotal(pageInfo.getTotal());

        return pageBean;
    }

    @Override
    public Integer delete(String id) {
        return  authFunctionMapper.deleteByPrimaryKey(id);

    }
}
