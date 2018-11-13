package com.zh.springboot.web.springbootcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Administrator
 * @Date: 2018/11/12 10:27
 * @Description:
 */
@Controller
public class ReturnTest {

//    @RequestMapping("/model")
//    public ModelAndView model(){
//        ModelAndView mv = new ModelAndView("success");
//        mv.addObject("xx",123456);
//        System.out.println(mv.toString());
//        return mv;
//    }

    @RequestMapping("/string")
    public String st(Map<String,Object> map){
        map.put("hello","<h1>321<h1>");
        map.put("text", Arrays.asList("张三","李四","王五"));
        return "success";
    }
}
