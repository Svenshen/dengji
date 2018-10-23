/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * @autoor szh
 */

package com.szh.dengji.controller;

import com.szh.dengji.domain.DengjiDaitoudian;
import com.szh.dengji.domain.DengjiToudiliang;
import com.szh.dengji.domain.DengjiUser;
import com.szh.dengji.service.DengjiToudiliangService;
import java.util.ArrayList;
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
 * @date 2018-10-23 10:46:48
 */
@Controller
@RequestMapping(value = "/toudiliang")
public class ToudiliangController {

    @Autowired
    DengjiToudiliangService dengjiToudiliangService;
    
    final String addhtml = "toudiliang-add";
    final String chaxunhtml = "toudiliang-chaxun";
    
    
    public void init(ModelAndView modelAndView){
        Subject subject = SecurityUtils.getSubject();
        DengjiUser user = (DengjiUser)subject.getPrincipal();
        modelAndView.addObject("user",user);
    }
    
    @GetMapping("/add")
    public ModelAndView add(ModelAndView modelAndView){
        init(modelAndView);
        modelAndView.setViewName(addhtml);
        Subject subject = SecurityUtils.getSubject();
        DengjiUser user = (DengjiUser)subject.getPrincipal();
        modelAndView.addObject("mail",dengjiToudiliangService.findBybumenriqi(new Date(), user.getBumen()));
        return modelAndView;
    }
    @PostMapping("/add")
    public ModelAndView add(ModelAndView modelAndView,DengjiToudiliang dengjiToudiliang){
        init(modelAndView);
        modelAndView.setViewName(addhtml);
        System.out.println(dengjiToudiliang);
        Subject subject = SecurityUtils.getSubject();
        DengjiUser user = (DengjiUser)subject.getPrincipal();
        dengjiToudiliang.setBumen(user.getBumen());
        dengjiToudiliang.setRiqi(new Date());
        dengjiToudiliangService.add(dengjiToudiliang);
        modelAndView.addObject("mail",dengjiToudiliangService.findBybumenriqi(new Date(), user.getBumen()));
        modelAndView.addObject("msg", "登记成功");
        return modelAndView;
    }
    @GetMapping("/chaxun")
    public ModelAndView chaxun(ModelAndView modelAndView){
        init(modelAndView);
        modelAndView.setViewName(chaxunhtml);
        
        
        return modelAndView;
    }
    @PostMapping("/chaxun")
    public ModelAndView chaxun(ModelAndView modelAndView,@RequestParam("kshijian") String kshijian,@RequestParam("jshijian") String jshijian){
        init(modelAndView);
        modelAndView.setViewName(chaxunhtml);
        Subject subject = SecurityUtils.getSubject();
        DengjiUser user = (DengjiUser)subject.getPrincipal();
        try{
            DengjiToudiliang huizong = new DengjiToudiliang();
            if(user.getQuanxian() > 10){
                List<DengjiToudiliang> list20 = dengjiToudiliangService.findByriqibetween(kshijian, jshijian);
                for(DengjiToudiliang d : list20){
                    huizong.setBiaokuai(huizong.getBiaokuai()+d.getBiaokuai());
                    huizong.setKuaibao(huizong.getKuaibao()+d.getKuaibao());
                    huizong.setGuoji(huizong.getGuoji()+d.getGuoji());
                    huizong.setLiucun(huizong.getLiucun()+d.getLiucun());
                    huizong.setYituotou(huizong.getYituotou()+d.getYituotou());
                    huizong.setZhuantui(huizong.getZhuantui()+d.getZhuantui());
                }
                modelAndView.addObject("list", list20);
            }else{
                List<DengjiToudiliang> list10 = dengjiToudiliangService.findByriqibetweenbumen(kshijian, jshijian, user.getBumen());
                for(DengjiToudiliang d : list10){
                    huizong.setBiaokuai(huizong.getBiaokuai()+d.getBiaokuai());
                    huizong.setKuaibao(huizong.getKuaibao()+d.getKuaibao());
                    huizong.setGuoji(huizong.getGuoji()+d.getGuoji());
                    huizong.setLiucun(huizong.getLiucun()+d.getLiucun());
                    huizong.setYituotou(huizong.getYituotou()+d.getYituotou());
                    huizong.setZhuantui(huizong.getZhuantui()+d.getZhuantui());
                }
                modelAndView.addObject("list", list10);
            }
            modelAndView.addObject("huizong", huizong);
        }catch(Exception e){
            modelAndView.addObject("msg",e.getMessage());
            e.printStackTrace();
        }
        return modelAndView;
    }
}
