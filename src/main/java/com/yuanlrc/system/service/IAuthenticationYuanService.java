package com.yuanlrc.system.service;

import com.yuanlrc.system.domain.AuthenticationYuan;

import java.util.List;

/**
 * 框架认证信息Service接口
 * 
 * @author yuanlrc
 * @date 2020-05-31
 */
public interface IAuthenticationYuanService 
{
    /**
     * 查询框架认证信息
     * 
     * @param id 框架认证信息ID
     * @return 框架认证信息
     */
    public AuthenticationYuan selectAuthenticationYuanById(Long id);

    /**
     * 查询框架认证信息列表
     * 
     * @param authenticationYuan 框架认证信息
     * @return 框架认证信息集合
     */
    public List<AuthenticationYuan> selectAuthenticationYuanList(AuthenticationYuan authenticationYuan);

    /**
     * 新增框架认证信息
     * 
     * @param authenticationYuan 框架认证信息
     * @return 结果
     */
    public int insertAuthenticationYuan(AuthenticationYuan authenticationYuan);

    /**
     * 修改框架认证信息
     * 
     * @param authenticationYuan 框架认证信息
     * @return 结果
     */
    public int updateAuthenticationYuan(AuthenticationYuan authenticationYuan);

    /**
     * 批量删除框架认证信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteAuthenticationYuanByIds(String ids);

    /**
     * 删除框架认证信息信息
     * 
     * @param id 框架认证信息ID
     * @return 结果
     */
    public int deleteAuthenticationYuanById(Long id);

    public String findyuanlaruciORDER(String ordersn, String phoneno);
}
