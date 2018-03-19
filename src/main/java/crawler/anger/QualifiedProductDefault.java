package crawler.anger;

/**
 * 为保障系统的正常流通，提供一个默认的验证器。
 * 但，该验证其不做任何验证
 *
 * @author flysLi
 * @date 2018/3/19
 */
public class QualifiedProductDefault implements QualifiedProduct {

    /**
     * 验证规则
     *
     * @param url
     * @return
     */
    @Override
    public boolean verification(String url) {
        System.out.println(url);
        return true;
    }
}
