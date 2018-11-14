package com.garyhu.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author: garyhu
 * @since: 2018/11/13 0013
 * @decription: 用户服务类，添加用户
 */
@Component
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    private static final Logger LOGGER = LoggerFactory.getLogger(MyUserDetailsService.class);
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        LOGGER.info("用户名：{}",username);

        String password = passwordEncoder.encode("123456");
        LOGGER.info("用户密码：{}",password);
        // 参数描述：用户名、密码、权限
        User user = new User(username,password, AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
        return user;
    }
}
