package com.jeefw.controller.sys;

import com.jeefw.core.Constant;
import com.jeefw.core.JavaEEFrameworkBaseController;
import com.jeefw.model.frame.OlivesGroup;
import com.jeefw.model.sys.Banner;
import com.jeefw.model.sys.Dict;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhouyang on 2015/9/3.
 */
@Controller
@RequestMapping("/sys/banner")
public class BannerController extends JavaEEFrameworkBaseController<Banner> implements Constant {

    @Resource
    private BannerService bannerService;

    // 查询字典的表格，包括分页、搜索和排序
    @RequestMapping(value = "/getBanner", method = { RequestMethod.POST, RequestMethod.GET })
    public void getDict(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer firstResult = Integer.valueOf(request.getParameter("page"));
        Integer maxResults = Integer.valueOf(request.getParameter("rows"));
        String sortedObject = request.getParameter("sidx");
        String sortedValue = request.getParameter("sord");
        String filters = request.getParameter("filters");
        Banner banner = new Banner();
        if (StringUtils.isNotBlank(filters)) {
            JSONObject jsonObject = JSONObject.fromObject(filters);
            JSONArray jsonArray = (JSONArray) jsonObject.get("rules");
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject result = (JSONObject) jsonArray.get(i);
                if (result.getString("field").equals("bannerName") && result.getString("op").equals("like")) {
                    banner.set$like_bannerName(result.getString("data"));
                }
            }
            if (((String) jsonObject.get("groupOp")).equalsIgnoreCase("OR")) {
                banner.setFlag("OR");
            } else {
                banner.setFlag("AND");
            }
        }
        banner.setFirstResult((firstResult - 1) * maxResults);
        banner.setMaxResults(maxResults);
        Map<String, String> sortedCondition = new HashMap<String, String>();
        sortedCondition.put(sortedObject, sortedValue);
        banner.setSortedConditions(sortedCondition);
        QueryResult<Banner> queryResult = bannerService.doPaginationQuery(banner);
        JqGridPageView<Banner> bannerListView = new JqGridPageView<Banner>();
        bannerListView.setMaxResults(maxResults);
        List<Banner> bannerWithSubList = bannerService.queryBannerWithSubList(queryResult.getResultList());
        bannerListView.setRows(bannerWithSubList);
        bannerListView.setRecords(queryResult.getTotalCount());
        writeJSON(response, bannerListView);
    }

    // 操作字典的删除、导出Excel、字段判断和保存
    @RequestMapping(value = "/operateBanner", method = { RequestMethod.POST })
    public void operateBanner(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String oper = request.getParameter("oper");
        String id = request.getParameter("id");
        Long bannerSort = new Long(0);
        if (oper.equals("del")) {
            String[] ids = id.split(",");
            deleteBanner(request, response, (Long[]) ConvertUtils.convert(ids, Long.class));
        }  else {
            String bannerName = request.getParameter("bannerName");
            String sortInfo = request.getParameter("bannerSort");
            if(StringUtils.isNotBlank(sortInfo)){
                bannerSort = Long.parseLong(sortInfo);
            }
            String bannerMemo = request.getParameter("bannerMemo");
            String bannerImg = request.getParameter("bannerUrl");

            Banner entity = new Banner();
            entity.setBannerName(bannerName);
            entity.setBannerMemo(bannerMemo);
            entity.setBannerSort(bannerSort);
            entity.setBannerUrl(bannerImg);
            if (StringUtils.isNotBlank(id)) {
                entity.setId(Long.valueOf(id));
                entity.setCmd("edit");
                doSave(entity, request, response);
            } else {
                entity.setCmd("new");
                doSave(entity, request, response);
            }
        }
    }

    // 保存字典的实体Bean
    @RequestMapping(value = "/saveBanner", method = { RequestMethod.POST, RequestMethod.GET })
    public void doSave(Banner entity, HttpServletRequest request, HttpServletResponse response) throws IOException {
        ExtJSBaseParameter parameter = ((ExtJSBaseParameter) entity);
        if (CMD_EDIT.equals(parameter.getCmd())) {
            bannerService.merge(entity);
        } else if (CMD_NEW.equals(parameter.getCmd())) {
            bannerService.persist(entity);
        }
        parameter.setSuccess(true);
        writeJSON(response, parameter);
    }


    // 删除字典
    @RequestMapping("/deleteBanner")
    public void deleteBanner(HttpServletRequest request, HttpServletResponse response, @RequestParam("ids") Long[] ids) throws IOException {
        boolean flag = bannerService.deleteByPK(ids);
        if (flag) {
            writeJSON(response, "{success:true}");
        } else {
            writeJSON(response, "{success:false}");
        }
    }

}


