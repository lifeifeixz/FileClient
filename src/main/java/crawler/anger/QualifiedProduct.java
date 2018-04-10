package crawler.anger;

/**
 * 过滤原则
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
