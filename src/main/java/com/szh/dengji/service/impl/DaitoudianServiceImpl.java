/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * @autoor szh
 */

package com.szh.dengji.service.impl;

import com.szh.dengji.dao.DaitoudianDao;
import com.szh.dengji.domain.DengjiDaitoudian;
import com.szh.dengji.service.DaitoudianService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author  szh
 * QQ:873689
 * @date 2018-9-17 15:42:43
 */
@Service
public class DaitoudianServiceImpl implements DaitoudianService{

    @Autowired
    DaitoudianDao daitoudianDao;
    
    @Override
    public List<DengjiDaitoudian> findByBumen(String bumen) {
        return daitoudianDao.findByBumen(bumen);
    }

    @Override
    public void add(DengjiDaitoudian dengjiDaitoudian) throws Exception {
        if(daitoudianDao.existsById(dengjiDaitoudian.getName())) throw new Exception("代投点已存在");
        daitoudianDao.save(dengjiDaitoudian);
    }

    @Override
    public void del(String name) {
        daitoudianDao.deleteById(name);
    }

}
