/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * @autoor szh
 */

package com.szh.dengji.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.UniqueConstraint;
import lombok.Data;

/**
 *
 * @author  szh
 * QQ:873689
 * @date 2019-3-15 10:51:20
 */
@Data
@Entity
public class DengjiIp implements Serializable {

    @Id
    @Column
    String ip;
    
    @Column(unique = true)   
    String mac;
    
    @Column(unique = true)            
    String mingcheng;
    @Column
    String shebeilei;
    @Column
    String bumen;
    @Column
    String cdms;
    @Column
    String landesk;
    @Column
    String qushi;
    
    
}
