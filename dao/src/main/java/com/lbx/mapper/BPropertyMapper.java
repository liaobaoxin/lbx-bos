package com.lbx.mapper;

import com.lbx.domain.BProperty;
import com.lbx.domain.BPropertyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BPropertyMapper {
    int countByExample(BPropertyExample example);

    int deleteByExample(BPropertyExample example);

    int deleteByPrimaryKey(String name);

    int insert(BProperty record);

    int insertSelective(BProperty record);

    List<BProperty> selectByExample(BPropertyExample example);

    BProperty selectByPrimaryKey(String name);

    int updateByExampleSelective(@Param("record") BProperty record, @Param("example") BPropertyExample example);

    int updateByExample(@Param("record") BProperty record, @Param("example") BPropertyExample example);

    int updateByPrimaryKeySelective(BProperty record);

    int updateByPrimaryKey(BProperty record);
}