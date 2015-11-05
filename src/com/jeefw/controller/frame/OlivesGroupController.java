package com.jeefw.controller.frame;

import com.jeefw.core.Constant;
import com.jeefw.core.JavaEEFrameworkBaseController;
import com.jeefw.model.frame.OlivesGroup;
import com.jeefw.model.sys.Banner;
import com.jeefw.model.sys.Dict;
import com.jeefw.service.frame.OlivesGroupService;
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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by zhouyang on 2015/9/3.
 */
@Controller
@RequestMapping("/sys/group")
public class OlivesGroupController extends JavaEEFrameworkBaseController<OlivesGroup> implements Constant {

    @Resource
    private OlivesGroupService olivesGroupService;

    @Resource
    private DictService dictService;

    // 查询字典的表格，包括分页、搜索和排序
    @RequestMapping(value = "/getGroup", method = { RequestMethod.POST, RequestMethod.GET })
    public void getGroup(HttpServletRequest request, HttpServletResponse response,ModelMap module) throws Exception {
        System.out.println("test");
        Integer firstResult = Integer.valueOf(request.getParameter("page"));
        Integer maxResults = Integer.valueOf(request.getParameter("rows"));
        String sortedObject = request.getParameter("sidx");
        String sortedValue = request.getParameter("sord");
        String filters = request.getParameter("filters");
        OlivesGroup groupInfo = new OlivesGroup();
        if (StringUtils.isNotBlank(filters)) {
            JSONObject jsonObject = JSONObject.fromObject(filters);
            JSONArray jsonArray = (JSONArray) jsonObject.get("rules");
//            for (int i = 0; i < jsonArray.size(); i++) {
//                JSONObject result = (JSONObject) jsonArray.get(i);
//                if (result.getString("field").equals("bannerName") && result.getString("op").equals("like")) {
//                    banner.set$like_bannerName(result.getString("data"));
//                }
//            }
//            if (((String) jsonObject.get("groupOp")).equalsIgnoreCase("OR")) {
//                banner.setFlag("OR");
//            } else {
//                banner.setFlag("AND");
//            }
        }
        groupInfo.setFirstResult((firstResult - 1) * maxResults);
        groupInfo.setMaxResults(maxResults);
        Map<String, String> sortedCondition = new HashMap<String, String>();
        sortedCondition.put(sortedObject, sortedValue);
        groupInfo.setSortedConditions(sortedCondition);
        System.out.println(">>" + groupInfo);
        QueryResult<OlivesGroup> queryResult = olivesGroupService.doPaginationQuery(groupInfo);
        JqGridPageView<OlivesGroup> olivesGroupListView = new JqGridPageView<OlivesGroup>();
        olivesGroupListView.setMaxResults(maxResults);
        List<OlivesGroup> olivesGroupsWithSubList = olivesGroupService.queryGroupWithSubList(queryResult.getResultList());
        olivesGroupListView.setRows(olivesGroupsWithSubList);
        olivesGroupListView.setRecords(queryResult.getTotalCount());

        writeJSON(response, olivesGroupListView);
    }


    // 保存字典的实体Bean
    @RequestMapping(value = "/saveGroup", method = { RequestMethod.POST, RequestMethod.GET })
    public void doSave(OlivesGroup entity, HttpServletRequest request, HttpServletResponse response) throws IOException {
        ExtJSBaseParameter parameter = ((ExtJSBaseParameter) entity);
        if (CMD_EDIT.equals(parameter.getCmd())) {
            olivesGroupService.merge(entity);
        } else if (CMD_NEW.equals(parameter.getCmd())) {
            olivesGroupService.persist(entity);
        }
        parameter.setSuccess(true);
        writeJSON(response, parameter);
    }

