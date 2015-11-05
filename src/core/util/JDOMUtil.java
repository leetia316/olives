package core.util;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

/**
 * @author zhouyang
 * <pre>
 *  JDOM XML 操作通用类
 * </pre>
 */
public abstract class JDOMUtil {

    /**
     * @param xmlSource   XML字符串
     * @throws IOException   I/O异常
     * @throws JDOMException XML解释异常
     * <pre>
     * 	从XML格式的字符串获取根节点对象
     * </pre>
     */
    public static Element rootFromString(String xmlSource)
            throws JDOMException, IOException {
        return fromString(xmlSource).getRootElement();
    }

    /**
     * @param xmlSource XML格式字符串
     * @return 返回 Document DOM模型对象
     * <pre>
     * 	从XML格式的字符串获取XML DOM 对象
     * </pre>
     * @throws IOException   I/O异常
     * @throws JDOMException XML解释异常
     */
    public static Document fromString(String xmlSource)
            throws JDOMException, IOException {
        return new SAXBuilder().build(new StringReader(xmlSource));
    }

    /**
     * @param xmlFile XML 文件
     * @return 返回 Document DOM模型对象
     * <pre>
     * 	解释XML文件，获取XML DOM 对象
     * </pre>
     * @throws IOException   I/O异常
     * @throws JDOMException XML解释异常
     */
    public static Document fromFile(File xmlFile)
            throws JDOMException, IOException {
        return new SAXBuilder().build(xmlFile);
    }

    /**
     * @param reader
     * <pre>
     *    从字符串输入流中生成DOM对象
     * </pre>
     */
    public static Document fromReader(Reader reader)
            throws JDOMException, IOException {
        return new SAXBuilder().build(reader);
    }

    /***
     * @param stream
     *  <pre>
     *   从字节输入流中生成DOM对象
     *  </pre>
     */
    public static Document fromStream(InputStream stream)
            throws JDOMException, IOException {
        return new SAXBuilder().build(stream);
    }

    /**
     * @param document 文档对象
     * @param file     写入的文件路径，完整路径（包含文件名）
     * <pre>
     *  将DOM对象写入文件中
     * </pre>
     */
    public static void writeDocument(Document document, File file)
            throws JDOMException, IOException {

    }

    /**
     * @param document xml 文档对象
     *  <pre>
     *    将文档对象转为XML格式的字符串
     *  </pre>
     */
    public static String toString(Document document)
            throws IOException, JDOMException {
        XMLOutputter output = new XMLOutputter();
        output.setFormat(Format.getPrettyFormat());
        return output.outputString(document);
    }
}


