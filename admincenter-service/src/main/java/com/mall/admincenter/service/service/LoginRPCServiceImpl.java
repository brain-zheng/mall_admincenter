package com.mall.admincenter.service.service;

import com.mall.admincenter.client.dto.AdminUserDTO;
import com.mall.admincenter.client.service.LoginRPCService;
import com.mall.admincenter.service.manager.LoginManager;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * @author zheng haijain
 * @createTime 2020-03-20 14:52
 * @description
 */
@Service("LoginRPCServiceImpl")
public class LoginRPCServiceImpl implements LoginRPCService {

    @Resource
    private LoginManager loginManager;

    @Override
    public AdminUserDTO getAdminUserByUserName(String username) {
        // 校验
        if(StringUtils.isEmpty(username)){
            return null;
        }
        return loginManager.getAdminUserByUserName(username);
    }
}
