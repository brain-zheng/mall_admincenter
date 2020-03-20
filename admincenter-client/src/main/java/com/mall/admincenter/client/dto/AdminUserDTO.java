package com.mall.admincenter.client.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zheng haijain
 * @createTime 2020-03-20 14:44
 * @description  管理员信息
 */
@Data
public class AdminUserDTO extends BaseDTO{

    private static final long serialVersionUID = 4945242054270905720L;

    /**
     * 用户名
     */
    private String loginUserName;

    /**
     * 登录密码
     */
    private String loginPassword;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 账户状态
     */
    private Integer locked;

    /**
     * 拓展字段
     */
    private String feature;

}
