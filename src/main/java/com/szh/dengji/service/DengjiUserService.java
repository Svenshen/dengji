/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * @autoor szh
 */

package com.szh.dengji.service;

import com.szh.dengji.domain.DengjiUser;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author  szh
 * QQ:873689
 * @date 2018-9-6 14:40:06
 */
public interface DengjiUserService {
    
    public DengjiUser findByUsername(String username);
    
    public Boolean updatePassword(DengjiUser user);
}
