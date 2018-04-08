package com.lbx.service;

import com.lbx.domain.AuthFunction;
import com.lbx.domain.AuthFunctionExample;
import com.lbx.utils.PageBean;

import java.util.List;

/**
 * Create by lbx on 2018/4/1  13:29
 **/
public interface AuthManageService {
    List<AuthFunction> findAllPIdIsNull();

    List<AuthFunction> findAllByPId(String pId);

    Integer insert(AuthFunction authFunction);

    PageBean findAll(PageBean pageBean);

    List<AuthFunction> findAll();

    List<AuthFunction> findAll(AuthFunctionExample example);

    Integer delete(String id);

    List<AuthFunction> findByRoleId(String roleId);

    List<String> findFlagByUserId(String userId);

    List<String> findAllFlag();

    List<AuthFunction> findMenuByUserId(String userId);

    /**
     * 根据ID查找是否有子类
     */
    int findById(String id);
}
