package com.mall.admincenter.client.dto;

import lombok.Data;


/**
 * @author zheng haijain
 * @createTime 2020-04-13 14:14
 * @description
 */
@Data
public class IndexConfigDTO extends BaseDTO {

    private static final long serialVersionUID = -2834673329557489175L;

    private String configName;

    private Integer configType;

    private Integer goodsId;

    private String redirectUrl;

    private Integer configRank;

    private Integer isDeleted;

}
