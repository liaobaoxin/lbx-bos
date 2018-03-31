package com.lbx.service.realm;

import com.lbx.domain.TUser;
import com.lbx.domain.TUserExample;
import com.lbx.mapper.TUserMapper;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Create by lbx on 2018/3/31  11:07
 **/
public class BosRealm extends AuthorizingRealm {
    @Autowired
    private TUserMapper userMapper;

    //认证方法
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("自定义的realm中认证方法执行了。。。。");
        UsernamePasswordToken passwordToken = (UsernamePasswordToken)token;
        //获得页面输入的用户名
        String username = passwordToken.getUsername();
        //根据用户名查询数据库中的密码
        TUserExample example = new TUserExample();
        TUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<TUser> users = userMapper.selectByExample(example);
        if(users == null||users.size()==0){
            //页面输入的用户名不存在
            return null;
        }
        TUser user = users.get(0);
        //简单认证信息对象
        AuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), this.getName());
        //框架负责比对数据库中的密码和页面输入的密码是否一致
        return info;
    }

    //授权方法
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }
}
