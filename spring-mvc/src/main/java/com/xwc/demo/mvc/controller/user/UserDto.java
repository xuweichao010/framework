package com.xwc.demo.mvc.controller.user;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * 创建人：徐卫超 CC
 * 时间：2021/2/13 20:42
 * 备注：
 */
public class UserDto {
    @ApiModelProperty("用户ID")
    private Long id;

    @ApiModelProperty("账号")
    @NotNull(message = "账号不能为空")
    private String account;

    @ApiModelProperty("密码")
    @NotNull(message = "密码不能为空")
    private String password;

    @ApiModelProperty("用户名")
    @NotNull(message = "用户名不能为空")
    private String name;

    @ApiModelProperty("机构名")
    @NotNull(message = "机构不能为空")
    private String orgName;

    @ApiModelProperty("机构代码")
    @NotNull(message = "机构不能为空")
    private String orgCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }
}
