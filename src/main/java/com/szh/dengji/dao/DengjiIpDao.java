/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * @autoor szh
 */

package com.szh.dengji.dao;

import com.szh.dengji.domain.DengjiIp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author  szh
 * QQ:873689
 * @date 2019-3-15 11:28:52
 */
@Repository
public interface DengjiIpDao extends  JpaRepository<DengjiIp,String>{

}
