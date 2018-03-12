package crawler.jasiel;

/*
 * 前言:设计之初，JasieLusion 是一条杂乱无章但应有一条固定可循环的生产线、
 * 它负责的做的事情不是很多，是所有。
 * 在使用之后的第二天，我感觉到我有很多的想法想要通过这条生产线实现，
 * 说这句话的意思就是:我需要在这条生产线上加很多的功能。
 * 还没开始写，我就意识到这是一个让人头疼的工程。
 *
 * 现在:在经过半个月的修改之后,我们决定只让它做一件永远重复的事情:
 * 1、从仓库 ResourcesContainer 中取出一条资源路径
 * 2、分析出该资源路径的Document数据
 * 3、交给资源解析器 AnalysisStrategy
 * 4、从 ResourcesContainer 中再取出一条资源路径,来重复以上步骤
 *
 *
 * 作者:fly·Li
 * 目的:在internet中收集数据,更多的是数据对应的地址
 * 时间:2017年11月4日
 *
 */

import crawler.jasiel.strategy.AnalysisStrategy;
import jars.ResourceTransportationUtil;
import org.jsoup.nodes.Document;

/**
 * @author flysLi
 * @date 2017/10/23
 */
@SuppressWarnings("all")
public class JasieLusion {
    private ResourcesContainer resourcesContainer = ResourcesContainer.getInstance();
    private AnalysisStrategy analysisStrategy = new AnalysisDefaultHandler();

    public void start() {
        crawler();
    }

    public void crawler() {
        String link = resourcesContainer.next();
        Document document = null;
        try {
            document = ResourceTransportationUtil.get(link);
            analysisStrategy.ahalysis(document);
        } catch (Exception e) {
            System.out.println(link + "[抓取不到]" + e.getMessage());
        }
        if (!resourcesContainer.isNext()) {
            crawler();
        }
    }
}
