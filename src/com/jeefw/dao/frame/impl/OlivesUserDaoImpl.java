package com.jeefw.dao.frame.impl;

import com.jeefw.dao.frame.OlivesGroupDao;
import com.jeefw.dao.frame.OlivesUserDao;
import com.jeefw.model.frame.OlivesGroup;
import com.jeefw.model.frame.OlivesUser;
import core.dao.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhouyang on 2015/9/18.
 */
@Repository
public class OlivesUserDaoImpl extends BaseDao<OlivesUser> implements OlivesUserDao {



    public OlivesUserDaoImpl() {
        super(OlivesUser.class);
    }

    @Override
    public List<OlivesUser> queryByOlivesUser() {
        return null;
    }
}
