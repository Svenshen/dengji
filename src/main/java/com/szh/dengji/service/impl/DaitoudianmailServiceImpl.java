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
import com.szh.dengji.service.DaitoudianmailService;

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
    public List<DengjiDaitoudianmail> findAllhuizong() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DengjiDaitoudianmail> findByBumen(String bumen) {
        return daitoudianDao.findByBumen(bumen);
    }

    @Override
    public List<DengjiDaitoudianmail> findByBumenhuizong(String bumen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
