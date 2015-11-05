package com.jeefw.model.frame;

import com.jeefw.model.frame.param.OlivesFileParameter;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by zhouyang on 2015/9/23.
 */
public class OlivesFile  extends OlivesFileParameter{

    /**
     * 结果：0 表示成功；1 表示失败
     */
    private int result;

    /**
     * 结果说明
     */
    private String desc;

    /**
     * 上传文件保存路径
     */
    @JsonProperty("file_path")
    private String filePath;

    public OlivesFile(){}

    public OlivesFile(int result, String desc) {
        super();
        this.result = result;
        this.desc = desc;
    }



    public OlivesFile(String filePath) {
        super();
        this.result = 0;
        this.desc = "上传成功";
        this.filePath = filePath;
    }

    public int getResult() {
        return result;
    }
    public void setResult(int result) {
        this.result = result;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }

    @JsonIgnore
    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }

}
