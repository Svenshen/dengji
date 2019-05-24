/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * @autoor szh
 */

package com.szh.dengji.controller;

import com.szh.dengji.domain.DengjiIp;
import com.szh.dengji.domain.DengjiToudiliang;
import com.szh.dengji.domain.DengjiUser;
import com.szh.dengji.service.DengjiBumenService;
import com.szh.dengji.service.DengjiIpService;
import com.szh.dengji.service.DengjiToudiliangService;
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

/**
 *
 * @author  szh
 * QQ:873689
 * @date 2019-5-24 8:58:53
 */
@Controller
@RequestMapping(value = "/dengjiip")
public class DengjiIpController {

    String addhtml = "ip-add";
    String chaxunhtml = "ip-chaxun";
    
    @Autowired
    DengjiIpService dengjiIpService;
    @Autowired
    DengjiBumenService dengjiBumenService;
    
    
    
    public void init(ModelAndView modelAndView){
        Subject subject = SecurityUtils.getSubject();
        DengjiUser user = (DengjiUser)subject.getPrincipal();
        modelAndView.addObject("bumenlist",dengjiBumenService.list());
        modelAndView.addObject("user",user);
    }
    
    @GetMapping("/add")
    public ModelAndView add(ModelAndView modelAndView){
        init(modelAndView);
        modelAndView.setViewName(addhtml);
        return modelAndView;
    }
    @PostMapping("/add")
    public ModelAndView add(ModelAndView modelAndView,DengjiIp dengjiIp){
        init(modelAndView);
        modelAndView.setViewName(addhtml);
        try{
            dengjiIpService.add(dengjiIp);
            modelAndView.addObject("msg", "登记成功");
        }catch(Exception e){
            modelAndView.addObject("msg", e.getMessage());
        }
        return modelAndView;
    }
    @GetMapping("/chaxun")
    public ModelAndView chaxun(ModelAndView modelAndView){
        init(modelAndView);
        modelAndView.setViewName(chaxunhtml);
        
        modelAndView.addObject("iplist", dengjiIpService.list());
        
        return modelAndView;
    }
    
    
}
