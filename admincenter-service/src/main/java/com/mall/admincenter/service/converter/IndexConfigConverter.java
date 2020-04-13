package com.mall.admincenter.service.converter;

import com.mall.admincenter.client.dto.IndexConfigDTO;
import com.mall.admincenter.dal.dataobject.IndexConfigDO;
import com.mall.admincenter.service.service.IndexConfigServiceImpl;

/**
 * @author zheng haijain
 * @createTime 2020-04-13 14:41
 * @description
 */
public class IndexConfigConverter {

    public static IndexConfigDO dto2do(IndexConfigDTO dto) {
        if (dto == null) {
            return null;
        }
        IndexConfigDO indexConfigDO = new IndexConfigDO();
        indexConfigDO.setConfigName(dto.getConfigName());
        indexConfigDO.setConfigType(dto.getConfigType());
        indexConfigDO.setGoodsId(dto.getGoodsId());
        indexConfigDO.setRedirectUrl(dto.getRedirectUrl());
        indexConfigDO.setConfigRank(dto.getConfigRank());
        indexConfigDO.setIsDeleted(dto.getIsDeleted());
        indexConfigDO.setId(dto.getId());
        indexConfigDO.setCreateTime(dto.getCreateTime());
        indexConfigDO.setUpdateTime(dto.getUpdateTime());
        return indexConfigDO;
    }

    public static IndexConfigDTO do2dto(IndexConfigDO configDO) {
        if (configDO == null) {
            return null;
        }
        IndexConfigDTO indexConfigDTO = new IndexConfigDTO();
        indexConfigDTO.setConfigName(configDO.getConfigName());
        indexConfigDTO.setConfigType(configDO.getConfigType());
        indexConfigDTO.setGoodsId(configDO.getGoodsId());
        indexConfigDTO.setRedirectUrl(configDO.getRedirectUrl());
        indexConfigDTO.setConfigRank(configDO.getConfigRank());
        indexConfigDTO.setIsDeleted(configDO.getIsDeleted());
        indexConfigDTO.setId(configDO.getId());
        indexConfigDTO.setCreateTime(configDO.getCreateTime());
        indexConfigDTO.setUpdateTime(configDO.getUpdateTime());
        return indexConfigDTO;
    }

}
