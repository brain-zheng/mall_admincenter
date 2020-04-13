package com.mall.admincenter.service.manager;

import com.mall.admincenter.client.dto.IndexConfigDTO;
import com.mall.admincenter.client.dto.MallIndexConfigGoodsDTO;
import com.mall.admincenter.client.enums.ServiceResultEnum;
import com.mall.admincenter.dal.dao.IndexConfigDAO;
import com.mall.admincenter.dal.dataobject.IndexConfigDO;
import com.mall.admincenter.service.converter.IndexConfigConverter;
import com.mall.common.service.util.PageQueryUtil;
import com.mall.goodscenter.client.dto.MallGoodsInfoDTO;
import com.mall.goodscenter.client.service.MallGoodsInfoService;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zheng haijain
 * @createTime 2020-04-13 14:31
 * @description
 */
@Component
public class IndexConfigManager {

    @Resource
    private IndexConfigDAO indexConfigDAO;

    @Resource
    private MallGoodsInfoService goodsInfoService;

    public List<IndexConfigDTO> findIndexConfigList(PageQueryUtil pageUtil, Integer configType) {
        List<IndexConfigDO> indexConfigDOS = indexConfigDAO.findIndexConfigList(pageUtil.getStart(), pageUtil.getLimit(), configType);
        return indexConfigDOS.stream().map(IndexConfigConverter::do2dto).collect(Collectors.toList());
    }

    public int getTotalIndexConfigs(PageQueryUtil pageUtil, Integer configType) {
        return indexConfigDAO.getTotalIndexConfigs(pageUtil.getStart(), pageUtil.getLimit(), configType);
    }

    public String save(IndexConfigDTO indexConfig) {
        IndexConfigDO indexConfigDO = IndexConfigConverter.dto2do(indexConfig);
        if (indexConfigDAO.insertSelective(indexConfigDO) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    public String update(IndexConfigDTO indexConfig) {
        IndexConfigDO indexConfigDO = IndexConfigConverter.dto2do(indexConfig);
        IndexConfigDO temp = indexConfigDAO.selectByPrimaryKey(indexConfig.getId());
        if (temp == null) {
            return ServiceResultEnum.DATA_NOT_EXIST.getResult();
        }
        if (indexConfigDAO.updateByPrimaryKeySelective(indexConfigDO) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    public IndexConfigDTO getIndexConfigById(Integer id) {
        IndexConfigDO temp = indexConfigDAO.selectByPrimaryKey(id);
        return IndexConfigConverter.do2dto(temp);
    }

    public Boolean deleteBatch(Integer[] ids) {
        return indexConfigDAO.deleteBatch(ids) > 0;
    }

    public List<MallIndexConfigGoodsDTO> getConfigGoodsesForIndex(int configType, int number) {
        List<MallIndexConfigGoodsDTO> mallIndexConfigGoodsDTOS = new ArrayList<>(number);
        List<IndexConfigDO> indexConfigs = indexConfigDAO.findIndexConfigsByTypeAndNum(configType, number);
        if (!CollectionUtils.isEmpty(indexConfigs)) {
            List<Integer> goodsIds = indexConfigs.stream().map(IndexConfigDO::getGoodsId).collect(Collectors.toList());
            List<MallGoodsInfoDTO> goodsInfoDTOS = goodsIds.stream().map(goodsInfoService::getById).collect(Collectors.toList());
            mallIndexConfigGoodsDTOS = goodsInfoDTOS.stream().map(IndexConfigManager::MallIndexConfigGoodsDTO).collect(Collectors.toList());
            for (MallIndexConfigGoodsDTO goodsDTO : mallIndexConfigGoodsDTOS) {
                String goodsName = goodsDTO.getGoodsName();
                String goodsIntro = goodsDTO.getGoodsIntro();
                // 字符串过长导致文字超出的问题
                if (goodsName.length() > 30) {
                    goodsName = goodsName.substring(0, 30) + "...";
                    goodsDTO.setGoodsName(goodsName);
                }
                if (goodsIntro.length() > 22) {
                    goodsIntro = goodsIntro.substring(0, 22) + "...";
                    goodsDTO.setGoodsIntro(goodsIntro);
                }
            }
        }
        return mallIndexConfigGoodsDTOS;
    }

    private static MallIndexConfigGoodsDTO MallIndexConfigGoodsDTO(MallGoodsInfoDTO goodsInfoDTO) {
        if (goodsInfoDTO == null) {
            return null;
        }
        MallIndexConfigGoodsDTO mallIndexConfigGoodsDTO = new MallIndexConfigGoodsDTO();
        mallIndexConfigGoodsDTO.setGoodsName(goodsInfoDTO.getGoodsName());
        mallIndexConfigGoodsDTO.setGoodsIntro(goodsInfoDTO.getGoodsIntro());
        mallIndexConfigGoodsDTO.setGoodsCoverImg(goodsInfoDTO.getGoodsCoverImg());
        mallIndexConfigGoodsDTO.setSellingPrice(goodsInfoDTO.getSellingPrice());
        mallIndexConfigGoodsDTO.setTag(goodsInfoDTO.getTag());
        mallIndexConfigGoodsDTO.setGoodsId(goodsInfoDTO.getId());
        return mallIndexConfigGoodsDTO;
    }

}
