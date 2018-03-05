package com.lbx.mapper;

import com.lbx.domain.Orderitems;
import com.lbx.domain.OrderitemsExample;
import com.lbx.domain.OrderitemsKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface OrderitemsMapper {
    int countByExample(OrderitemsExample example);

    int deleteByExample(OrderitemsExample example);

    int deleteByPrimaryKey(OrderitemsKey key);

    int insert(Orderitems record);

    int insertSelective(Orderitems record);

    List<Orderitems> selectByExample(OrderitemsExample example);

    Orderitems selectByPrimaryKey(OrderitemsKey key);

    int updateByExampleSelective(@Param("record") Orderitems record, @Param("example") OrderitemsExample example);

    int updateByExample(@Param("record") Orderitems record, @Param("example") OrderitemsExample example);

    int updateByPrimaryKeySelective(Orderitems record);

    int updateByPrimaryKey(Orderitems record);
}