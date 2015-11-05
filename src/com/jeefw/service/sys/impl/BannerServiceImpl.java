package com.jeefw.service.sys.impl;

import com.jeefw.dao.sys.BannerDao;
import com.jeefw.dao.sys.DictDao;
import com.jeefw.model.sys.Banner;
import com.jeefw.model.sys.Dict;
import com.jeefw.service.sys.BannerService;
import com.jeefw.service.sys.DictService;
import core.service.BaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhouyang on 2015/9/3.
 */
@Service
public class BannerServiceImpl extends BaseService<Banner> implements BannerService {

    private BannerDao bannerDao;

    @Resource
    public void setBannerDao(BannerDao bannerDao) {
        this.bannerDao = bannerDao;
        this.dao = bannerDao;
    }

    @Override
    public List<Banner> queryBannerWithSubList(List<Banner> resultList) {
        List<Banner> bannerList = new ArrayList<Banner>();
        for (Banner entity : resultList) {
            Banner banner = new Banner();
            banner.setId(entity.getId());
            banner.setBannerName(entity.getBannerName());
            banner.setBannerSort(entity.getBannerSort());
            banner.setBannerUrl(entity.getBannerUrl());
            banner.setBannerMemo(entity.getBannerMemo());
            bannerList.add(banner);
        }
        return bannerList;
    }
}
