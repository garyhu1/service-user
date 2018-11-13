package com.garyhu.controller;

import com.garyhu.pojo.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: garyhu
 * @since: 2018/11/13 0013
 * @decription:
 */
@RestController
public class BrowserSecurityController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BrowserSecurityController.class);

    // 引发跳转请求缓存到这里,缓存原请求和恢复
    private RequestCache requestCache = new HttpSessionRequestCache();

    //用于重新定向
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @RequestMapping("/authentication/require")
    // 返回401状态码
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public BaseResponse requireAuthentication(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        LOGGER.info("引发跳转的请求是：{}",1);
        SavedRequest savedRequest = requestCache.getRequest(request, response);
        if(savedRequest != null){
            String redirectUrl = savedRequest.getRedirectUrl();
            LOGGER.info("引发跳转的请求是：{}",redirectUrl);
            if(StringUtils.endsWithIgnoreCase(redirectUrl,".html")){
                redirectStrategy.sendRedirect(request,response,"/login.html");
            }
        }

        return new BaseResponse("访问服务需要身份认证，请引导用户到登录界面");
    }


}
