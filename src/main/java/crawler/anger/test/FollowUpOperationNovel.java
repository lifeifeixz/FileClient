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
        System.out.println(spoils.getDocument().title() + " " + spoils.getUrl());
        return null;
    }
}
