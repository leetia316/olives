package com.jeefw.controller.frame;

import com.jeefw.core.Constant;
import com.jeefw.core.JavaEEFrameworkBaseController;
import com.jeefw.model.frame.OlivesFile;
import com.jeefw.model.frame.OlivesGroup;
import core.util.TimeTool;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhouyang on 2015/9/23.
 */
@Controller
@RequestMapping("/sys/fileUpload")
public class FileUploadController  extends JavaEEFrameworkBaseController<OlivesFile> implements Constant {

    private final static Logger logger= LoggerFactory.getLogger(FileUploadController.class);


    @RequestMapping(value="/{module}/{resType}",method = RequestMethod.POST)
    public @ResponseBody
    Object uploadToTmp(HttpServletRequest request,@PathVariable String module,@PathVariable String resType,@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
        String relPathOfSavedDir=module+"/"+resType+"/";
        try {
            File savedDir = prepareSavedDir(request, relPathOfSavedDir);
            String savedFileName=getSavedFileName(file.getOriginalFilename());
            file.transferTo(new File(savedDir,savedFileName));
            return new OlivesFile(relPathOfSavedDir+savedFileName);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage(), e);
            return new OlivesFile(1,e.getLocalizedMessage());
        }
    }

    @RequestMapping(value="/menu/{resType}/{baseLine}/{org}/{section}",method = RequestMethod.POST)
    public @ResponseBody Object uploadForMenu(HttpServletRequest request,@PathVariable String resType,@PathVariable String baseLine,@PathVariable String org,@PathVariable String section,@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
        String relPathOfSavedDir="menu/"+resType+"/"+baseLine+"/"+org+"/"+section+"/";
        try {
            File savedDir = prepareSavedDir(request, relPathOfSavedDir);
            String savedFileName=getSavedFileName(file.getOriginalFilename());
            file.transferTo(new File(savedDir,savedFileName));
            return new OlivesFile(relPathOfSavedDir+savedFileName);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage(), e);
            return new OlivesFile(1,e.getLocalizedMessage());
        }
    }

    @RequestMapping(value="/app",method = RequestMethod.POST)
    public  @ResponseBody void uploadForApp(HttpServletRequest request, HttpServletResponse response,@RequestParam("defaultIconUpload") MultipartFile file) throws IllegalStateException, IOException {
        String relPathOfSavedDir=request.getParameter("dir")+"/";
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            File savedDir = prepareSavedDir(request, relPathOfSavedDir);
            String savedFileName=getSavedFileName(file.getOriginalFilename());
            file.transferTo(new File(savedDir, savedFileName));
//            return new OlivesFile(relPathOfSavedDir+savedFileName);
            result.put("file_path",relPathOfSavedDir+savedFileName);
            result.put("status", 0);
            writeJSON(response, result);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage(), e);
            result.put("status",1);
            writeJSON(response, result);
        }
    }

    private File prepareSavedDir(HttpServletRequest request,String relativePath) throws Exception{
        File dir=new File(request.getSession().getServletContext().getRealPath("/static/upload/"+relativePath));
        if(!dir.exists()){
            if(!dir.mkdirs()){
                throw new Exception("创建保存目录失败");
            }
        }
        return dir;
    }

    private String getSavedFileName(String origFileName){
        return TimeTool.getFormatNowAll() +"-"+ RandomStringUtils.randomNumeric(5)+"."+ FilenameUtils.getExtension(origFileName);
    }

}
