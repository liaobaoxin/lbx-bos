package com.lbx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lbx.domain.AuthFunction;
import com.lbx.domain.AuthRole;
import com.lbx.domain.AuthRoleExample;
import com.lbx.domain.RoleFunctionKey;
import com.lbx.mapper.AuthRoleMapper;
import com.lbx.mapper.RoleFunctionMapper;
import com.lbx.service.RoleService;
import com.lbx.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create by lbx on 2018/4/2  19:12
 **/
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    AuthRoleMapper authRoleMapper;

    @Autowired
    RoleFunctionMapper roleFunctionMapper;

    @Override
    public List<AuthRole> findAll(PageBean pageBean) {
        PageHelper.offsetPage(pageBean.getPage(), pageBean.getRows());
        AuthRoleExample example = new AuthRoleExample();
        List<AuthRole> authRoleList = authRoleMapper.selectByExample(example);


        PageInfo<AuthRole> pageInfo = new PageInfo<>(authRoleList);


        pageBean.setTotal(pageInfo.getTotal());
        pageBean.setRowList(authRoleList);
        return authRoleList;
    }

    @Override
    public Integer insert(AuthRole authRole, String functionIds) {
        int r = authRoleMapper.insert(authRole);

        String[] ids = functionIds.split(",");
        for (String functionId : ids) {
            roleFunctionMapper.insert(new RoleFunctionKey(authRole.getId(), functionId));
        }


        return r;
    }

    @Override
    public List<AuthRole> findAll() {
        AuthRoleExample example = new AuthRoleExample();
        List<AuthRole> authRoleList = authRoleMapper.selectByExample(example);
        return authRoleList;
    }

    @Override
    public AuthRole findById(String id) {
        AuthRole authRole = authRoleMapper.selectByPrimaryKey(id);
        return authRole;
    }
}
