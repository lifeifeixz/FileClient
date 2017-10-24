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
//        String loginUri = "http://aliyun.88gongxiang.com:8000/api/v1/user/findById?userId=890414102109749248";
//
//            String str = HttpUtil.get(loginUri);
        for (int i = 0; i <= 59; i++) {
            System.out.println("<option value='" + i + "'>" + i + "</option>");
        }
    }
}
