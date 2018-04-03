package com.lbx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.lbx.domain.*;
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

    @Override
    public Integer update(AuthRole authRole, String functionIds) {
        int r1 = authRoleMapper.updateByPrimaryKeySelective(authRole);

        RoleFunctionExample example = new RoleFunctionExample();
        RoleFunctionExample.Criteria criteria = example.createCriteria();
        criteria.andRoleIdEqualTo(authRole.getId());
        roleFunctionMapper.deleteByExample(example);



        int r3 = 0;
        if (StringUtil.isNotEmpty(functionIds)) {
            String[] ids = functionIds.split(",");
            for (String id : ids) {
                r3 = roleFunctionMapper.insert(new RoleFunctionKey(authRole.getId(), id));
                r3++;
            }
        }
        return r1 + r3;
    }

    @Override
    public Integer delete(String id) {
        RoleFunctionExample example = new RoleFunctionExample();
        RoleFunctionExample.Criteria criteria = example.createCriteria();
        criteria.andRoleIdEqualTo(id);
        roleFunctionMapper.deleteByExample(example);


        int r = authRoleMapper.deleteByPrimaryKey(id);

        return r;
    }
}
