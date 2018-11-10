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
import javax.persistence.IdClass;
import javax.persistence.Temporal;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

/**
 *
 * @author  szh
 * QQ:873689
 * @date 2018-10-23 10:29:11
 */
@Data
@Entity
@IdClass(DengjiToudiliangId.class)
public class DengjiToudiliang implements Serializable {
    @Id
    @Column
    String bumen;
    @Id
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    Date riqi;
    @Column
    int biaokuai = 0;
    @Column
    int kuaibao = 0;
    @Column
    int guoji = 0;
    @Column
    int yituotou = 0;
    @Column
    int zhuantui = 0;
    @Column
    int liucun = 0;
    
    

}
