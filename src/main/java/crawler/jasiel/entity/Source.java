package crawler.jasiel.entity;

import java.io.Serializable;

/**
 * @author flysLi
 * @date 2017/10/26
 * 源码
 */
public class Source implements Serializable {

    /** 关键字 **/
    private String keyWord;
    /** 资源路径 **/
    private String url;
    /** 摘要 **/
    private String description;

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Source{" +
                "keyWord='" + keyWord + '\'' +
                ", url='" + url + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
