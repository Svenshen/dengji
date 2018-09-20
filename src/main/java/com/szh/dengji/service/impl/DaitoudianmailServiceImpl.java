/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * @autoor szh
 */

package com.szh.dengji.service.impl;

import com.szh.dengji.domain.DengjiDaitoudianmail;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.szh.dengji.dao.DaidoudianmailDao;
import com.szh.dengji.domain.DengjiDaitoudianmailhuizong;
import com.szh.dengji.service.DaitoudianmailService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 *
 * @author  szh
 * QQ:873689
 * @date 2018-9-17 13:47:42
 */
@Service
public class DaitoudianmailServiceImpl implements  DaitoudianmailService{

    @Autowired
    DaidoudianmailDao daitoudianDao;
    
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Override
    public void add(DengjiDaitoudianmail dengjiDaitoudian) throws Exception {
        if(daitoudianDao.existsById(dengjiDaitoudian.getMailno())) throw new Exception(dengjiDaitoudian.getMailno()+"邮件号已存在");
        daitoudianDao.save(dengjiDaitoudian);
    }

    @Override
    public List<DengjiDaitoudianmail> findAll() {
        return daitoudianDao.findAll();
    }

 

    @Override
    public List<DengjiDaitoudianmail> findByBumen(String bumen) {
        return daitoudianDao.findByBumen(bumen);
    }



    @Override
    public List<DengjiDaitoudianmail> findByShijian(String kshijian, String jshijian) throws Exception{
        return daitoudianDao.findByShijianBetween(sdf.parse(kshijian), sdf.parse(jshijian));
    }

    @Override
    public List<DengjiDaitoudianmail> findByBumenShijian(String bumen, String kshijian, String jshijian) throws Exception{
        return daitoudianDao.findByBumenAndShijianBetween(bumen, sdf.parse(kshijian), sdf.parse(jshijian));
    }

    @Override
    public List<DengjiDaitoudianmailhuizong> findByBumenShijianGroupbyDaitoudian(String bumen, String kshijian, String jshijian) throws Exception {
        return daitoudianDao.findByBumenAndShijianBetweenGroupbyDaitoudian(bumen, sdf.parse(kshijian), sdf.parse(jshijian));
    }

    @Override
    public List<DengjiDaitoudianmailhuizong> findByShijianGroupbyDaitoudian( String kshijian, String jshijian) throws Exception {
        return daitoudianDao.findByShijianBetweenGroupbyDaitoudian(sdf.parse(kshijian), sdf.parse(jshijian));
    }

}
