package design.handler;

import design.handler.enity.User;

/**
 * @author flysLi
 * @date 2017/11/2
 * 厨师抽象
 */
public abstract class CookHandler {
    private CookHandler cookHandler;

    /**
     * 处理方法
     *
     * @param user
     */
    public abstract void cook(User user);

    /**
     * 甩锅的方法
     *
     * @param cookHandler
     */
    public void setCookHandler(CookHandler cookHandler) {
        this.cookHandler = cookHandler;
    }

    /**
     * 背锅的方法
     *
     * @return
     */
    public CookHandler getCookHandler() {
        return this.cookHandler;
    }
}
