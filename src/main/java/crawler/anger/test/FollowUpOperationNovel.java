package crawler.anger.test;

import crawler.anger.Compont;
import crawler.anger.FollowUpOperation;
import crawler.anger.Spoils;

/**
 * @author flysLi
 * @date 2018/3/20
 */
@Compont
public class FollowUpOperationNovel implements FollowUpOperation {
    @Override
    public Object thing(Spoils spoils) {
        if (spoils.getUrl() != null && spoils.getUrl().indexOf("http://www.jingyu.com/novel") > -1) {
            System.out.println(spoils.getUrl());
        }
        return null;
    }
}
