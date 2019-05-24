/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * @autoor szh
 */

package com.szh.dengji.service.impl;

import com.szh.dengji.dao.DengjiBumenDao;
import com.szh.dengji.service.DengjiBumenService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author  szh
 * QQ:873689
 * @date 2019-5-24 12:37:41
 */
@Service
public class DengjiBumenServiceImpl implements  DengjiBumenService{

    @Autowired
    DengjiBumenDao dengjiBumenDao;
    
    @Override
    public List list() {
        return dengjiBumenDao.findAll();
    }

}
