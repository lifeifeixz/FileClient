package crawler.anger;

import crawler.jasiel.Container;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 仓库;
 * 仓库是一个单例
 *
 * @author flysLi
 * @date 2017/10/26
 */
public final class ResourceWarehouse implements Container {
    private Queue<String> links = new LinkedList<>();
    private Set<String> visibles = new HashSet<>();

    public ResourceWarehouse() {
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public synchronized boolean addLink(String l) {
        //如果没有收集过,也没有访问过就加入
        if (!this.links.contains(l) && !this.visibles.contains(l)) {
            return links.offer(l);
        }
        return false;
    }

    @Override
    public synchronized boolean addVisible(String l) {
        /*如果没有收集过，将收集*/
        if (!this.visibles.contains(l)) {
            return visibles.add(l);
        }
        return false;
    }

    @Override
    public synchronized String next() {
        if (links.size() > 0) {
            /*取出之前要在links中删除该元素、记录到visibles中*/
            String link = links.peek();
            this.addVisible(link);
            links.remove(link);
            return link;
        } else {
            throw new RuntimeException("仓库中已经没有可以使用的资源,程序在此时终止");
        }
    }

    @Override
    public boolean isNext() {
        return !this.links.isEmpty();
    }

    public static void main(String[] args) {
        Queue<String> links = new LinkedList<>();
        links.offer("");
        System.out.println(links.isEmpty());
    }

}
