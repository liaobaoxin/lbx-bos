package com.lbx.mapper;

import com.lbx.domain.AuthFunction;
import com.lbx.domain.AuthFunctionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AuthFunctionMapper {
    int countByExample(AuthFunctionExample example);

    int deleteByExample(AuthFunctionExample example);

    int deleteByPrimaryKey(String id);

    int insert(AuthFunction record);

    int insertSelective(AuthFunction record);

    List<AuthFunction> selectByExample(AuthFunctionExample example);

    AuthFunction selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AuthFunction record, @Param("example") AuthFunctionExample example);

    int updateByExample(@Param("record") AuthFunction record, @Param("example") AuthFunctionExample example);

    int updateByPrimaryKeySelective(AuthFunction record);

    int updateByPrimaryKey(AuthFunction record);
}