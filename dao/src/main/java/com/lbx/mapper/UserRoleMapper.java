package com.lbx.mapper;

import com.lbx.domain.UserRoleExample;
import com.lbx.domain.UserRoleKey;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserRoleMapper {
    int countByExample(UserRoleExample example);

    int deleteByExample(UserRoleExample example);

    int deleteByPrimaryKey(UserRoleKey key);

    int insert(UserRoleKey record);

    int insertSelective(UserRoleKey record);

    List<UserRoleKey> selectByExample(UserRoleExample example);

    int updateByExampleSelective(@Param("record") UserRoleKey record, @Param("example") UserRoleExample example);

    int updateByExample(@Param("record") UserRoleKey record, @Param("example") UserRoleExample example);

    /**
     * 根据userId查找对象的角色
     */
    @Select("SELECT name FROM auth_role WHERE id IN (SELECT role_id FROM user_role WHERE user_id =#{id})")
    List<String> findRolesByUserId(String id);
}