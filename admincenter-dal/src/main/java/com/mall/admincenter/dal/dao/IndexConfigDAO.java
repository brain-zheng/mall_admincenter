package com.mall.admincenter.dal.dao;

import com.mall.admincenter.dal.dataobject.IndexConfigDO;
import com.mall.common.service.util.PageQueryUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zheng haijain
 * @createTime 2020-04-13 14:32
 * @description
 */
public interface IndexConfigDAO  {

    List<IndexConfigDO> findIndexConfigList(@Param("start") Integer start, @Param("limit") Integer limit, @Param("configType") Integer configType);

    int getTotalIndexConfigs(@Param("start") Integer start, @Param("limit") Integer limit, @Param("configType") Integer configType);

    int insertSelective(IndexConfigDO record);

    IndexConfigDO selectByPrimaryKey(Integer configId);

    int updateByPrimaryKeySelective(IndexConfigDO record);

    int deleteBatch(Integer[] ids);

    List<IndexConfigDO> findIndexConfigsByTypeAndNum(@Param("configType") int configType, @Param("number") int number);

}
