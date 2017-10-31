package word;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author flysLi
 * @date 2017/10/26
 */
public abstract class AbstractXmlReader {

    private Document document;
    private List<Element> elements = new ArrayList<>();

    public Document reader(String path) throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new File("D:\\L临时数据\\word\\33333333.xml"));
        Element root = document.getRootElement();
        this.document = document;
        return document;
    }

    public static void main(String[] args) {

    }

    /**
     * 执行入口
     *
     * @param path
     */
    public void execute(String path) {
        try {
            Document document = this.reader(path);
            Element root = document.getRootElement();
            this.parseList(root);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    /**
     * 递归收集元素的子集
     *
     * @param elem 根元素
     */
    private void parseList(Element elem) {
        Iterator<Node> it = elem.nodeIterator();
        while (it.hasNext()) {
            Node node = it.next();
            if (node instanceof Element) {
                Element e1 = (Element) node;
                this.elements.add(e1);
                parseList(e1);
            }

        }
    }
}
