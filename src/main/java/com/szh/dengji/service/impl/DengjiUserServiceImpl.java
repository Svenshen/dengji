/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * @autoor szh
 */

package com.szh.dengji.service.impl;

import com.szh.dengji.dao.DengjiUserDao;
import com.szh.dengji.domain.DengjiUser;
import com.szh.dengji.service.DengjiUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author  szh
 * QQ:873689
 * @date 2018-9-7 10:59:08
 */
@Service
public class DengjiUserServiceImpl implements  DengjiUserService{

    @Autowired
    DengjiUserDao dengjiUserDao;
    
    /**
     * 
     * @param username
     * @return 
     */
    @Override
    public DengjiUser findByUsername(String username) {
        return dengjiUserDao.findByUsername(username);
    }

    
    /**
     * 
     * @param user
     * @return 
     */
    @Override
    public Boolean updatePassword(DengjiUser user) {
        
        try{
            dengjiUserDao.save(user);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    
}
