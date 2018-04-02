package com.lbx.service;

import com.lbx.domain.AuthRole;
import com.lbx.utils.PageBean;

import java.util.List;

/**
 * Create by lbx on 2018/4/2  19:12
 **/
public interface RoleService {
    List<AuthRole> findAll(PageBean pageBean);

    Integer insert(AuthRole authRole,String functionIds);
}