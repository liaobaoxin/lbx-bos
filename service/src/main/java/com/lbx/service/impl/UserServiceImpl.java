package com.lbx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lbx.domain.TUser;
import com.lbx.domain.TUserExample;
import com.lbx.domain.UserRoleExample;
import com.lbx.domain.UserRoleKey;
import com.lbx.mapper.TUserMapper;
import com.lbx.mapper.UserRoleMapper;
import com.lbx.service.UserService;
import com.lbx.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:
 * @date 2018/4/3 15:28
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    TUserMapper userMapper;

    @Autowired
    UserRoleMapper userRoleMapper;

    /*UserRoleExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(user.getId());
        userRoleMapper.deleteByExample(example);*/

    @Override
    public Integer insert(TUser user, String[] roleIds) {
        int r = userMapper.insert(user);
        if (roleIds != null) {
            for (String roleId : roleIds) {
                UserRoleKey userRole = new UserRoleKey(user.getId(), roleId);
                userRoleMapper.insert(userRole);
            }
        }
        return r;
    }

    @Override
    public PageBean findAll(PageBean pageBean) {
        PageHelper.offsetPage(pageBean.getPage(), pageBean.getRows());
        TUserExample example = new TUserExample();
        List<TUser> userList = userMapper.selectByExample(example);


        for (TUser user : userList) {
            List<String> roleName = userRoleMapper.findRolesByUserId(user.getId());
            user.setRoleNames(roleName.size()==0?null:roleName.toString());
        }

        PageInfo<TUser> pageInfo = new PageInfo<>(userList);


        pageBean.setTotal(pageInfo.getTotal());
        pageBean.setRowList(userList);
        return pageBean;
    }

    @Override
    public Integer delete(String id) {
        UserRoleExample example=new UserRoleExample();
        UserRoleExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(id);
        userRoleMapper.deleteByExample(example);

        int r = userMapper.deleteByPrimaryKey(id);

        return r;
    }
}
