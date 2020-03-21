package com.mall.admincenter.service.converter;

import com.mall.admincenter.client.dto.AdminUserDTO;
import com.mall.admincenter.dal.dataobject.AdminUserDO;
import org.springframework.stereotype.Component;

/**
 * @author zheng haijain
 * @createTime 2020-03-20 14:57
 * @description
 */
@Component
public class AdminUserConverter {

    public AdminUserDTO adminUserConverter(AdminUserDO adminUserDO) {
        if (adminUserDO == null) {
            return null;
        }
        AdminUserDTO adminUserDTO = new AdminUserDTO();
        adminUserDTO.setLoginUserName(adminUserDO.getLoginUserName());
        adminUserDTO.setLoginPassword(adminUserDO.getLoginPassword());
        adminUserDTO.setNickName(adminUserDO.getNickName());
        adminUserDTO.setLocked(adminUserDO.getLocked());
        adminUserDTO.setFeature(adminUserDO.getFeature());
        adminUserDTO.setId(adminUserDO.getId());
        adminUserDTO.setCreateTime(adminUserDO.getCreateTime());
        adminUserDTO.setUpdateTime(adminUserDO.getUpdateTime());
        return adminUserDTO;
    }

    public AdminUserDO adminUserDTOConverter2DO(AdminUserDTO adminUserDTO) {
        if (adminUserDTO == null) {
            return null;
        }
        AdminUserDO adminUserDO = new AdminUserDO();
        adminUserDO.setLoginUserName(adminUserDTO.getLoginUserName());
        adminUserDO.setLoginPassword(adminUserDTO.getLoginPassword());
        adminUserDO.setNickName(adminUserDTO.getNickName());
        adminUserDO.setLocked(adminUserDTO.getLocked());
        adminUserDO.setFeature(adminUserDTO.getFeature());
        adminUserDO.setId(adminUserDTO.getId());
        adminUserDO.setCreateTime(adminUserDTO.getCreateTime());
        adminUserDO.setUpdateTime(adminUserDTO.getUpdateTime());
        return adminUserDO;
    }

}
