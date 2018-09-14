/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * @autoor szh
 */

package com.szh.dengji.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

/**
 *
 * @author  szh
 * QQ:873689
 * @date 2018-9-14 14:46:24
 */
@Data
@Entity
public class Liucunmail {
    @Id
    @Column
    String toudimailno;
    @Column(unique = true)
    String shoujimailno;
    @Column
    String name;
    @Column
    String bumen;
    @Column 
    Double shoujijine;
    @Column
    Date shijian;

}
