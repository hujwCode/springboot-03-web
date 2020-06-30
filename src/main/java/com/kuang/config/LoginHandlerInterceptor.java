package com.kuang.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author : hujiawei
 * @version : 1.0.0
 * @date : 2020/6/22 8:48 下午
 */
@Configuration
public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginUser = request.getSession().getAttribute("loginUser");
        if (loginUser == null){
            request.setAttribute("msg","没权限，先登录！");
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }
        return true;
    }


}
