/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * @autoor szh
 */

package com.szh.dengji.dao;

import com.szh.dengji.domain.DengjiDaitoudianmail;
import com.szh.dengji.domain.DengjiDaitoudianmailhuizong;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author  szh
 * QQ:873689
 * @date 2018-9-17 13:42:18
 */
@Repository
public interface DaidoudianmailDao extends  JpaRepository<DengjiDaitoudianmail,String>{

    public List findByBumen(String bumen);
    
    public List findByBumenAndShijianBetween(String bumen,Date kshijian,Date jshijian);
    
    public List findByShijianBetween(Date kshijian,Date jshijian);
    
    //#{#entityName}
    @Query(value = "select new com.szh.dengji.domain.DengjiDaitoudianmailhuizong(bumen,daitoudian,count(*))  from #{#entityName} where bumen = ?1 and shijian between ?2 and ?3 group by daitoudian,bumen")
    public List findByBumenAndShijianBetweenGroupbyDaitoudian(String bumen,Date kshijian,Date jshijian);
    
    @Query(value = "select new com.szh.dengji.domain.DengjiDaitoudianmailhuizong(bumen,daitoudian,count(*))  from #{#entityName} where shijian between ?1 and ?2 group by daitoudian,bumen")
    public List findByShijianBetweenGroupbyDaitoudian(Date kshijian,Date jshijian);
    
}
