/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * @autoor szh
 */

package com.szh.dengji.service;

import com.szh.dengji.domain.DengjiDaitoudianmail;
import java.util.List;

/**
 *
 * @author  szh
 * QQ:873689
 * @date 2018-9-17 13:42:59
 */
public interface DaitoudianmailService {

    public void add(DengjiDaitoudianmail dengjiDaitoudian) throws Exception;
    
    public List<DengjiDaitoudianmail> findAll();
    
    public List<DengjiDaitoudianmail> findAllhuizong();
    
    public List<DengjiDaitoudianmail> findByBumen(String bumen);
    
    public List<DengjiDaitoudianmail> findByBumenhuizong(String bumen);
    
}
