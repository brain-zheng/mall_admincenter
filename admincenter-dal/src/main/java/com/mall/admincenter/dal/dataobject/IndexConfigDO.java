package com.mall.admincenter.dal.dataobject;

import lombok.Data;

/**
 * @author zheng haijain
 * @createTime 2020-04-13 14:34
 * @description
 */
@Data
public class IndexConfigDO extends BaseDO {

    private String configName;

    private Integer configType;

    private Integer goodsId;

    private String redirectUrl;

    private Integer configRank;

    private Integer isDeleted;

}
