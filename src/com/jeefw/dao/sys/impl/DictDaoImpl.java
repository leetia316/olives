package com.jeefw.dao.sys.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.jeefw.dao.sys.DictDao;
import com.jeefw.model.sys.Dict;

import core.dao.BaseDao;

import java.util.List;

/**
 * 字典的数据持久层的实现类
 * @框架唯一的升级和技术支持地址：http://shop111863449.taobao.com
 */
@Repository
public class DictDaoImpl extends BaseDao<Dict> implements DictDao {

	public DictDaoImpl() {
		super(Dict.class);
	}


	@Override
	public List<Dict> doQueryParentId(String parentId) {
		Query query = this.getSession().createQuery("from " + Dict.class.getName() + " u where u.parentDictkey=:parentId order by u.sequence");
		query.setParameter("parentId",parentId);
		List<Dict> dictList = query.list();
		return dictList;
	}
}
