package com.jeefw.dao.frame;

import com.jeefw.model.frame.OlivesGroup;
import com.jeefw.model.frame.OlivesUser;
import core.dao.Dao;

import java.util.List;

/**
 * Created by zhouyang on 2015/9/3.
 */
public interface OlivesUserDao extends Dao<OlivesUser> {


    /**
     * <pre>
     *     查询所有的用户信息
     * </pre>
     */
    public List<OlivesUser> queryByOlivesUser();



}
