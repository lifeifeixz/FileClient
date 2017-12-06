package streetlamp.org;

import org.utils.file.FileUtil;
import streetlamp.org.entity.Page;
import streetlamp.org.entity.ProductDetails;

import java.io.File;

/**
 * @author flysLi
 * @date 2017/12/6
 */
public abstract class MakeProcess {

    private PageMaterial pageMaterial;
    private Machine machine;
    private Decoration decoration;
    private File productPath;

    /**
     * 制作过程
     *
     * @param sourcePosition
     * @param productPosition
     * @return
     */
    String generate(String sourcePosition, String productPosition) {
        // TODO: 2017/12/6 读取源码数据
        String source = FileUtil.readerString(sourcePosition);
        // TODO: 2017/12/6 解析出生产需要的原材料
        Page page = pageMaterial.analysisPage(source);
        // TODO: 2017/12/6 将材料放进生产线
        String product = machine.make(page);
        // TODO: 2017/12/6 装箱
        ProductDetails productDetail = new ProductDetails();
        productDetail.setContent(product);
        productDetail.setPath(new File(productPosition));
        decoration.packing(productDetail);
        return null;
    }
}
