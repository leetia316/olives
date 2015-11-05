package com.jeefw.service.frame;

import com.jeefw.model.frame.OlivesGroup;
import com.jeefw.model.frame.OlivesUser;
import core.service.Service;

import java.util.List;

/**
 * Created by zhouyang on 2015/9/3.
 */
public interface OlivesUserService extends Service<OlivesUser> {

    /**
     * <pre>
     *      根据用户信息获取用户信息
     * </pre>
     * @param olivesUser
     * @return
     */
    OlivesUser queryUserInfo(OlivesUser olivesUser);

    OlivesUser queryUserInfo(String userName);

}
