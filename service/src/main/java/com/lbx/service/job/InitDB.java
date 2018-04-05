package com.lbx.service.job;

import com.lbx.mapper.sysMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Create by lbx on 2018/4/5  15:30
 **/
public class InitDB extends SqlSessionDaoSupport {

    @Autowired
    sysMapper sysMapper;

    /**
     * 初始化DB
     */
    public void run(){
//        super.getSqlSession().insert("INSERT INTO t_user (id,username,PASSWORD) VALUES(2,'test','test')");
        sysMapper.insert11();
    }
}
