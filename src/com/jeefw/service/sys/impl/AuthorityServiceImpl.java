package com.jeefw.service.sys.impl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.jeefw.controller.sys.JDomParaseUtil;
import com.jeefw.core.Constant;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.springframework.stereotype.Service;

import com.jeefw.dao.sys.AuthorityDao;
import com.jeefw.dao.sys.RoleAuthorityDao;
import com.jeefw.model.sys.Authority;
import com.jeefw.model.sys.RoleAuthority;
import com.jeefw.service.sys.AuthorityService;

import core.service.BaseService;

/**
 * 菜单的业务逻辑层的实现
 * @框架唯一的升级和技术支持地址：http://shop111863449.taobao.com
 */
@Service
public class AuthorityServiceImpl extends BaseService<Authority> implements AuthorityService {

	@Resource
	private AuthorityDao authorityDao;
	@Resource
	private RoleAuthorityDao roleAuthorityDao;

	@Resource
	public void setAuthorityDao(AuthorityDao authorityDao) {
		this.authorityDao = authorityDao;
		this.dao = authorityDao;
	}

	// 获取一级菜单和二次菜单

	public List<Authority> queryAllMenuList(String globalRoleKey, List<Authority> mainMenuList) {
		List<RoleAuthority> roleAuthorityList = roleAuthorityDao.queryByProerties("roleKey", globalRoleKey);
		List<String> menuCodeList = new ArrayList<String>();
		for (int j = 0; j < roleAuthorityList.size(); j++) {
			menuCodeList.add(roleAuthorityList.get(j).getMenuCode());
		}
		List<Authority> authorityList = new ArrayList<Authority>();
		for (Authority entity : mainMenuList) {
			Authority authority = new Authority();
			authority.setId(entity.getId());
			authority.setMenuCode(entity.getMenuCode());
			authority.setMenuName(entity.getMenuName());
			authority.setMenuClass(entity.getMenuClass());
			authority.setDataUrl(entity.getDataUrl());
			authority.setSequence(entity.getSequence());
			authority.setParentMenuCode(entity.getParentMenuCode());
			List<Authority> subAuthorityList = authorityDao.queryByProerties("parentMenuCode", entity.getMenuCode());
			List<Authority> resultSubAuthorityList = new ArrayList<Authority>();
			for (int i = 0; i < subAuthorityList.size(); i++) {
				if (menuCodeList.contains(subAuthorityList.get(i).getMenuCode())) {
					resultSubAuthorityList.add(subAuthorityList.get(i));
				}
			}
			authority.setSubAuthorityList(resultSubAuthorityList);
			if (subAuthorityList.size() == 0) {
				authorityList.add(null);
			} else {
				authorityList.add(authority);
			}
		}
		return authorityList;
	}

	@Override
	public List<Authority> queryHomePageList(String homePage) {
		return authorityDao.queryByProerties("parentMenuCode",homePage);
	}

	/**
	 * <pre>
	 *     递归生成树状XML
	 * </pre>
	 * @param authorityList
	 * @return
	 */
	public boolean buildHomePageMenuXml( List<Authority> authorityList){
		Element rootElement = new Element(Constant.HOMEPAGE_XML);
		for(Authority authority : authorityList){
			Element element = new Element(Constant.MENU_XML);
			Element nameElement = new Element(Constant.MENUNAME_XML);
			nameElement.setText(authority.getMenuName());
			Element valueElement = new Element(Constant.MEUNURL_XML);
			valueElement.setText(authority.getDataUrl());
			Element icoElement = new Element(Constant.MENUCLASS_XML);
			icoElement.setText(authority.getMenuClass());
			element.addContent(nameElement);
			element.addContent(valueElement);
			element.addContent(icoElement);
            List<Authority> authoritiesInfoList = this.queryHomePageList(authority.getMenuCode());
            if(authoritiesInfoList != null && authoritiesInfoList.size()>0){
				Element homePage = new Element(Constant.HOMEPAGE_XML);
                for(Authority authorityInfo : authoritiesInfoList) {
                    Element elementInfo = new Element(Constant.MENU_XML);
                    Element nameElementInfo = new Element(Constant.MENUNAME_XML);
                    nameElementInfo.setText(authorityInfo.getMenuName());
                    Element valueElementInfo = new Element(Constant.MEUNURL_XML);
                    valueElementInfo.setText(authorityInfo.getDataUrl());
					Element icoElementInfo = new Element(Constant.MENUCLASS_XML);
					icoElementInfo.setText(authorityInfo.getMenuClass());
					elementInfo.addContent(nameElementInfo);
                    elementInfo.addContent(valueElementInfo);
					elementInfo.addContent(icoElementInfo);
					homePage.addContent(elementInfo);
                }
				element.addContent(homePage);
            }

            rootElement.addContent(element);
		}
		Document document = new Document(rootElement);

		Format format = Format.getCompactFormat();
		format.setEncoding(Constant.PROJECT_ENCODE);
		format.setIndent("     ");

		XMLOutputter xmloutputter = new XMLOutputter(format);
		OutputStream outputStream;
        try {
			String xmlPath = this.getClass().getResource("/").getPath();
            outputStream = new FileOutputStream(xmlPath+"document.xml");
            xmloutputter.output(document, outputStream);
            System.out.println("xml生成成功");
        }catch (Exception ex){
            ex.printStackTrace();
            System.out.println("buildxmlERROR: "+ex.getMessage());
            return false;
        }
		return true;
	}

	public static void main(String args[]){
		AuthorityServiceImpl a = new AuthorityServiceImpl();
		a.buildHomePageMenuXml(null);
	}
}
