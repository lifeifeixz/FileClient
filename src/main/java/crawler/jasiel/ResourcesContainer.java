package crawler.jasiel;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 仓库
 *
 * @author flysLi
 * @date 2017/10/26
 */
public final class ResourcesContainer implements Container {
    /**
     * 未访问队列
     **/
    private Queue<String> links = new LinkedList<>();
    /**
     * 已访问集合
     **/
    private Set<String> visibles = new HashSet<>();

    private ResourcesContainer() {
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    private static class ResourcesContainerHolder {
        private final static ResourcesContainer resourcesContainer = new ResourcesContainer();
    }

    public static ResourcesContainer getInstance() {
        return ResourcesContainerHolder.resourcesContainer;
    }

    @Override
    public synchronized boolean addLink(String l) {
        if (!this.links.contains(l) && !this.visibles.contains(l)) {//如果没有收集过,也没有访问过就加入
            return getInstance().links.offer(l);
        }
        return false;
    }

    @Override
    public synchronized boolean addVisible(String l) {
        //如果没有收集过，将捕收集
        if (!this.visibles.contains(l)) {
            return getInstance().visibles.add(l);
        }
        return false;
    }

    public synchronized String next() {
        if (this.links.size() > 0) {
            //取出之前要在links中删除该元素、记录到visibles中
            String link = this.links.peek();
            this.links.remove(link);
            this.addVisible(link);
            return link;
        } else {
            throw new RuntimeException("仓库中已经没有可以使用的资源,程序在此时终止");
        }
    }

    @Override
    public boolean isNext() {
        return this.links.isEmpty();
    }

    public static void main(String[] args) {
        Queue<String> links = new LinkedList<>();
        links.offer("");
        System.out.println(links.isEmpty());
    }

}
