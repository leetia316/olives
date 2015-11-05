package com.jeefw.dao.sys.impl;

import com.jeefw.dao.sys.BannerDao;
import com.jeefw.model.sys.Banner;
import core.dao.BaseDao;
import org.springframework.stereotype.Repository;

/**
 * Created by zhouyang on 2015/9/3.
 */
@Repository
public class BannerDaoImpl extends BaseDao<Banner> implements BannerDao {

    public BannerDaoImpl() {
        super(Banner.class);
    }
}
