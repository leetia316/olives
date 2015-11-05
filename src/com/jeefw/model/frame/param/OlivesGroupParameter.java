package com.jeefw.model.frame.param;

import core.support.ExtJSBaseParameter;

/**
 * Created by zhouyang on 2015/9/3.
 */
public class OlivesGroupParameter extends ExtJSBaseParameter {

    private static final long serialVersionUID = 7656443663108619135L;


    public String getDictValue() {
        return dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }

    private String dictValue; // 部门名称

}
