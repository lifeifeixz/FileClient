package crawler.anger;

/**
 * 该接口用于验证超链接是否合格
 *
 * @author flysLi
 * @date 2018/3/19
 */
public interface QualifiedProduct {

    /**
     * 超链接的验证规则
     *
     * @param url
     * @return
     */
    boolean verification(String url);
}
