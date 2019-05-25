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
import javax.websocket.server.PathParam;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    String updatehtml = "ip-update";
    
    String [] xuanzelist ={"是","否"};
    
    @Autowired
    DengjiIpService dengjiIpService;
    @Autowired
    DengjiBumenService dengjiBumenService;
    
    @ModelAttribute(name = "user")
    public DengjiUser getuser(){
        Subject subject = SecurityUtils.getSubject();
        return (DengjiUser)subject.getPrincipal();
    }
    
    @ModelAttribute(name = "bumenlist")
    public List getbumen(){
        return dengjiBumenService.list();
    }
    
    @ModelAttribute(name = "xuanzelist")
    public String[] getxuanze(){
        return xuanzelist;
    }
    
    public void init(ModelAndView modelAndView){
        
        
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
    
    @GetMapping("/delete/{ip}")
    public ModelAndView delete(ModelAndView modelAndView,@PathVariable String ip){
        init(modelAndView);
        modelAndView.setViewName(chaxunhtml);
        dengjiIpService.delete(ip);
        
        modelAndView.addObject("iplist", dengjiIpService.list());
        
        return modelAndView;
    }
    
    @GetMapping("/update/{ip}")
    public ModelAndView update(ModelAndView modelAndView,@PathVariable String ip ){
        init(modelAndView);
        modelAndView.setViewName(updatehtml);
        modelAndView.addObject("ip", dengjiIpService.queryone(ip));
        return modelAndView;
    }
    
    @PostMapping("/update")
    public ModelAndView update(ModelAndView modelAndView,DengjiIp dengjiIp ){
        init(modelAndView);
        modelAndView.setViewName(updatehtml);
        dengjiIpService.update(dengjiIp);
        modelAndView.addObject("msg", "修改成功");
        return modelAndView;
    }
    
    
}
