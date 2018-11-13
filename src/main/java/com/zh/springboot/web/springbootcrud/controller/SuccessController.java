package com.zh.springboot.web.springbootcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: Administrator
 * @Date: 2018/11/11 15:02
 * @Description:
 */
@Controller
public class SuccessController {

    @RequestMapping("/success")
    public String success(){
        return "success";
    }
}
