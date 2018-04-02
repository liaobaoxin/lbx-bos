package com.lbx.service;

import com.lbx.domain.AuthFunction;
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

    Integer delete(String id);
}
