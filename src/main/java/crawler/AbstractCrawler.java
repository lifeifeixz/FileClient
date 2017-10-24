package crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.List;

/**
 * Created by flysLi on 2017/10/23.
 */
public abstract class AbstractCrawler {

    /**
     * 读取远程资源数据
     *
     * @param url 绝对地址
     * @return 资源
     */
    protected final Document document(String url) {
        Document document = null;
        try {
            document = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return document;
    }

    /**
     * 需要使用者完成的部分
     *
     * @param document
     * @return 解析完成的内容
     */
    protected abstract List<Element> analysis(Document document);

    /**
     * 执行
     */
    protected void execute(String uri) {
        List<Element> elements = this.analysis(this.document(uri));
        elements.forEach(element -> System.out.println(element.toString()));
    }
}
