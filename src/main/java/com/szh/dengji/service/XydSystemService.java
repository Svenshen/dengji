/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * @autoor szh
 */

package com.szh.dengji.service;

import com.szh.dengji.util.HttpsUtils;

/**
 *
 * @author  szh
 * QQ:873689
 * @date 2018-11-26 9:33:45
 */
public interface XydSystemService {
    
    
    
    public boolean login(String username,String password);
    
    public String querymail(String mailno);
    
    public void close();
}
