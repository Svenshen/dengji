/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * @autoor szh
 */

package com.szh.dengji.controller;

import com.szh.dengji.domain.DengjiDaitoudian;
import com.szh.dengji.domain.DengjiDaitoudianmail;
import com.szh.dengji.domain.DengjiUser;
import com.szh.dengji.service.DaitoudianService;
import java.util.Date;
import java.util.List;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.szh.dengji.service.DaitoudianmailService;

/**
 *
 * @author  szh
 * QQ:873689
 * @date 2018-9-17 14:19:05
 */
@Controller
@RequestMapping(value = "/daitoudian")
public class DaitoudianController {

    private final String addhtml="daitoudian-add";
    private final String chaxunhtml="daitoudian-chaxun";
    private final String huizonghtml="daitoudian-huizong";
    
    
    @Autowired
    DaitoudianmailService daitoudianmailService;
    @Autowired
    DaitoudianService daitoudianService1;
    
    public void init(ModelAndView modelAndView){
        Subject subject = SecurityUtils.getSubject();
        DengjiUser user = (DengjiUser)subject.getPrincipal();
        modelAndView.addObject("user",user);
    }
    
    @GetMapping("/mail/add")
    public ModelAndView add(ModelAndView modelAndView){
        init(modelAndView);
        Subject subject = SecurityUtils.getSubject();
        DengjiUser user = (DengjiUser)subject.getPrincipal();
        modelAndView.setViewName(addhtml);
        List<DengjiDaitoudian> list = daitoudianService1.findByBumen(user.getBumen());
        modelAndView.addObject("daitoudianlist", list);
        
        return modelAndView;
    }
    @PostMapping("/mail/add")
    public ModelAndView add(ModelAndView modelAndView,@RequestParam("mailnos") String mailnos,@RequestParam("daitoudian") String daitoudianname){
        init(modelAndView);
        Subject subject = SecurityUtils.getSubject();
        DengjiUser user = (DengjiUser)subject.getPrincipal();
        modelAndView.setViewName(addhtml);
        String msg = "";
        String mails[] = mailnos.split("\r\n");
        for(String mailno:mails){
            DengjiDaitoudianmail daitoudian = new DengjiDaitoudianmail();
            daitoudian.setMailno(mailno);
            daitoudian.setShijian(new Date());
            daitoudian.setName(user.getName());
            daitoudian.setBumen(user.getBumen());
            daitoudian.setDaitoudian(daitoudianname);
            try{
                daitoudianmailService.add(daitoudian);
            }catch(Exception e){
                msg+=e.getMessage()+",";
            }
        }
        
        modelAndView.addObject("msg",msg+",保存成功");
        add(modelAndView);
        return modelAndView;
    } 
    
    
   
    
    @GetMapping("/mail/chaxun")
    public ModelAndView chaxun(ModelAndView modelAndView){
        init(modelAndView);
        Subject subject = SecurityUtils.getSubject();
        DengjiUser user = (DengjiUser)subject.getPrincipal();
        modelAndView.setViewName(chaxunhtml);
        if(user.getQuanxian() > 10){
            List<DengjiDaitoudianmail> list = daitoudianmailService.findAll();
            modelAndView.addObject("maillist",list);
        }else{
            List<DengjiDaitoudianmail> list = daitoudianmailService.findByBumen(user.getBumen());
            modelAndView.addObject("maillist",list);
        }
        
        return modelAndView;
    } 
    
}
