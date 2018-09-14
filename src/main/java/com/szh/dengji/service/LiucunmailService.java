/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * @autoor szh
 */

package com.szh.dengji.service;

import com.szh.dengji.domain.Liucunmail;
import java.util.List;

/**
 *
 * @author  szh
 * QQ:873689
 * @date 2018-9-14 14:55:27
 */
public interface LiucunmailService {

    public void add(Liucunmail liucunmail) throws Exception;
    
    public List<Liucunmail> findAll();
    
    public List<Liucunmail> findByBumen(String bumen);
    
  
    
}
