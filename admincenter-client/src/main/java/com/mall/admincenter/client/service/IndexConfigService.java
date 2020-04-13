package com.mall.admincenter.client.service;

import com.mall.admincenter.client.dto.IndexConfigDTO;
import com.mall.admincenter.client.dto.MallIndexConfigGoodsDTO;
import com.mall.common.service.util.PageQueryUtil;

import java.util.List;

/**
 * @author zheng haijain
 * @createTime 2020-04-13 14:11
 * @description
 */
public interface IndexConfigService {

    List<IndexConfigDTO> findIndexConfigList(PageQueryUtil pageUtil, Integer configType);

    int getTotalIndexConfigs(PageQueryUtil pageUtil, Integer configType);

    String saveIndexConfig(IndexConfigDTO indexConfig);

    String updateIndexConfig(IndexConfigDTO indexConfig);

    IndexConfigDTO getIndexConfigById(Integer id);

    Boolean deleteBatch(Integer[] ids);

    /**
     * 返回固定数量的首页配置商品对象(首页调用)
     *
     * @param number
     * @return
     */
    List<MallIndexConfigGoodsDTO> getConfigGoodsesForIndex(int configType, int number);

}
