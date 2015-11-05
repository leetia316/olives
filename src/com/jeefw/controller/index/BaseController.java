package com.jeefw.controller.index;

import com.jeefw.controller.sys.JDomParaseUtil;
import com.jeefw.core.Constant;
import com.jeefw.model.frame.OlivesUser;
import com.jeefw.model.sys.Authority;
import com.jeefw.model.sys.Dict;
import com.jeefw.service.frame.OlivesUserService;
import com.jeefw.service.sys.DictService;
import core.controller.ExtJSBaseController;
import core.support.ExtJSBaseParameter;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by zhouyang on 2015/10/12.
 */
public class BaseController <E extends ExtJSBaseParameter> extends ExtJSBaseController<E> implements Constant {

    @Resource
    private DictService dictService;

    @Resource
    protected OlivesUserService userService;


    private Dict dictInfo ;

    List<Authority> authorityList;

    public List<Authority> getAuthorityList() {
        return authorityList;
    }

    public void setAuthorityList(List<Authority> authorityList) {
        this.authorityList = authorityList;
    }


    public Dict getDictInfo() {
        return dictInfo;
    }

    public void setDictInfo(Dict dictInfo) {
        this.dictInfo = dictInfo;
    }

    public HttpServletRequest getRequest(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }

    public void initData(){
        List<Dict> dictList = dictService.doQueryParentId("PAGE");

        getRequest().setAttribute("dictInfo",dictList);

        String pathInfo = getRequest().getSession().getServletContext().getRealPath("");
        JDomParaseUtil.getInstance().paraseDocumentXML(pathInfo + HOME_PAGE_FILE);
        setAuthorityList(JDomParaseUtil.getInstance().authorityList);
        getRequest().setAttribute(HOME_PAGE_LIST, authorityList);
    }

    public OlivesUser queryOlivesUser(String userName){
        return  userService.getByProerties("userName",userName);
    }
}
