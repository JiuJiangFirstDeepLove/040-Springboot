package com.yuanlrc.system.domain;

import com.yuanlrc.common.annotation.Excel;
import com.yuanlrc.common.core.domain.BaseEntity;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.Date;

/**
 * 框架认证信息对象 authentication
 * 
 * @author yuanlrc
 * @date 2020-05-31
 */
public class AuthenticationYuan extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 流水ID */
    private Long id;

    /** 订单编号 */
    @Excel(name = "订单编号")
    private String orderno;

    /** 手机号 */
    @Excel(name = "手机号")
    private String phoneno;

    /** 学校 */
    @Excel(name = "学校")
    private String school;

    /** 认证ID */
    @Excel(name = "认证ID")
    private String authenticationid;

    /** 认证状态 */
    @Excel(name = "认证状态")
    private String astatus;

    /** 首次认证时间 */
    @Excel(name = "首次认证时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date afirsttime;

    /** 最后次更新时间 */
    @Excel(name = "最后次更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date lasttime;

    /** 远程IP */
    @Excel(name = "远程IP")
    private String remoteip;

    /** 机器标识 */
    @Excel(name = "机器标识")
    private String remotemac;

    /** 用户AGENT */
    @Excel(name = "用户AGENT")
    private String useragent;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setOrderno(String orderno) 
    {
        this.orderno = orderno;
    }

    public String getOrderno() 
    {
        return orderno;
    }
    public void setPhoneno(String phoneno) 
    {
        this.phoneno = phoneno;
    }

    public String getPhoneno() 
    {
        return phoneno;
    }
    public void setSchool(String school) 
    {
        this.school = school;
    }

    public String getSchool() 
    {
        return school;
    }
    public void setAuthenticationid(String authenticationid) 
    {
        this.authenticationid = authenticationid;
    }

    public String getAuthenticationid() 
    {
        return authenticationid;
    }
    public void setAstatus(String astatus) 
    {
        this.astatus = astatus;
    }

    public String getAstatus() 
    {
        return astatus;
    }
    public void setAfirsttime(Date afirsttime) 
    {
        this.afirsttime = afirsttime;
    }

    public Date getAfirsttime() 
    {
        return afirsttime;
    }
    public void setLasttime(Date lasttime) 
    {
        this.lasttime = lasttime;
    }

    public Date getLasttime() 
    {
        return lasttime;
    }
    public void setRemoteip(String remoteip) 
    {
        this.remoteip = remoteip;
    }

    public String getRemoteip() 
    {
        return remoteip;
    }
    public void setRemotemac(String remotemac) 
    {
        this.remotemac = remotemac;
    }

    public String getRemotemac() 
    {
        return remotemac;
    }
    public void setUseragent(String useragent) 
    {
        this.useragent = useragent;
    }

    public String getUseragent() 
    {
        return useragent;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("orderno", getOrderno())
            .append("phoneno", getPhoneno())
            .append("school", getSchool())
            .append("authenticationid", getAuthenticationid())
            .append("astatus", getAstatus())
            .append("afirsttime", getAfirsttime())
            .append("lasttime", getLasttime())
            .append("remoteip", getRemoteip())
            .append("remotemac", getRemotemac())
            .append("useragent", getUseragent())
            .toString();
    }
}
