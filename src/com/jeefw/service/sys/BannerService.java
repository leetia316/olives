package com.jeefw.service.sys;

import com.jeefw.model.sys.Banner;
import com.jeefw.model.sys.Dict;
import com.jeefw.model.sys.Information;
import core.service.Service;

import java.util.List;

/**
 * Created by zhouyang on 2015/9/3.
 */
public interface BannerService extends Service<Banner> {


    List<Banner> queryBannerWithSubList(List<Banner> resultList);
}
