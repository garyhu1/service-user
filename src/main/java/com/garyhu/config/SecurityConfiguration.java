package com.garyhu.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author: garyhu
 * @since: 2018/11/13 0013
 * @decription: 自定义的配置文件，从配置文件中读取
 */
@ConfigurationProperties(prefix = "imooc.security")
public class SecurityConfiguration {


}
