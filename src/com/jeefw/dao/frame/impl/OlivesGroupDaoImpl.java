package com.jeefw.dao.frame.impl;

import com.jeefw.dao.frame.OlivesGroupDao;
import com.jeefw.dao.sys.AttachmentDao;
import com.jeefw.model.frame.OlivesGroup;
import com.jeefw.model.sys.Attachment;
import com.jeefw.model.sys.Banner;
import core.dao.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhouyang on 2015/9/18.
 */
@Repository
public class OlivesGroupDaoImpl  extends BaseDao<OlivesGroup> implements OlivesGroupDao {

    @Override
    public List<OlivesGroup> queryByOlivesGroup() {
        return null;
    }

    @Override
    public List<OlivesGroup> queryByTypeOlivesGroup(Integer groupType) {
        return null;
    }

    public OlivesGroupDaoImpl() {
        super(OlivesGroup.class);
    }
}
