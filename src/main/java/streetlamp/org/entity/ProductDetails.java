package streetlamp.org.entity;

import java.io.File;

/**
 *
 * @author flysLi
 * @date 2017/12/6
 */
public class ProductDetails {
    private File path;
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public File getPath() {
        return path;
    }

    public void setPath(File path) {
        this.path = path;
    }
}
