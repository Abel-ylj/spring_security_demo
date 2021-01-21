package cn.ylj.service;

import cn.ylj.entity.UserEntity;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * SpringSecurity 用户认证回调接口
 * 回调loadUserByUsername(String name)方法，返回数据库中用户,
 * 返回的用户中密码若是明文，需要用{noop}前缀修饰，框架不会用密码编码器passwordEncoder来处理校验
 * 返回的用户对象User, 框架会按照配置的passwordEncoder中配置的算法来做校验
 * @author : yanglujian
 * create at:  2021/1/21  3:45 下午
 */

public class UserService implements UserDetailsService {

    @Resource
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //根据前端传过来的用户名，封装框架要的User对象，给框架，让它去校验密码
//        UserEntity user = this.findUserInDb(username);
        UserEntity user = this.findUserEncryptedInDb(username);
        if (user != null){
            if (user.getUsername().equals("admin")){
                return new User(username, user.getPassword(),
                        Lists.newArrayList(new SimpleGrantedAuthority("ROLE_ADMIN"),new SimpleGrantedAuthority("add")));
            }
            return new User(username,user.getPassword(), Lists.newArrayList(new SimpleGrantedAuthority("add")));
        }
        return null;
    }

    /**
     * 用密文密码让框架校验
     * @param username
     * @return
     */
    private UserEntity findUserEncryptedInDb(String username){
        HashMap<String, UserEntity> map = new HashMap<>();
        map.put("jack",new UserEntity("jack",bCryptPasswordEncoder.encode("123456")));
        map.put("rose",new UserEntity("rose", bCryptPasswordEncoder.encode("654321")));
        map.put("admin",new UserEntity("admin",bCryptPasswordEncoder.encode("qwerty")));
        return map.get(username);
    }

    /**
     * 让框架用明文密码校验{noop}前缀修饰
     * @param username
     * @return
     */
    private UserEntity findUserInDb(String username) {
        HashMap<String, UserEntity> map = new HashMap<>();
        map.put("jack",new UserEntity("jack","{noop}123456"));
        map.put("rose",new UserEntity("rose", "{noop}654321"));
        map.put("admin",new UserEntity("admin","{noop}qwerty"));
        return map.get(username);
    }
}