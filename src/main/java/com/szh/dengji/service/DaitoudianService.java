/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * @autoor szh
 */

package com.szh.dengji.service;

import com.szh.dengji.domain.DengjiDaitoudian;
import java.util.List;

/**
 *
 * @author  szh
 * QQ:873689
 * @date 2018-9-17 15:41:03
 */
public interface DaitoudianService {

    public List<DengjiDaitoudian> findByBumen(String bumen);
    
    public void add(DengjiDaitoudian dengjiDaitoudian) throws Exception;
    
    public void del(String name);
    
    
}
