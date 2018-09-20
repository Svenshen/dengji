/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * @autoor szh
 */

package com.szh.dengji.domain;

import javax.persistence.Entity;
import lombok.Data;

/**
 *
 * @author  szh
 * QQ:873689
 * @date 2018-9-20 8:40:10
 */
@Data
public class DengjiDaitoudianmailhuizong {

    public DengjiDaitoudianmailhuizong(String bumen,String daitoudian, Long shuliang) {
        this.bumen = bumen;
        this.daitoudian = daitoudian;
        this.shuliang = shuliang;
    }

    
    
    String bumen;
    String daitoudian;
    Long shuliang;
}
