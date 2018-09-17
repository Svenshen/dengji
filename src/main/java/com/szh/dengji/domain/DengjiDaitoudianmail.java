/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * @autoor szh
 */

package com.szh.dengji.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import lombok.Data;

/**
 *
 * @author  szh
 * QQ:873689
 * @date 2018-9-17 8:08:23
 */
@Data
@Entity
public class DengjiDaitoudianmail implements Serializable {

    @Id
    @Column
    String mailno;
    @Column
    String name;
    @Column
    String bumen;
    @Column
    String daitoudian;
    @Column
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    Date shijian;
    
    
}
