package com.mall.admincenter.service.service;

import com.mall.admincenter.client.dto.IndexConfigDTO;
import com.mall.admincenter.client.dto.MallIndexConfigGoodsDTO;
import com.mall.admincenter.client.service.IndexConfigService;
import com.mall.admincenter.service.manager.IndexConfigManager;
import com.mall.common.service.util.PageQueryUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zheng haijain
 * @createTime 2020-04-13 14:29
 * @description
 */
@Service("IndexConfigServiceImpl")
public class IndexConfigServiceImpl implements IndexConfigService {

    @Resource
    private IndexConfigManager indexConfigManager;

    @Override
    public List<IndexConfigDTO> findIndexConfigList(PageQueryUtil pageUtil, Integer configType) {
        if (pageUtil == null ){
            return null;
        }
        return indexConfigManager.findIndexConfigList(pageUtil, configType);
    }

    @Override
    public int getTotalIndexConfigs(PageQueryUtil pageUtil, Integer configType) {
        if (pageUtil == null ){
            return 0;
        }
        return indexConfigManager.getTotalIndexConfigs(pageUtil, configType);
    }

    @Override
    public String saveIndexConfig(IndexConfigDTO indexConfig) {
        if (indexConfig == null){
            return null;
        }
        return indexConfigManager.save(indexConfig);
    }

    @Override
    public String updateIndexConfig(IndexConfigDTO indexConfig) {
        if (indexConfig == null){
            return null;
        }
        return indexConfigManager.update(indexConfig);
    }

    @Override
    public IndexConfigDTO getIndexConfigById(Integer id) {
        if (id < 0){
            return null;
        }
        return indexConfigManager.getIndexConfigById(id);
    }

    @Override
    public Boolean deleteBatch(Integer[] ids) {
        if (ids.length <= 0) {
            return false;
        }
        return indexConfigManager.deleteBatch(ids);
    }

    @Override
    public List<MallIndexConfigGoodsDTO> getConfigGoodsesForIndex(int configType, int number) {
        if (configType < 0 || number < 0 ){
            return null;
        }
        return indexConfigManager.getConfigGoodsesForIndex(configType, number);
    }
}
