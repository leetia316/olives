package com.jeefw.controller.sys;

import com.jeefw.core.Constant;
import com.jeefw.model.sys.Authority;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.xml.sax.InputSource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhouyang on 2015/10/14.
 */
public class JDomParaseUtil {


    public static  List<Authority> authorityList;

    private static List<Authority> authorityInfoList;

    /**通过单例获取该对象**/
    private static JDomParaseUtil instance = null;

    public static JDomParaseUtil getInstance(){
        if(instance == null){
            instance = new JDomParaseUtil();
        }
        return instance;
    }

    public  List<Authority>  paraseDocumentXml(){
        paraseDocumentXML(Constant.HOME_PAGE_FILE);
        return authorityList;
    }

    /**
     * DOCUMENT格式化输出保存为XML
     *
     * @param filePath 输出文件路径
     * @throws Exception
     */
    public  void paraseDocumentXML(String filePath){
        try {
            // 创建SAX建造者对象，该类构造方法的重载boolean类型的方法中validate表示是否验证xml文档。
            SAXBuilder saxBuilder = new SAXBuilder(false);

            InputStream inputStream = new FileInputStream(new File(filePath));
            // 4、使用InputSource输入源作为参数也可以转换xml
            InputSource inputSource = new InputSource(inputStream);
            // 解析xml文档，返回document文档对象
            Document document = saxBuilder.build(inputSource);
            Element rootElement = document.getRootElement();// 根节点

            // 接下来根据id获取元素 添加子元素或者删除子节点
            List<Element> elementList = rootElement.getChildren(Constant.MENU_XML);
            authorityList = new ArrayList<Authority>();

            /**该方法需要后期优化**/
            paraseHomePage(elementList, "   ");
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * <pre>
     *     调用获取主页菜单
     *    该模块需要后期优化存在严重的性能问题
     * </pre>
     * @param elementList
     * @param f
     */
    public void paraseHomePage(List<Element> elementList, String f){

        for (Element element : elementList) {
            Authority authority = new Authority();
            authority.setParent(Constant.FALSE);
            Element menuElement = element.getChild(Constant.HOMEPAGE_XML);
            if (menuElement!= null) {
                authority.setParent(Constant.TRUE);
                authorityInfoList =  new ArrayList<Authority>();
                for (Element elementInfo :(List<Element>) menuElement.getChildren()) {
                    Authority authorityInfo = new Authority();
                    Element nameElement = elementInfo.getChild(Constant.MENUNAME_XML);
                    if (nameElement != null) {
                        authorityInfo.setMenuName(nameElement.getTextTrim());
                    }

                    Element valueElement = elementInfo.getChild(Constant.MEUNURL_XML);
                    if (valueElement != null) {
                        authorityInfo.setDataUrl(valueElement.getTextTrim());
                    }

                    Element icoElement = elementInfo.getChild(Constant.MENUCLASS_XML);
                    if (icoElement != null) {
                        authorityInfo.setMenuClass(icoElement.getTextTrim());
                    }

                    authorityInfoList.add(authorityInfo);
                    authority.setSubAuthorityList(authorityInfoList);
                }
            }

            Element nameElement = element.getChild(Constant.MENUNAME_XML);
            if (nameElement != null) {
                authority.setMenuName(nameElement.getTextTrim());
            }

            Element valueElement = element.getChild(Constant.MEUNURL_XML);
            if (valueElement != null) {
                authority.setDataUrl(valueElement.getTextTrim());
            }

            Element icoElement = element.getChild(Constant.MENUCLASS_XML);
            if (icoElement != null) {
                authority.setMenuClass(icoElement.getTextTrim());            }
            authorityList.add(authority);
        }
    }

    /**
     * <pre>
     *     获取XML根节点名称
     * </pre>
     * @return
     */
    public Element getElement(String elementKey){
        return new Element(elementKey);
    }

    public static void main(String args[]){
        JDomParaseUtil.getInstance().paraseDocumentXml();

            for(Authority authority : authorityList){
                System.out.println(authority.getParent()+"  "+authority.getMenuName());
                if(authority.getParent().equals(Constant.TRUE)){
                    for(Authority a : authority.getSubAuthorityList()){
                        System.out.println(authority.getParent()+"  "+a.getMenuName());
                    }
                }
            }
    }


}
