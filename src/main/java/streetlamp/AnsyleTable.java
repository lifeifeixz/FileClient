package streetlamp;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * @author flysLi
 * @date 2017/12/4
 */
public class AnsyleTable {
    public static void main(String[] args) throws IOException {
        Document dom = Jsoup.parse(new File("D:\\workspace_student\\FileClient\\src\\main\\java\\streetlamp\\files\\table.html"), "UTF-8");
        Element table = dom.getElementsByTag("table").get(0);
        Elements trs = table.getElementsByTag("tbody").get(0).getElementsByTag("tr");
        for (Element e : trs) {
            System.out.println(e.text());
        }
    }
}
