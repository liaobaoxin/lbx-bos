package com.lbx.mapper;

import org.apache.ibatis.annotations.Insert;

/**
 * Create by lbx on 2018/4/5  16:05
 **/
public interface sysMapper {

    @Insert("INSERT INTO t_user (id,username,PASSWORD) VALUES(2,'test','test')")
    Integer insert11();
}
