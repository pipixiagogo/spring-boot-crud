package com.zh.springboot.web.springbootcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;


/**
 * @Auther: Administrator
 * @Date: 2018/11/14 08:52
 * @Description:
 */
@Controller
public class LoginController {

    @PostMapping(value = {"/user/login"})
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpServletRequest request){
        System.out.println(username+password);
        if(!StringUtils.isEmpty(username) && "123".equals(password)){
            request.getSession().setAttribute("username",username);
            System.out.println(request.getSession().getAttribute("username"));
            return "redirect:/main.html";
        }

        request.setAttribute("msg","用户名/密码错误");
        return "Login";
    }
}
