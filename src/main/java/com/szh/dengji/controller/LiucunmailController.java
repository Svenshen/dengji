/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * @autoor szh
 */

package com.szh.dengji.controller;

import com.szh.dengji.domain.DengjiUser;
import com.szh.dengji.domain.DengjiLiucunmail;
import com.szh.dengji.service.LiucunmailService;
import java.util.Date;
import java.util.List;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author  szh
 * QQ:873689
 * @date 2018-9-14 15:13:47
 */
@Controller
@RequestMapping(value = "/liucunhuandan")
public class LiucunmailController {

    private final String addhtml = "liucunhuandan-add";
    private final String chaxunhtml = "liucunhuandan-chaxun";
    
    @Autowired
    LiucunmailService liucunmailService;
    
    public void init(ModelAndView modelAndView){
        Subject subject = SecurityUtils.getSubject();
        DengjiUser user = (DengjiUser)subject.getPrincipal();
        modelAndView.addObject("user",user);
    }
    
    
    @GetMapping("/add")
    public ModelAndView add(ModelAndView modelAndView){
        init(modelAndView);
        modelAndView.setViewName(addhtml);
        return modelAndView;
    }   
    
    @PostMapping("/add")
    public ModelAndView add(ModelAndView modelAndView,DengjiLiucunmail liucunmail){
        init(modelAndView);
        Subject subject = SecurityUtils.getSubject();
        DengjiUser user = (DengjiUser)subject.getPrincipal();
        modelAndView.setViewName(addhtml);
        liucunmail.setBumen(user.getBumen());
        liucunmail.setName(user.getName());
        liucunmail.setShijian(new Date());
        try{
            liucunmailService.add(liucunmail);
        }catch(Exception e){
            modelAndView.addObject("msg", e.getMessage());
            modelAndView.addObject("mail", liucunmail);
            return modelAndView;
        }
        modelAndView.addObject("msg","保存成功");
        return modelAndView;
    } 
    
    @GetMapping("/chaxun")
    public ModelAndView chaxun(ModelAndView modelAndView){
        init(modelAndView);
        Subject subject = SecurityUtils.getSubject();
        DengjiUser user = (DengjiUser)subject.getPrincipal();
        modelAndView.setViewName(chaxunhtml);
        if(user.getQuanxian() > 10){
            List<DengjiLiucunmail> list = liucunmailService.findAll();
            modelAndView.addObject("maillist",list);
        }else{
            List<DengjiLiucunmail> list = liucunmailService.findByBumen(user.getBumen());
            modelAndView.addObject("maillist",list);
        }
        
        return modelAndView;
    } 
    
    
    
}
