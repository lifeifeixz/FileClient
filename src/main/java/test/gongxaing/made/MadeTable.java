package test.gongxaing.made;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import test.gongxaing.Field;

import java.io.File;
import java.util.List;

/**
 * 生成table类型
 *
 * @author flysLi
 * @date 2018/3/16
 */
public class MadeTable extends AbstractMadeDefault {
    private static final String TYPE = "-table";

    @Override
    public void make(File file) {
        if (file.getPath().indexOf(TYPE) != -1) {
            List<Field> fields = this.analysis.analysis(file);
            Document template = this.getTemplateByType("table");
            /*抽取模板*/
            Document product = Jsoup.parse(template.outerHtml());
            Element operation = product.getElementsByClass("operation").get(0);
            Element tdTemplate = template.getElementsByClass("td-template").get(0);
            product.getElementsByClass("td-template").get(0).remove();
            for (Field field : fields) {
                Element td = tdTemplate.attr("label", field.getName());
                // TODO: 2018/3/16 因为property字段还没有收到,先待定此功能
                operation.before(td.outerHtml());
            }
            this.out(product.outerHtml());
        } else {
            this.madeStrategy.make(file);
        }
    }

    @Override
    public void setMadeStrategy(MadeStrategy madeStrategy) {
        this.madeStrategy = madeStrategy;
    }
}
