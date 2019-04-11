/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * @autoor szh
 */

package com.szh.dengji.service.impl;

import com.szh.dengji.service.XydSystemService;
import com.szh.dengji.util.HttpsUtils;
import java.util.HashMap;
import java.util.Map;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 *
 * @author  szh
 * QQ:873689
 * @date 2018-11-26 9:38:10
 */
@Service
@Scope("prototype")
public class XydSystemServiceImpl implements XydSystemService{

    HttpsUtils httpsUtils = new HttpsUtils();
    
    @Override
    public boolean login(String username, String password) {
        boolean flag = true;
        try{
            String html = httpsUtils.get("https://10.3.131.164/cas/login", null, null);
            String lt = html.split("name=\"lt\" value=\"")[1].split("\"")[0];
            String execution = html.split("name=\"execution\" value=\"")[1].split("\"")[0];
            Map<String,String> postdata = new HashMap();
            postdata.put("lt", lt);
            postdata.put("execution", execution);
            postdata.put("username", "2152620000001");
            postdata.put("password", "xyd123456");
            postdata.put("_eventId", "submit");
            httpsUtils.post("https://10.3.131.164/cas/login", null, postdata, null);
        }catch(Exception e){
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }

    @Override
    public String querymail(String mailno) {
        String json = null;
        try{
            json = httpsUtils.get("https://10.3.131.164/querypush-web/a/qps/qpswaybilltraceinternal/queryTraceByTrace_no?trace_no="+mailno, null, null);
        }catch(Exception e){
            e.printStackTrace();
        }
        return json;
    }

    @Override
    public void close() {
        try{
            httpsUtils.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
