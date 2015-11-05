package com.jeefw.service.frame.impl;

import com.jeefw.dao.frame.OlivesGroupDao;
import com.jeefw.dao.frame.OlivesUserDao;
import com.jeefw.dao.sys.DictDao;
import com.jeefw.model.frame.OlivesGroup;
import com.jeefw.model.frame.OlivesUser;
import com.jeefw.model.sys.Attachment;
import com.jeefw.model.sys.Dict;
import com.jeefw.model.sys.SysUser;
import com.jeefw.service.frame.OlivesGroupService;
import com.jeefw.service.frame.OlivesUserService;
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
public class OlivesUserServiceImpl extends BaseService<OlivesUser> implements OlivesUserService {

    private OlivesUserDao userDao;

    @Override
    public OlivesUser queryUserInfo(String userName) {
        return userDao.getByProerties("userName",userName);
    }

    @Resource
    public void setUserDao(OlivesUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public OlivesUser queryUserInfo(OlivesUser olivesUser) {
        OlivesUser entity = new OlivesUser();
        entity.setId(olivesUser.getId());
        entity.setUserName(olivesUser.getUserName());
        entity.setUserPass(olivesUser.getUserPass());
        entity.setUserEmail(olivesUser.getUserEmail());
        entity.setUserTel(olivesUser.getUserTel());
        entity.setUserIntroduce(olivesUser.getUserIntroduce());
        entity.setUserImg(olivesUser.getUserImg());
        entity.setUserMemo(olivesUser.getUserMemo());
        entity.setUserSupport(olivesUser.getUserSupport());
        entity.setUesrAttention(olivesUser.getUesrAttention());
        entity.setUserByAttention(olivesUser.getUserByAttention());
        return entity;
    }


}

