/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * @autoor szh
 */

package com.szh.dengji.service.impl;

import com.szh.dengji.dao.DengjiIpDao;
import com.szh.dengji.domain.DengjiIp;
import com.szh.dengji.service.DengjiIpService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author  szh
 * QQ:873689
 * @date 2019-5-24 8:59:31
 */
@Service
public class DengjiIpServiceImpl implements DengjiIpService{

    @Autowired
    DengjiIpDao dengjiIpDao;
    
    @Override
    public void add(DengjiIp dengjiIp) throws Exception {
       
        DengjiIp d = dengjiIpDao.findById(dengjiIp.getIp()).orElse(null);
        if(d == null){
            dengjiIpDao.save(dengjiIp);
        }else{
            throw new Exception("设备已存在");
        }
        
        
    }

    @Override
    public void update(DengjiIp dengjiIp) {
        dengjiIpDao.save(dengjiIp);
    }

    @Override
    public List list() {
        return dengjiIpDao.findAll();
    }

    @Override
    @Transactional
    public void delete(String id) {
        dengjiIpDao.deleteById(id);
    }

    @Override
    public DengjiIp queryone(String id) {
        return dengjiIpDao.findById(id).orElse(null);
    }

}
