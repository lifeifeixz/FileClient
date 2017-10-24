package crawler.jasiel;

import crawler.jasiel.filterstrategy.StrategyFilter;
import crawler.jasiel.filterstrategy.TextFilter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

/**
 * @author flysLi
 * @date 2017/10/23
 */
public class JasieLusion {

    private StrategyFilter filter;
    /**
     * 未访问队列
     **/
    private Queue<String> links;
    /**
     * 已访问集合
     **/
    private Set<String> visibles;

    public JasieLusion(StrategyFilter filter) {
        this.links = new LinkedList<>();
        this.visibles = new HashSet<>();
        //实例化构造条件
        this.filter = filter;
    }

    public void crawler() {
        if (this.links.size() > 0) {
            String link = this.links.peek();
            String temp = link;
            this.links.remove(link);
            Document document = null;
            try {
                document = Jsoup.connect(temp).get();
                this.analysisElements(document.getElementsByTag("a"));
            } catch (IOException e) {
                //System.out.println(temp + " :不是一个有效的地址");
            }
        }
        if (this.links.size() > 0) {
            crawler();
        }
    }

    /**
     * 收集指定元素
     *
     * @param elements
     * @return
     */
    public void analysisElements(Elements elements) {
        // 排除未访问和已访问中的该记录
        boolean linkFalg = false;
        boolean visibleFalg = false;
        for (Element element : elements) {
            String href = element.attr("abs:href");
            //未访问
            linkFalg = this.links.contains(href);
            if (linkFalg) {
                continue;
            }
            visibleFalg = this.visibles.contains(href);
            //已访问
            if (visibleFalg) {
                continue;
            }
            if (href.indexOf("http://") == -1) {
                continue;
            }
            if (filter.filter(element)) {
                System.out.println(element.toString());
            }
            this.links.offer(href);
        }
    }

    public void start(String uri) {
        this.links.add(uri);
        this.crawler();
    }

    public static void main(String[] args) {
        JasieLusion jasieLusion = new JasieLusion(new TextFilter("凤凰无双"));
        jasieLusion.start("https://vip.iqiyi.com/firstsix-new-pc.html?fv=43eae339979f37d1c7c83ccbba9945bb");
    }
}
