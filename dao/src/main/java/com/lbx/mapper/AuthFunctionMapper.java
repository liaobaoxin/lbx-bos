package com.lbx.mapper;

import com.lbx.domain.AuthFunction;
import com.lbx.domain.AuthFunctionExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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

    /**
     * 根据角色Id查找权限
     */
    @Select("SELECT * FROM auth_function WHERE id IN (SELECT function_id FROM role_function WHERE role_id = #{roleId})")
    List<AuthFunction> findByRoleId(String roleId);

    /**
     * 根据用户id查找shiro标识
     */
    @Select("SELECT " +
            "  af.code " +
            "FROM" +
            "  t_user AS u " +
            "  INNER JOIN user_role AS ur " +
            "    ON u.id = ur.user_id " +
            "  INNER JOIN auth_role AS ar " +
            "    ON ur.role_id = ar.id " +
            "  INNER JOIN role_function AS rf " +
            "    ON ar.id=rf.role_id  " +
            "INNER JOIN auth_function AS af" +
            "    ON rf.function_id = af.id" +
            "  WHERE u.id=#{userId} ")
    List<String> findFlagByUserId(String userId);

    /**
     * 查找全部权限
     */
    @Select("SELECT " +
            "  af.code " +
            "FROM" +
            "  t_user AS u " +
            "  INNER JOIN user_role AS ur " +
            "    ON u.id = ur.user_id " +
            "  INNER JOIN auth_role AS ar " +
            "    ON ur.role_id = ar.id " +
            "  INNER JOIN role_function AS rf " +
            "    ON ar.id=rf.role_id  " +
            "  INNER JOIN auth_function AS af" +
            "    ON rf.function_id = af.id")
    List<String> findAllFlag();

    /**
     * 根据用户ID查找菜单
     */
    @Select("SELECT   " +
            "   af.id,af.pid,af.generatemenu,af.name " +
            "FROM  " +
            "  t_user AS u  " +
            "  INNER JOIN user_role AS ur  " +
            "    ON u.id = ur.user_id  " +
            "  INNER JOIN auth_role AS ar  " +
            "    ON ur.role_id = ar.id  " +
            "  INNER JOIN role_function AS rf  " +
            "    ON ar.id = rf.role_id  " +
            "  INNER JOIN auth_function AS af  " +
            "    ON rf.function_id = af.id  " +
            "    WHERE u.id=#{userId} AND af.generatemenu='1' ORDER BY af.zindex ASC")
    List<AuthFunction> findMenuByUserId(String userId);
}