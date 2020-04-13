package com.mall.admincenter.client.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zheng haijain
 * @createTime 2020-04-13 18:59
 * @description
 */
@Data
public class MallIndexConfigGoodsDTO implements Serializable {

    private static final long serialVersionUID = 8833271102161477031L;

    private Integer goodsId;

    private String goodsName;

    private String goodsIntro;

    private String goodsCoverImg;

    private Integer sellingPrice;

    private String tag;

}
