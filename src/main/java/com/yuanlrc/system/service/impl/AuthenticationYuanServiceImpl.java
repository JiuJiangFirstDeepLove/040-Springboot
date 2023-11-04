package com.yuanlrc.system.service.impl;

import com.yuanlrc.common.core.text.Convert;
import com.yuanlrc.common.json.JSONObject;
import com.yuanlrc.system.domain.AuthenticationYuan;
import com.yuanlrc.system.mapper.AuthenticationYuanMapper;
import com.yuanlrc.system.service.IAuthenticationYuanService;
import com.yuanlrc.system.utils.DESUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 框架认证信息Service业务层处理
 * 
 * @author yuanlrc
 * @date 2020-05-31
 */
@Service
public class AuthenticationYuanServiceImpl implements IAuthenticationYuanService
{



    @Autowired
    private AuthenticationYuanMapper authenticationYuanMapper;

    /**
     * 查询框架认证信息
     * 
     * @param id 框架认证信息ID
     * @return 框架认证信息
     */
    @Override
    public AuthenticationYuan selectAuthenticationYuanById(Long id)
    {
        return authenticationYuanMapper.selectAuthenticationYuanById(id);
    }

    /**
     * 查询框架认证信息列表
     * 
     * @param authenticationYuan 框架认证信息
     * @return 框架认证信息
     */
    @Override
    public List<AuthenticationYuan> selectAuthenticationYuanList(AuthenticationYuan authenticationYuan)
    {
        return authenticationYuanMapper.selectAuthenticationYuanList(authenticationYuan);
    }

    /**
     * 新增框架认证信息
     * 
     * @param authenticationYuan 框架认证信息
     * @return 结果
     */
    @Override
    public int insertAuthenticationYuan(AuthenticationYuan authenticationYuan)
    {
        return authenticationYuanMapper.insertAuthenticationYuan(authenticationYuan);
    }

    /**
     * 修改框架认证信息
     * 
     * @param authenticationYuan 框架认证信息
     * @return 结果
     */
    @Override
    public int updateAuthenticationYuan(AuthenticationYuan authenticationYuan)
    {
        return authenticationYuanMapper.updateAuthenticationYuan(authenticationYuan);
    }

    /**
     * 删除框架认证信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteAuthenticationYuanByIds(String ids)
    {
        return authenticationYuanMapper.deleteAuthenticationYuanByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除框架认证信息信息
     * 
     * @param id 框架认证信息ID
     * @return 结果
     */
    @Override
    public int deleteAuthenticationYuanById(Long id)
    {
        return authenticationYuanMapper.deleteAuthenticationYuanById(id);
    }

    @Override
    public String findyuanlaruciORDER(String ordersn, String phoneno) {
        JSONObject jsonObject=new JSONObject();
        String uri="https://admin.yuanlrc.com/system/auth_order"+"orderSn="+ordersn+"&"+"phone="+phoneno;
        HttpHeaders headers = new HttpHeaders();
        String paramtemp = ordersn+"#"+phoneno;
        System.out.println(paramtemp);
        String paramtoken = DESUtil.encrypt("muyi_ylrc",paramtemp);
        System.out.println(paramtoken);

        String timetoken = DESUtil.encrypt("muyi_ylrc",System.currentTimeMillis()+"");
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.set("paramToken",paramtoken);
        headers.set("timeToken",timetoken);
        System.out.println( DESUtil.decrypt("muyi_ylrc",paramtoken));
        RestTemplate restTemplate = new RestTemplate();
       /* jsonObject.put("orderSn",ordersn);
        jsonObject.put("phone",phoneno);*/
        return restTemplate.postForEntity(uri,jsonObject,String.class).getBody();
    }




}
