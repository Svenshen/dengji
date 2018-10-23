/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * @autoor szh
 */

package com.szh.dengji.dao;

import com.szh.dengji.domain.DengjiToudiliang;
import com.szh.dengji.domain.DengjiToudiliangId;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author  szh
 * QQ:873689
 * @date 2018-10-23 10:36:34
 */
@Repository
public interface DengjiToudiliangDao extends  JpaRepository<DengjiToudiliang,DengjiToudiliangId>{

    public List findByRiqiOrderByRiqiDesc(Date riqi);
    
    public DengjiToudiliang findByRiqiAndBumenOrderByRiqiDesc(Date riqi,String bumen);
    
    public List findByRiqiBetweenAndBumenOrderByRiqiDesc(Date kriqi,Date jriqi,String bumen);
    
    public List findByRiqiBetweenOrderByRiqiDesc(Date kriqi,Date jriqi);
    
    public List findByBumen(String bumen);
}
