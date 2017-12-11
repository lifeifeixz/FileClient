package streetlamp.workers;

import org.generate.entity.Field;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import streetlamp.org.PageMaterial;
import streetlamp.org.annotation.MostNeeder;
import streetlamp.org.entity.FieldType;
import streetlamp.org.entity.Page;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author flysLi
 * @date 2017/12/6
 */
@MostNeeder
public class PageMaterialImpl implements PageMaterial {
    @Override
    public Page analysisPage(String pageData) {
        Page page = new Page();
        Document dom = Jsoup.parse(pageData);
        Element table = dom.getElementsByTag("table").get(0);
        Elements trs = table.getElementsByTag("tbody").get(0).getElementsByTag("tr");
        List<Field> fieldList = new ArrayList();
        for (Element e : trs) {
            Field field = new Field();
            field.setName(e.text());
            if (e.text().indexOf("时间") > -1 || e.text().indexOf("日期") > -1) {
                field.setType(FieldType.DATE.name());
            }
            field.setType(FieldType.STRING.name());
        }
        return null;
    }
}
