package com.jeefw.service.frame.impl;

import com.jeefw.dao.frame.OlivesGroupDao;
import com.jeefw.dao.sys.BannerDao;
import com.jeefw.dao.sys.DictDao;
import com.jeefw.model.frame.OlivesGroup;
import com.jeefw.model.sys.Banner;
import com.jeefw.model.sys.Department;
import com.jeefw.model.sys.Dict;
import com.jeefw.service.frame.OlivesGroupService;
import core.service.BaseService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhouyang on 2015/9/18.
 */
@Service
public class OlivesGroupServiceImpl extends BaseService<OlivesGroup> implements OlivesGroupService {

    private OlivesGroupDao groupDao;
    @Resource
    private DictDao dictDao;

    @Resource
    public void setGroupDao(OlivesGroupDao groupDao) {
        this.groupDao = groupDao;
        this.dao = groupDao;
    }

    @Override
    public List<OlivesGroup> queryGroupWithSubList(List<OlivesGroup> resultList) {
        List<OlivesGroup> olivesGroupsList = new ArrayList<OlivesGroup>();
        for (OlivesGroup entity : resultList) {
            OlivesGroup olivesGroup = new OlivesGroup();
            olivesGroup.setId(entity.getId());
            olivesGroup.setGroupName(entity.getGroupName());
            olivesGroup.setGroupAttention(entity.getGroupAttention());
            olivesGroup.setGroupImg(entity.getGroupImg());
            olivesGroup.setGroupMemo(entity.getGroupMemo());
            olivesGroup.setGroupSort(entity.getGroupSort());
            olivesGroup.setGroupType(entity.getGroupType());
            if (StringUtils.isNotBlank(entity.getGroupType())) {
                Dict dict = dictDao.getByProerties("dictKey", entity.getGroupType());
                olivesGroup.setDictValue(dict.getDictValue());
            }
            olivesGroup.setGroupSize(entity.getGroupSize());
            olivesGroup.setGroupDate(entity.getGroupDate());

            olivesGroupsList.add(olivesGroup);
        }
        return olivesGroupsList;
    }

    @Override
    public List<OlivesGroup> queryByOlivesGroup() {
        return groupDao.queryByOlivesGroup();
    }

    @Override
    public List<OlivesGroup> queryByTypeOlivesGroup(Integer groupType) {
        return groupDao.queryByTypeOlivesGroup(groupType);
    }
}

