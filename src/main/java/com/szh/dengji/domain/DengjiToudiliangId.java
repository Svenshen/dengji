/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * @autoor szh
 */

package com.szh.dengji.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Temporal;
import lombok.Data;

/**
 *
 * @author  szh
 * QQ:873689
 * @date 2018-10-23 10:30:59
 */
@Data
public class DengjiToudiliangId implements Serializable{

    String bumen;
    @Temporal(javax.persistence.TemporalType.DATE)
    Date riqi;
    
    

}
