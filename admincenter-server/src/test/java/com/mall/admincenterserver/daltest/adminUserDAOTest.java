package com.mall.admincenterserver.daltest;

import com.mall.admincenter.dal.dao.AdminUserDAO;
import com.mall.admincenter.dal.dataobject.AdminUserDO;
import com.mall.admincenterserver.BaseTest;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author zheng haijain
 * @createTime 2020-03-20 13:41
 * @description
 */
public class adminUserDAOTest extends BaseTest {

    @Resource
    private AdminUserDAO adminUserDAO;

    @Test
    public void getAdminUserByUserNameTest(){
        String username = "admin";
        AdminUserDO result = adminUserDAO.getAdminUserByUserName(username);
        System.out.println(result);
    }

}
