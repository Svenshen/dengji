/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * @autoor szh
 */

package com.szh.dengji.service.impl;

import com.szh.dengji.dao.DengjiToudiliangDao;
import com.szh.dengji.domain.DengjiToudiliang;
import com.szh.dengji.service.DengjiToudiliangService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author  szh
 * QQ:873689
 * @date 2018-10-23 10:42:06
 */
@Service
public class DengjiToudiliangServiceImpl implements DengjiToudiliangService{

    @Autowired
    DengjiToudiliangDao dengjiToudiliangDao;
    
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    
    @Override
    public List findByriqi(Date riqi) {
        return dengjiToudiliangDao.findByRiqiOrderByRiqiDesc(riqi);
    }

    

    @Override
    public List findBybumen(String bumen) {
        return dengjiToudiliangDao.findByBumen(bumen);
    }

    @Override
    public void add(DengjiToudiliang dengjiToudiliang) {
        dengjiToudiliangDao.save(dengjiToudiliang);
    }

    @Override
    public DengjiToudiliang findBybumenriqi(Date riqi, String bumen) {
        return dengjiToudiliangDao.findByRiqiAndBumenOrderByRiqiDesc(riqi, bumen);
    }

    @Override
    public List findAll() {
        return dengjiToudiliangDao.findAll();
    }

    @Override
    public List findByriqibetween(String kshijian, String jshijian) throws Exception{
        return dengjiToudiliangDao.findByRiqiBetweenOrderByRiqiDesc(sdf.parse(kshijian), sdf.parse(jshijian));
    }

    @Override
    public List findByriqibetweenbumen(String kshijian, String jshijian, String bumen) throws Exception{
        return dengjiToudiliangDao.findByRiqiBetweenAndBumenOrderByRiqiDesc(sdf.parse(kshijian), sdf.parse(jshijian), bumen);
    }

}
