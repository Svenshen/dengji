/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * @autoor szh
 */

package com.szh.dengji.dao;

import com.szh.dengji.domain.DengjiLiucunmail;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author  szh
 * QQ:873689
 * @date 2018-9-14 14:54:21
 */
@Repository
public interface LiucunmailDao extends  JpaRepository<DengjiLiucunmail,String>{

    public List findByBumen(String bumen);
    
    public DengjiLiucunmail findByToudimailno(String mailno);
    
    public boolean existsByShoujimailno(String mailno);
    
}
