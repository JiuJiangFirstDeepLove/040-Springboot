package com.yuanlrc.system.controller;

import com.yuanlrc.common.annotation.Log;
import com.yuanlrc.common.core.controller.BaseController;
import com.yuanlrc.common.core.domain.AjaxResult;
import com.yuanlrc.common.core.page.TableDataInfo;
import com.yuanlrc.common.enums.BusinessType;
import com.yuanlrc.common.utils.poi.ExcelUtil;
import com.yuanlrc.system.domain.AuthenticationYuan;
import com.yuanlrc.system.service.IAuthenticationYuanService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 框架认证信息Controller
 * 
 * @author yuanlrc
 * @date 2020-05-31
 */
@Controller
@RequestMapping("/authentication/authentication")
public class AuthenticationYuanController extends BaseController
{
    private String prefix = "authentication/authentication";

    @Autowired
    private IAuthenticationYuanService authenticationYuanService;

    @RequiresPermissions("authentication:authentication:view")
    @GetMapping()
    public String authentication()
    {
        return prefix + "/authentication";
    }

    /**
     * 查询框架认证信息列表
     */
    @RequiresPermissions("authentication:authentication:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(AuthenticationYuan authenticationYuan)
    {
        startPage();
        List<AuthenticationYuan> list = authenticationYuanService.selectAuthenticationYuanList(authenticationYuan);
        return getDataTable(list);
    }

    /**
     * 导出框架认证信息列表
     */
    @RequiresPermissions("authentication:authentication:export")
    @Log(title = "框架认证信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(AuthenticationYuan authenticationYuan)
    {
        List<AuthenticationYuan> list = authenticationYuanService.selectAuthenticationYuanList(authenticationYuan);
        ExcelUtil<AuthenticationYuan> util = new ExcelUtil<AuthenticationYuan>(AuthenticationYuan.class);
        return util.exportExcel(list, "authentication");
    }

    /**
     * 新增框架认证信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存框架认证信息
     */
    @RequiresPermissions("authentication:authentication:add")
    @Log(title = "框架认证信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(AuthenticationYuan authenticationYuan)
    {
        return toAjax(authenticationYuanService.insertAuthenticationYuan(authenticationYuan));
    }

    /**
     * 修改框架认证信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        AuthenticationYuan authenticationYuan = authenticationYuanService.selectAuthenticationYuanById(id);
        mmap.put("authenticationYuan", authenticationYuan);
        return prefix + "/edit";
    }

    /**
     * 修改保存框架认证信息
     */
    @RequiresPermissions("authentication:authentication:edit")
    @Log(title = "框架认证信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(AuthenticationYuan authenticationYuan)
    {
        return toAjax(authenticationYuanService.updateAuthenticationYuan(authenticationYuan));
    }

    /**
     * 删除框架认证信息
     */
    @RequiresPermissions("authentication:authentication:remove")
    @Log(title = "框架认证信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(authenticationYuanService.deleteAuthenticationYuanByIds(ids));
    }
}
