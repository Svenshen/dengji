/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * @autoor szh
 */

package com.szh.dengji.service;

import com.szh.dengji.domain.DengjiToudiliang;
import java.util.Date;
import java.util.List;

/**
 *
 * @author  szh
 * QQ:873689
 * @date 2018-10-23 10:40:25
 */
public interface DengjiToudiliangService {

    public List findByriqi(Date riqi);
    
    public void add(DengjiToudiliang dengjiToudiliang);
    
    public DengjiToudiliang findBybumenriqi(Date riqi,String bumen);
    
    public List findByriqibetween(String kshijian,String jshijian) throws Exception;
    
    public List findByriqibetweenbumen(String kshijian,String jshijian,String bumen) throws Exception;
    
    public List findBybumen(String bumen);
    
    public List findAll();
}
