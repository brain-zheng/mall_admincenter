package com.mall.admincenter.client.service;

import com.mall.admincenter.client.dto.AdminUserDTO;

/**
 * @author zheng haijain
 * @createTime 2020-03-20 14:44
 * @description
 */
public interface LoginRPCService {

    AdminUserDTO getAdminUserByUserName(String username);

}
