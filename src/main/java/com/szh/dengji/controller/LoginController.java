/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * @autoor szh
 */

package com.szh.dengji.controller;
import com.szh.dengji.domain.DengjiUser;
import com.szh.dengji.service.DengjiUserService;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author  szh
 * QQ:873689
 * @date 2018-9-6 14:20:03
 */
@Controller
public class LoginController {

    @Autowired
    DengjiUserService dengjiUserService;
    
    
    @RequestMapping(value = {"/index","/"})
    public ModelAndView index(ModelAndView modelAndView){
        Subject subject = SecurityUtils.getSubject();
        modelAndView.addObject("user",((DengjiUser)subject.getPrincipal()));
        modelAndView.setViewName("index");
        return modelAndView;
    }
    
    @GetMapping("/login")
    public ModelAndView login(ModelAndView modelAndView){
        Subject subject = SecurityUtils.getSubject();
        System.out.println("登录状态"+subject.isAuthenticated());
                
         if(subject.isAuthenticated()){
           modelAndView.setViewName("index");
        }else{
            modelAndView.setViewName("login");
         }
        return modelAndView;
    }
    
    @PostMapping(value = "/login")
    public ModelAndView login(DengjiUser dengjiUser ,ModelAndView modelAndView,HttpServletRequest request) throws Exception {
        

        String exception = (String) request.getAttribute("shiroLoginFailure");
        System.out.println(exception);
        String msg = "空";
        if(exception != null){
            if(UnknownAccountException.class.getName().equals(exception)){
                msg = "账号不存在";
            }else if(IncorrectCredentialsException.class.getName().equals(exception)){
                msg = "密码不正确";
            }else{
                msg = ""+exception;
            }
        }

        modelAndView.addObject("msg",msg);
        return modelAndView;
    }
}
