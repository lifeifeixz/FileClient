package crawler;

/**
 * Created by flysLi on 2017/9/25.
 */
@SuppressWarnings("all")
public interface Scratch {

    /**
     * 采集数据
     *
     * @param uri
     * @return
     */
    String collection(String uri) throws Exception;

    /**
     * 分析数据中的数据源
     *
     * @return
     */
    String childSource();
}