    // 操作字典的删除、导出Excel、字段判断和保存
    @RequestMapping(value = "/operateGroup", method = { RequestMethod.POST })
    public void operateGroup(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String oper = request.getParameter("oper");
        String id = request.getParameter("id");
        Integer groupSort = new Integer(0);
        if (oper.equals("del")) {
            String[] ids = id.split(",");
            deleteGroup(request, response, (Long[]) ConvertUtils.convert(ids, Long.class));
        }  else {
            Map<String, Object> result = new HashMap<String, Object>();
            String groupName = request.getParameter("groupName");
            String groupType = request.getParameter("groupType");
            String sortInfo = request.getParameter("groupSort");
            if(StringUtils.isNotBlank(sortInfo)){
                groupSort = Integer.parseInt(sortInfo);
            }
            String groupMemo = request.getParameter("groupMemo");
            String groupImg = request.getParameter("groupImg");
            OlivesGroup olivesGroup = null;

            if (oper.equals("edit")) {
                olivesGroup = olivesGroupService.get(Long.valueOf(id));
            }
            OlivesGroup olivesGroupName = olivesGroupService.getByProerties("groupName", groupName);
            if (StringUtils.isBlank(groupName) ) {
                response.setStatus(HttpServletResponse.SC_LENGTH_REQUIRED);
                result.put("message", "请填写讨论组名称");
                writeJSON(response, result);
            } else if (null != olivesGroupName && oper.equals("add")) {
                response.setStatus(HttpServletResponse.SC_CONFLICT);
                result.put("message", "此讨论组名称已存在，请重新输入");
                writeJSON(response, result);
            } else if (null != olivesGroupName && !olivesGroup.getGroupName().equalsIgnoreCase(groupName) && oper.equals("edit")) {
                response.setStatus(HttpServletResponse.SC_CONFLICT);
                result.put("message", "此讨论组名称已存在，请重新输入");
                writeJSON(response, result);
            }  else {
                OlivesGroup entity = new OlivesGroup();
                entity.setGroupName(groupName);
                entity.setGroupType(groupType);
                entity.setGroupMemo(groupMemo);
                entity.setGroupSort(groupSort);
                entity.setGroupImg(groupImg);
                if (StringUtils.isNotBlank(id)) {
                    entity.setId(Long.valueOf(id));
                    entity.setCmd("edit");
                    doSave(entity, request, response);
                } else {
                    entity.setCmd("new");
                    entity.setGroupDate(TimeTool.now());
                    doSave(entity, request, response);
                }
            }
        }
    }

    // 删除字典
    @RequestMapping("/deleteGroup")
    public void deleteGroup(HttpServletRequest request, HttpServletResponse response, @RequestParam("ids") Long[] ids) throws IOException {
        System.out.println(ids);
        boolean flag = olivesGroupService.deleteByPK(ids);
        if (flag) {
            writeJSON(response, "{success:true}");
        } else {
            writeJSON(response, "{success:false}");
        }
    }


    @RequestMapping("/upload2"  )
    public String upload2(HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException {
        //创建一个通用的多部分解析器
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        //判断 request 是否有文件上传,即多部分请求
        if(multipartResolver.isMultipart(request)){
            //转换成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
            //取得request中的所有文件名
            Iterator<String> iter = multiRequest.getFileNames();
            while(iter.hasNext()){
                //记录上传过程起始时的时间，用来计算上传时间
                int pre = (int) System.currentTimeMillis();
                //取得上传文件
                MultipartFile file = multiRequest.getFile(iter.next());
                if(file != null){
                    //取得当前上传文件的文件名称
                    String myFileName = file.getOriginalFilename();
                    //如果名称不为“”,说明该文件存在，否则说明该文件不存在
                    if(myFileName.trim() !=""){
                        System.out.println(myFileName);
                        //重命名上传后的文件名
                        String fileName = "demoUpload" + file.getOriginalFilename();
                        //定义上传路径
                        String path = "H:/" + fileName;
                        File localFile = new File(path);
                        file.transferTo(localFile);
                    }
                }
                //记录上传该文件后的时间
                int finaltime = (int) System.currentTimeMillis();
                System.out.println(finaltime - pre);
            }

        }
        return "success";
    }

}


