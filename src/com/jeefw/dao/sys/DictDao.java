package com.jeefw.dao.sys;

import com.jeefw.model.sys.Dict;

import core.dao.Dao;

import java.util.List;

/**
 * 字典的数据持久层的接口
 * @框架唯一的升级和技术支持地址：http://shop111863449.taobao.com
 */
public interface DictDao extends Dao<Dict> {

    public final static String QUERY_PARENT_ID = "select id,dict_key,dict_value,parent_dictkey,sequence " +
                                                 "from dict " +
                                                 "where parent_dictkey ='?'";

    /**
     * <pre>
     *     根据父ID获取子ID列表
     * </pre>
     * @param parentId
     * @return
     */
    public List<Dict> doQueryParentId(String parentId);
}
