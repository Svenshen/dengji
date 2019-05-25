/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * @autoor szh
 */

package com.szh.dengji.service;

import com.szh.dengji.domain.DengjiIp;
import java.util.List;

/**
 *
 * @author  szh
 * QQ:873689
 * @date 2019-5-24 8:59:12
 */
public interface DengjiIpService {

    void add(DengjiIp dengjiIp) throws Exception;
    
    void update(DengjiIp dengjiIp);
    
    List list();
    
    void delete(String id);
    
    DengjiIp queryone(String id);
    
}
