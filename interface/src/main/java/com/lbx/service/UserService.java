package com.lbx.service;

import com.lbx.domain.TUser;
import com.lbx.utils.PageBean;

/**
 * @Author:
 * @date 2018/4/3 15:26
 */
public interface UserService {


    Integer insert(TUser user, String[] roleIds);

    PageBean findAll(PageBean pageBean);

    Integer delete(String id);
}
