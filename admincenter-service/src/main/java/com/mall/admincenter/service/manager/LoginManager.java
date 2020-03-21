package com.mall.admincenter.service.manager;

import com.mall.admincenter.client.dto.AdminUserDTO;
import com.mall.admincenter.dal.dao.AdminUserDAO;
import com.mall.admincenter.dal.dataobject.AdminUserDO;
import com.mall.admincenter.service.converter.AdminUserConverter;
import com.sun.scenario.effect.impl.prism.PrImage;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author zheng haijain
 * @createTime 2020-03-20 14:53
 * @description
 */
@Component
public class LoginManager {

    @Resource
    private AdminUserDAO adminUserDAO;

    @Resource
    private AdminUserConverter adminUserConverter;

    public AdminUserDTO getAdminUserByUserName(String username){
        AdminUserDO adminUserDO = adminUserDAO.getAdminUserByUserName(username);
        if (adminUserDO == null) {
            return null;
        }
        return adminUserConverter.adminUserConverter(adminUserDO);
    }

    public AdminUserDTO getAdminUserByUserId(Integer userId){
        AdminUserDO adminUserDO = adminUserDAO.getById(userId);
        if (adminUserDO == null) {
            return null;
        }
        return adminUserConverter.adminUserConverter(adminUserDO);
    }

    public Integer updateAdminUser(AdminUserDTO adminUserDTO){
        AdminUserDO adminUserDO = adminUserConverter.adminUserDTOConverter2DO(adminUserDTO);
        if (adminUserDO == null){
            return 0;
        }
        return adminUserDAO.update(adminUserDO);
    }

}
