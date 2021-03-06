/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * @autoor szh
 */

package com.szh.dengji.service.impl;

import com.szh.dengji.domain.DengjiLiucunmail;
import com.szh.dengji.service.LiucunmailService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.szh.dengji.dao.LiucunmailDao;

/**
 *
 * @author  szh
 * QQ:873689
 * @date 2018-9-14 14:56:06
 */
@Service
public class LiucunmailServiceImpl implements LiucunmailService{

    @Autowired
    LiucunmailDao liucunmailDao;

    @Override
    public void add(DengjiLiucunmail liucunmail) throws Exception {
        if(liucunmailDao.existsById(liucunmail.getToudimailno()))
            throw new Exception("邮件已存在1");
        if(liucunmailDao.existsByShoujimailno(liucunmail.getShoujimailno()))
            throw new Exception("邮件已存在2");
        
        liucunmailDao.save(liucunmail);
    }

    @Override
    public List<DengjiLiucunmail> findAll() {
        return liucunmailDao.findAll();
    }

    @Override
    public List<DengjiLiucunmail> findByBumen(String bumen) {
        return liucunmailDao.findByBumen(bumen);
    }
    
    
}
