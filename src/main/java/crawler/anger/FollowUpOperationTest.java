package crawler.anger;

/**
 * @author flysLi
 * @date 2018/3/19
 */
@Compont
public class FollowUpOperationTest implements FollowUpOperation {
    @Override
    public Object thing(Spoils spoils) {
        System.out.println(spoils.getUrl());
        return null;
    }
}
