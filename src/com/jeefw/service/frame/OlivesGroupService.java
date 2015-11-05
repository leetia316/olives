package com.jeefw.service.frame;

import com.jeefw.model.frame.OlivesGroup;
import com.jeefw.model.sys.Banner;
import core.service.Service;

import java.util.List;

/**
 * Created by zhouyang on 2015/9/3.
 */
public interface OlivesGroupService extends Service<OlivesGroup> {

    /**
     * <pre>
     *     获取小组分页内容
     * </pre>
     * @param resultList
     * @return
     */
    List<OlivesGroup> queryGroupWithSubList(List<OlivesGroup> resultList);

    /**
     * <pre>
     *     查询所有的小组信息
     * </pre>
     */
    public List<OlivesGroup> queryByOlivesGroup();

    /**
     * <pre>
     *     根据类别查询该类别下所有的小组
     * </pre>
     * @param groupType
     * @return
     */
    public List<OlivesGroup> queryByTypeOlivesGroup(Integer groupType);
}
