package test.gongxaing;

import test.gongxaing.analysis.*;
import test.gongxaing.made.MadeDefault;
import test.gongxaing.made.MadeDetail;
import test.gongxaing.made.MadeStrategy;
import test.gongxaing.made.MadeTable;

/**
 * 提供一些复杂bean的组装
 *
 * @author flysLi
 * @date 2018/3/15
 */
public class BeanFactory {

    /**
     * 获取解析责任链bean
     *
     * @return
     */
    public static Analysis getAnalysisInstance() {
        AbstractAnalysisDefault detailAnalysis = new AnalysisDetailText();
        AbstractAnalysisDefault tableHeaderAnalysis = new AnalysisTableHeader();
        AbstractAnalysisDefault swaggerResult = new AnalysisSwaggerResult();
        AbstractAnalysisDefault analysisDefault = new AnalysisDefault();

        detailAnalysis.setAnalysis(tableHeaderAnalysis);
        tableHeaderAnalysis.setAnalysis(swaggerResult);
        swaggerResult.setAnalysis(analysisDefault);
        return detailAnalysis;
    }

    public static MadeStrategy getMadeStrategyInstance() {
        MadeStrategy detailStrategy = new MadeDetail();
        MadeStrategy tableStrategy = new MadeTable();
        MadeStrategy defaultStrategy = new MadeDefault();

        detailStrategy.setMadeStrategy(tableStrategy);
        tableStrategy.setMadeStrategy(defaultStrategy);
        return detailStrategy;
    }
}
