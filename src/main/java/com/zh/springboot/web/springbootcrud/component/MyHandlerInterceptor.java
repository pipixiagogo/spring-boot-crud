package com.zh.springboot.web.springbootcrud.component;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: Administrator
 * @Date: 2018/11/14 09:19
 * @Description:
 */

public class MyHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Object username =request.getSession().getAttribute("username");
        if(username == null || username.toString().equals("")){
            request.setAttribute("msg","请先登录!");
            System.out.println("拦截了");
            request.getRequestDispatcher("/").forward(request,response);
            return false;
        }
        System.out.println("拦截了1111");
        return true;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {

    }
}
