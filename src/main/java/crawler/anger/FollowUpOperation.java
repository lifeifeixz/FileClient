package crawler.anger;

/**
 * 后续的操作
 *
 * @author flysLi
 * @date 2018/3/19
 */
public interface FollowUpOperation {

    /**
     * 提供一个后续操作的入口
     *
     * @param spoils
     * @return
     */
    Object thing(Spoils spoils);
}
