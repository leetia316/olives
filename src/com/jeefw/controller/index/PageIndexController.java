package com.jeefw.controller.index;

import com.jeefw.controller.sys.JDomParaseUtil;
import com.jeefw.core.Constant;
import com.jeefw.core.JavaEEFrameworkBaseController;
import com.jeefw.model.frame.OlivesGroup;
import com.jeefw.model.frame.OlivesUser;
import com.jeefw.model.sys.Authority;
import com.jeefw.model.sys.Banner;
import com.jeefw.model.sys.Dict;
import com.jeefw.service.frame.OlivesGroupService;
import com.jeefw.service.frame.OlivesUserService;
import com.jeefw.service.sys.BannerService;
import com.jeefw.service.sys.DictService;
import core.support.ExtJSBaseParameter;
import core.support.JqGridPageView;
import core.support.QueryResult;
import core.util.TimeTool;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by zhouyang on 2015/9/3.
 */
@Controller
@RequestMapping("/page")
public class PageIndexController extends BaseController{


    @Resource
    private BannerService bannerService;




    public List<Banner> getBannerList() {
        return bannerList;
    }

    public void setBannerList(List<Banner> bannerList) {
        this.bannerList = bannerList;
    }

    List<Banner> bannerList;



    // 查询字典的表格，包括分页、搜索和排序
    @RequestMapping(value = "/index", method = { RequestMethod.POST, RequestMethod.GET })
    public String pageIndex(HttpServletRequest request, HttpServletResponse response,Model model) throws Exception {
        initData();
        bannerService.getByProerties("bannerName","ddddd");
        bannerList = bannerService.doQueryAll();
        model.addAttribute(BANNER_LIST,bannerList);
        return RETURN_INDEX;
    }

    // 查询字典的表格，包括分页、搜索和排序
    @RequestMapping(value = "/community", method = { RequestMethod.POST, RequestMethod.GET })
    public String pageCommunity(HttpServletRequest request, HttpServletResponse response,Model model) throws Exception {
        initData();
        return RETURN_COMMUNITY;
    }


    @RequestMapping(value = "/register", method = { RequestMethod.POST, RequestMethod.GET })
    public String pageRegister(HttpServletRequest request, HttpServletResponse response,Model model) throws Exception {
        initData();
        return RETURN_REGISGTER;
    }

    @RequestMapping(value = "/exist", method = { RequestMethod.POST, RequestMethod.GET })
    public void pageIsNameExist(HttpServletRequest request, HttpServletResponse response,@RequestParam("userName") String userName) throws IOException {
        OlivesUser userInfo = userService.queryUserInfo(userName);
        if (userInfo == null) {
            writeJSON(response, "true");
        } else {
            writeJSON(response, "false");
        }
    }


}


