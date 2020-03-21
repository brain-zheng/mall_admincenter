package com.mall.admincenter.dal.dao;

import com.mall.admincenter.dal.dataobject.AdminUserDO;

/**
 * @author zheng haijain
 * @createTime 2020-03-20 11:06
 * @description
 */
public interface AdminUserDAO extends BaseDAO<AdminUserDO> {

    AdminUserDO getAdminUserByUserName(String userName);


}
