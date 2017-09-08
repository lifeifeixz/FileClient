package org.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.utils.file.entity.FileEntity;
import org.utils.file.json.FSON;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;

/**
 * Created by flysLi on 2017/8/28.
 */
public class HttpUtil {

    /**
     * post请求
     *
     * @param uri
     * @param param
     * @return
     */
    public static Object post(String uri, String param) {

        return null;
    }

    /**
     * get请求
     *
     * @param uri
     * @param params 如果需要传入多个参数,请依次写在map中
     * @return
     */
    public static String get(String uri, Map<String, Object> params) {

        //拼接请求参数
        if (params != null) {
            Set<String> keys = params.keySet();
            int index = 0;
            for (String key : keys) {
                if (index == 0) {
                    uri += "?" + key + "=" + params.get(key);
                } else {
                    uri += "&" + key + params.get(key);
                }
                index++;
            }
        }
        String result = "";

        try {
            // 根据请求地址获取请求
            HttpGet request = new HttpGet(uri);
            //获取当前客户端对象
            HttpClient httpClient = new DefaultHttpClient();
            //通过请求对象获取响应对象
            HttpResponse response = httpClient.execute(request);

            // 判断网络连接状态码是否正常(0--200都数正常)
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                result = EntityUtils.toString(response.getEntity(), "utf-8");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * post请求
     *
     * @param uri
     * @param ps
     * @return
     */
    public static String post(String uri, Map<String, Object> ps) throws Exception {
        String result = null;
        //POST的URL
        HttpPost httppost = new HttpPost(uri);
        //建立HttpPost对象

        Set<String> keys = ps.keySet();
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        for (String key : keys) {
            params.add(new BasicNameValuePair(key, ps.get(key).toString()));
        }
        //添加参数
        httppost.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
        //设置编码
        HttpResponse response = new DefaultHttpClient().execute(httppost);
        //发送Post,并返回一个HttpResponse对象
        if (response.getStatusLine().getStatusCode() == 200) {//如果状态码为200,就是正常返回
            result = EntityUtils.toString(response.getEntity());
        }
        return result;
    }

    /**
     * get请求
     *
     * @param uri
     * @return
     */

    public static String get(String uri) {
        return get(uri, null);
    }

    public static void main(String[] args) throws Exception {
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("userName", "lifeifeixz@sina.cn");
//        map.put("projectName", "user");
//
//        System.out.println(HttpUtil.post("http://localhost:8765/cloud/file/pull", map));
        String data = "[{\"lastUpdateTime\":1503915052787,\"name\":\"user\",\"path\":\"D:\\\\学习\\\\org\\\\lifeifeixz@sina.cn\\\\user\",\"relativePath\":\"lifeifeixz@sina.cn\\\\user\",\"type\":\"folder\",\"version\":1},{\"content\":\"\uFEFF我是i老师\\n\",\"lastUpdateTime\":1503920643613,\"name\":\"build.gradle\",\"path\":\"C:\\\\Users\\\\flysLi\\\\Desktop\\\\temp\\\\L临时数据\\\\lifeifeixz@sina.cn\\\\user\\\\build.gradle\",\"relativePath\":\"lifeifeixz@sina.cn\\\\user\\\\build.gradle\",\"type\":\"file\",\"version\":1},{\"content\":\"itliucheng\\n博客园     新随笔   联系     管理\\nHttpClient发送get post请求和数据解析\\n\\n最近在跟app对接的时候有个业务是微信登录,在这里记录的不是如何一步步操作第三方的,因为是跟app对接,所以一部分代码不是由我写,\\n我只负责处理数据,但是整个微信第三方的流程大致都差不多,app端说要传给我access_token和openid,对用户的处理还是要我去请求微信.\\n这里写一下发送请求以及解析数据的过程来获取用户资料,其他的微信业务再做深究\\n\\n复制代码\\nimport org.apache.http.HttpResponse;\\nimport org.apache.http.client.HttpClient;\\nimport org.apache.http.client.methods.HttpGet;\\nimport org.apache.http.impl.client.DefaultHttpClient;\\nimport org.apache.http.util.EntityUtils;\\n    @RequestMapping(\\\"getWeChatUserInfo\\\")\\n    @ResponseBody\\n    public String getWeChatUserInfo(String token,String openid){\\n        String urlNameString = \\\"https://api.weixin.qq.com/sns/userinfo?access_token=TOKEN&openid=OPENID\\\";\\n        urlNameString=urlNameString.replace(\\\"TOKEN\\\", token);\\n        urlNameString=urlNameString.replace(\\\"OPENID\\\",openid);\\n        String result=\\\"\\\";\\n          try {\\n                // 根据地址获取请求\\n                HttpGet request = new HttpGet(urlNameString);//这里发送get请求\\n                // 获取当前客户端对象\\n                HttpClient httpClient = new DefaultHttpClient();\\n                // 通过请求对象获取响应对象\\n                HttpResponse response = httpClient.execute(request);\\n                \\n                // 判断网络连接状态码是否正常(0--200都数正常)\\n                if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {\\n                    result= EntityUtils.toString(response.getEntity(),\\\"utf-8\\\");\\n                } \\n            } catch (Exception e) {\\n                // TODO Auto-generated catch block\\n                e.printStackTrace();\\n            }\\n        return result;\\n        //....result是用户信息,站内业务以及具体的json转换这里也不写了...\\n    }\\n复制代码\\n其中result打印出来是:\\n\\n复制代码\\n{\\nopenid: \\\"oIy1SuJhhc6Fk6z*****ecjrzySY\\\",\\nnickname: \\\"小丑\\\",\\nsex: 1,\\nlanguage: \\\"zh_CN\\\",\\ncity: \\\"海淀\\\",\\nprovince: \\\"北京\\\",\\ncountry: \\\"中国\\\",\\nheadimgurl: \\\"http://wx.qlogo.cn/mmopen/WtXTficAHyjWBgHZX2Yf*****LK2CV9yLeiaHxKK8dhZshQgYeJEamaibT0UHQLicCfeBh698pJLc30Hrr6COHBqAKIj2rVQn3qKZ/0\\\",\\nprivilege: [ ],\\nunionid: \\\"oK8SLt5GNKgJwPlL0JEST93***TQ\\\"\\n}\\n复制代码\\n-----------------------------------------------------------\\n延伸:\\n\\nApache也有一个发送post请求的方法:\\n\\n复制代码\\nString url=\\\"http://XXX..\\\";\\n//POST的URL\\nHttpPost httppost=new HttpPost(url);\\n//建立HttpPost对象\\nList<NameValuePair> params=new ArrayList<NameValuePair>();\\n//建立一个NameValuePair数组，用于存储欲传送的参数\\nparams.add(new BasicNameValuePair(\\\"pwd\\\",\\\"2544\\\"));\\n//添加参数\\nhttppost.setEntity(new UrlEncodedFormEntity(params,HTTP.UTF_8));\\n//设置编码\\nHttpResponse response=new DefaultHttpClient().execute(httppost);\\n//发送Post,并返回一个HttpResponse对象\\nif(response.getStatusLine().getStatusCode()==200){//如果状态码为200,就是正常返回\\nString result=EntityUtils.toString(response.getEntity());\\n复制代码\\n以上的Apache Client的get post方法发送请求在java中其实已经有内置了,只不过代码稍复杂了一些\\n\\n比如发送get请求\\n\\n复制代码\\nimport java.io.BufferedReader;\\nimport java.io.IOException;\\nimport java.io.InputStreamReader;\\nimport java.io.PrintWriter;\\nimport java.net.URL;\\nimport java.net.URLConnection;\\nimport java.util.List;\\nimport java.util.Map;\\n\\npublic class HttpRequest {\\n    /**\\n     * 向指定URL发送GET方法的请求\\n     * \\n     * @param url\\n     *            发送请求的URL\\n     * @param param\\n     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。\\n     * @return URL 所代表远程资源的响应结果\\n     */\\n    public static String sendGet(String url, String param) {\\n        String result = \\\"\\\";\\n        BufferedReader in = null;\\n        try {\\n            String urlNameString = url + \\\"?\\\" + param;\\n            URL realUrl = new URL(urlNameString);\\n            // 打开和URL之间的连接\\n            URLConnection connection = realUrl.openConnection();\\n            // 设置通用的请求属性\\n            connection.setRequestProperty(\\\"accept\\\", \\\"*/*\\\");\\n            connection.setRequestProperty(\\\"connection\\\", \\\"Keep-Alive\\\");\\n            connection.setRequestProperty(\\\"user-agent\\\",\\n                    \\\"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)\\\");\\n            // 建立实际的连接\\n            connection.connect();\\n            // 获取所有响应头字段\\n            Map<String, List<String>> map = connection.getHeaderFields();\\n            // 遍历所有的响应头字段\\n            for (String key : map.keySet()) {\\n                System.out.println(key + \\\"--->\\\" + map.get(key));\\n            }\\n            // 定义 BufferedReader输入流来读取URL的响应\\n            in = new BufferedReader(new InputStreamReader(\\n                    connection.getInputStream(),\\\"utf-8\\\"));//防止乱码\\n            String line;\\n            while ((line = in.readLine()) != null) {\\n                result += line;\\n            }\\n        } catch (Exception e) {\\n            System.out.println(\\\"发送GET请求出现异常！\\\" + e);\\n            e.printStackTrace();\\n        }\\n        // 使用finally块来关闭输入流\\n        finally {\\n            try {\\n                if (in != null) {\\n                    in.close();\\n                }\\n            } catch (Exception e2) {\\n                e2.printStackTrace();\\n            }\\n        }\\n        return result;\\n    }\\n复制代码\\n发送post请求\\n\\n复制代码\\n /**\\n     * 向指定 URL 发送POST方法的请求\\n     * \\n     * @param url\\n     *            发送请求的 URL\\n     * @param param\\n     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。\\n     * @return 所代表远程资源的响应结果\\n     */\\n    public static String sendPost(String url, String param) {\\n        PrintWriter out = null;\\n        BufferedReader in = null;\\n        String result = \\\"\\\";\\n        try {\\n            URL realUrl = new URL(url);\\n            // 打开和URL之间的连接\\n            URLConnection conn = realUrl.openConnection();\\n            // 设置通用的请求属性\\n            conn.setRequestProperty(\\\"accept\\\", \\\"*/*\\\");\\n            conn.setRequestProperty(\\\"connection\\\", \\\"Keep-Alive\\\");\\n            conn.setRequestProperty(\\\"user-agent\\\",\\n                    \\\"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)\\\");\\n            // 发送POST请求必须设置如下两行\\n            conn.setDoOutput(true);\\n            conn.setDoInput(true);\\n            // 获取URLConnection对象对应的输出流\\n            out = new PrintWriter(conn.getOutputStream());\\n            // 发送请求参数\\n            out.print(param);\\n            // flush输出流的缓冲\\n            out.flush();\\n            // 定义BufferedReader输入流来读取URL的响应\\n            in = new BufferedReader(\\n                    new InputStreamReader(conn.getInputStream(),\\\"utf-8\\\"));\\n            String line;\\n            while ((line = in.readLine()) != null) {\\n                result += line;\\n            }\\n        } catch (Exception e) {\\n            System.out.println(\\\"发送 POST 请求出现异常！\\\"+e);\\n            e.printStackTrace();\\n        }\\n        //使用finally块来关闭输出流、输入流\\n        finally{\\n            try{\\n                if(out!=null){\\n                    out.close();\\n                }\\n                if(in!=null){\\n                    in.close();\\n                }\\n            }\\n            catch(IOException ex){\\n                ex.printStackTrace();\\n            }\\n        }\\n        return result;\\n    }    \\n}\\n复制代码\\n \\n\\n分类: java\\n标签: HttpClient发送post get请求, java发送post get请求, response解析\\n好文要顶 关注我 收藏该文    \\nitliucheng\\n关注 - 8\\n粉丝 - 15\\n+加关注\\n1 0\\n« 上一篇：python正则表达式\\n» 下一篇：centOS 安装mysql\\nposted on 2015-12-22 09:38 itliucheng 阅读(39110) 评论(0) 编辑 收藏\\n刷新评论刷新页面返回顶部\\n注册用户登录后才能发表评论，请 登录 或 注册，访问网站首页。\\n最新IT新闻:\\n· Switch系统代码曝光「VR 模式」，任天堂或为VR游戏做准备\\n· 车祸频发 上海警方约谈饿了么等8家外卖企业\\n· 苹果App Store又讨好中国用户，继支付宝后本周将支持微信支付\\n· 马斯克将一辆Model S放进了Boring Company的地下测试隧道\\n· 英国拉纳克郡多家医院再遭黑客网络攻击 职工排班和电话系统瘫痪\\n» 更多新闻...\\n最新知识库文章:\\n· 做到这一点，你也可以成为优秀的程序员\\n· 写给立志做码农的大学生\\n· 架构腐化之谜\\n· 学会思考，而不只是编程\\n· 编写Shell脚本的最佳实践\\n» 更多知识库文章...\\n昵称：itliucheng\\n园龄：2年8个月\\n粉丝：15\\n关注：8\\n+加关注\\n<\\t2017年8月\\t>\\n日\\t一\\t二\\t三\\t四\\t五\\t六\\n30\\t31\\t1\\t2\\t3\\t4\\t5\\n6\\t7\\t8\\t9\\t10\\t11\\t12\\n13\\t14\\t15\\t16\\t17\\t18\\t19\\n20\\t21\\t22\\t23\\t24\\t25\\t26\\n27\\t28\\t29\\t30\\t31\\t1\\t2\\n3\\t4\\t5\\t6\\t7\\t8\\t9\\n\\n我的标签\\n\\njava selenium(4)\\nselenium(4)\\nselenium webdriver(4)\\nseleniumIDE(4)\\nwebdriver(4)\\n设计模式(4)\\n适配器模式(1)\\n通配符与正则表达式的区别 linux 通配符 正则表达式(1)\\n微博登录(1)\\n栈(1)\\n更多\\n随笔分类\\n\\ndocker(5)\\ngit(1)\\nhibernate(12)\\njava(22)\\njava设计模式(8)\\njs(10)\\nlinux(16)\\nmybatis(3)\\npython(6)\\nselenium(4)\\nsolr(13)\\nspring(8)\\nspringMVC(3)\\nstruts(10)\\n积分与排名\\n积分 - 27541\\n排名 - 11680\\n阅读排行榜\\n\\n1. HttpClient发送get post请求和数据解析(39110)\\n2. window.opener方法的使用 js跨域(4999)\\n3. java selenium webdriver第四讲 应用小结(4822)\\n4. 身份验证cookies和Token(3399)\\n5. spring的定时执行代码 跑批(2551)\\n评论排行榜\\n\\n1. window.opener方法的使用 js跨域(4)\\n2. spring的定时执行代码 跑批(4)\\n3. 定时器(2)\\n4. 二叉查找树(2)\\n5. Socket 基础解析使用ServerSocket建立聊天服务器(2)\\nPowered by: 博客园\\t模板提供：沪江博客 Copyright ©2017 itliucheng\\n\",\"lastUpdateTime\":1503920643629,\"name\":\"setting.build\",\"path\":\"C:\\\\Users\\\\flysLi\\\\Desktop\\\\temp\\\\L临时数据\\\\lifeifeixz@sina.cn\\\\user\\\\setting.build\",\"relativePath\":\"lifeifeixz@sina.cn\\\\user\\\\setting.build\",\"type\":\"file\",\"version\":1},{\"content\":\"\",\"lastUpdateTime\":1503920643630,\"name\":\"setting.build.bak\",\"path\":\"C:\\\\Users\\\\flysLi\\\\Desktop\\\\temp\\\\L临时数据\\\\lifeifeixz@sina.cn\\\\user\\\\setting.build.bak\",\"relativePath\":\"lifeifeixz@sina.cn\\\\user\\\\setting.build.bak\",\"type\":\"file\",\"version\":1},{\"lastUpdateTime\":1503914716964,\"name\":\"src\",\"path\":\"D:\\\\学习\\\\org\\\\lifeifeixz@sina.cn\\\\user\\\\src\",\"relativePath\":\"lifeifeixz@sina.cn\\\\user\\\\src\",\"type\":\"folder\",\"version\":1},{\"lastUpdateTime\":1503914716959,\"name\":\"main\",\"path\":\"D:\\\\学习\\\\org\\\\lifeifeixz@sina.cn\\\\user\\\\src\\\\main\",\"relativePath\":\"lifeifeixz@sina.cn\\\\user\\\\src\\\\main\",\"type\":\"folder\",\"version\":1},{\"lastUpdateTime\":1503914716960,\"name\":\"java\",\"path\":\"D:\\\\学习\\\\org\\\\lifeifeixz@sina.cn\\\\user\\\\src\\\\main\\\\java\",\"relativePath\":\"lifeifeixz@sina.cn\\\\user\\\\src\\\\main\\\\java\",\"type\":\"folder\",\"version\":1},{\"content\":\"package org.utils.file;\\n\\nimport com.alibaba.fastjson.JSONArray;\\n\\nimport java.io.*;\\n\\n/**\\n * Created by flysLi on 2017/8/28.\\n */\\npublic class FileUtil {\\n\\n    /**\\n     * ���ܴ���һ���ļ�\\n     *\\n     * @param path\\n     */\\n    public static void maybeNewFile(String path) {\\n        File file = new File(path);\\n        file.mkdir();\\n    }\\n\\n    /**\\n     * �����ļ�\\n     *\\n     * @param path\\n     * @param content\\n     */\\n    public static void initData(String path, String content) {\\n\\n    }\\n\\n    /**\\n     * ���봴��һ���ļ�\\n     *\\n     * @param path\\n     */\\n    public static void mustNewFile(String path) {\\n        File file = new File(path);\\n        if (file.exists()) {\\n            file.mkdir();\\n        }\\n    }\\n\\n    /**\\n     * д���ļ���������\\n     *\\n     * @param path ·��\\n     * @param data Ҫ���������\\n     */\\n    public static int writer(String path, String data) {\\n\\n        //�ж�·���Ƿ����\\n        File file = new File(path.substring(0, path.lastIndexOf(File.separatorChar)));\\n        if (!file.isDirectory() && !file.isFile()) {\\n            file.mkdirs();\\n        }\\n\\n        if (data == null) {\\n            return 0;\\n        }\\n\\n        File f = new File(path);\\n        OutputStream out = null;\\n\\n        try {\\n            out = new FileOutputStream(f);\\n        } catch (FileNotFoundException e) {\\n            e.printStackTrace();\\n        }\\n        //���ַ���ת�����ֽ�����\\n        byte[] b = data.getBytes();\\n\\n        try {\\n            out.write(b);\\n        } catch (IOException e) {\\n            e.printStackTrace();\\n        }\\n\\n        try {\\n            out.close();\\n        } catch (IOException e) {\\n            e.printStackTrace();\\n        }\\n\\n        return b.length;\\n    }\\n\\n\\n    public static void main(String[] args) {\\n        String str = \\\"[\\\\n\\\" +\\n                \\\"    {\\\\n\\\" +\\n                \\\"        \\\\\\\"id\\\\\\\": \\\\\\\"\\\\\\\",\\\\n\\\" +\\n                \\\"        \\\\\\\"name\\\\\\\": \\\\\\\"build.gradle\\\\\\\",\\\\n\\\" +\\n                \\\"        \\\\\\\"lastUpdateTime\\\\\\\": null,\\\\n\\\" +\\n                \\\"        \\\\\\\"path\\\\\\\": \\\\\\\"D:\\\\\\\\\\\\\\\\ѧϰ\\\\\\\\\\\\\\\\org\\\\\\\\\\\\\\\\lifeifeixz@sina.cn\\\\\\\\\\\\\\\\user\\\\\\\\\\\\\\\\build.gradle\\\\\\\",\\\\n\\\" +\\n                \\\"        \\\\\\\"parentPath\\\\\\\": null,\\\\n\\\" +\\n                \\\"        \\\\\\\"type\\\\\\\": \\\\\\\"file\\\\\\\",\\\\n\\\" +\\n                \\\"        \\\\\\\"version\\\\\\\": 0\\\\n\\\" +\\n                \\\"    },\\\\n\\\" +\\n                \\\"    {\\\\n\\\" +\\n                \\\"        \\\\\\\"id\\\\\\\": \\\\\\\"\\\\\\\",\\\\n\\\" +\\n                \\\"        \\\\\\\"name\\\\\\\": \\\\\\\"src\\\\\\\",\\\\n\\\" +\\n                \\\"        \\\\\\\"lastUpdateTime\\\\\\\": null,\\\\n\\\" +\\n                \\\"        \\\\\\\"path\\\\\\\": \\\\\\\"D:\\\\\\\\\\\\\\\\ѧϰ\\\\\\\\\\\\\\\\org\\\\\\\\\\\\\\\\lifeifeixz@sina.cn\\\\\\\\\\\\\\\\user\\\\\\\\\\\\\\\\src\\\\\\\",\\\\n\\\" +\\n                \\\"        \\\\\\\"parentPath\\\\\\\": null,\\\\n\\\" +\\n                \\\"        \\\\\\\"type\\\\\\\": \\\\\\\"folder\\\\\\\",\\\\n\\\" +\\n                \\\"        \\\\\\\"version\\\\\\\": 0\\\\n\\\" +\\n                \\\"    },\\\\n\\\" +\\n                \\\"    {\\\\n\\\" +\\n                \\\"        \\\\\\\"id\\\\\\\": \\\\\\\"\\\\\\\",\\\\n\\\" +\\n                \\\"        \\\\\\\"name\\\\\\\": \\\\\\\"main\\\\\\\",\\\\n\\\" +\\n                \\\"        \\\\\\\"lastUpdateTime\\\\\\\": null,\\\\n\\\" +\\n                \\\"        \\\\\\\"path\\\\\\\": \\\\\\\"D:\\\\\\\\\\\\\\\\ѧϰ\\\\\\\\\\\\\\\\org\\\\\\\\\\\\\\\\lifeifeixz@sina.cn\\\\\\\\\\\\\\\\user\\\\\\\\\\\\\\\\src\\\\\\\\\\\\\\\\main\\\\\\\",\\\\n\\\" +\\n                \\\"        \\\\\\\"parentPath\\\\\\\": null,\\\\n\\\" +\\n                \\\"        \\\\\\\"type\\\\\\\": \\\\\\\"folder\\\\\\\",\\\\n\\\" +\\n                \\\"        \\\\\\\"version\\\\\\\": 0\\\\n\\\" +\\n                \\\"    },\\\\n\\\" +\\n                \\\"    {\\\\n\\\" +\\n                \\\"        \\\\\\\"id\\\\\\\": \\\\\\\"\\\\\\\",\\\\n\\\" +\\n                \\\"        \\\\\\\"name\\\\\\\": \\\\\\\"java\\\\\\\",\\\\n\\\" +\\n                \\\"        \\\\\\\"lastUpdateTime\\\\\\\": null,\\\\n\\\" +\\n                \\\"        \\\\\\\"path\\\\\\\": \\\\\\\"D:\\\\\\\\\\\\\\\\ѧϰ\\\\\\\\\\\\\\\\org\\\\\\\\\\\\\\\\lifeifeixz@sina.cn\\\\\\\\\\\\\\\\user\\\\\\\\\\\\\\\\src\\\\\\\\\\\\\\\\main\\\\\\\\\\\\\\\\java\\\\\\\",\\\\n\\\" +\\n                \\\"        \\\\\\\"parentPath\\\\\\\": null,\\\\n\\\" +\\n                \\\"        \\\\\\\"type\\\\\\\": \\\\\\\"folder\\\\\\\",\\\\n\\\" +\\n                \\\"        \\\\\\\"version\\\\\\\": 0\\\\n\\\" +\\n                \\\"    },\\\\n\\\" +\\n                \\\"    {\\\\n\\\" +\\n                \\\"        \\\\\\\"id\\\\\\\": \\\\\\\"\\\\\\\",\\\\n\\\" +\\n                \\\"        \\\\\\\"name\\\\\\\": \\\\\\\"demo.java\\\\\\\",\\\\n\\\" +\\n                \\\"        \\\\\\\"lastUpdateTime\\\\\\\": null,\\\\n\\\" +\\n                \\\"        \\\\\\\"path\\\\\\\": \\\\\\\"D:\\\\\\\\\\\\\\\\ѧϰ\\\\\\\\\\\\\\\\org\\\\\\\\\\\\\\\\lifeifeixz@sina.cn\\\\\\\\\\\\\\\\user\\\\\\\\\\\\\\\\src\\\\\\\\\\\\\\\\main\\\\\\\\\\\\\\\\java\\\\\\\\\\\\\\\\demo.java\\\\\\\",\\\\n\\\" +\\n                \\\"        \\\\\\\"parentPath\\\\\\\": null,\\\\n\\\" +\\n                \\\"        \\\\\\\"type\\\\\\\": \\\\\\\"file\\\\\\\",\\\\n\\\" +\\n                \\\"        \\\\\\\"version\\\\\\\": 0\\\\n\\\" +\\n                \\\"    }\\\\n\\\" +\\n                \\\"]\\\";\\n        JSONArray jsonArray = JSONArray.parseArray(str);\\n        System.out.println(jsonArray.size());\\n    }\\n}\\n\",\"lastUpdateTime\":1503920643632,\"name\":\"demo.java\",\"path\":\"C:\\\\Users\\\\flysLi\\\\Desktop\\\\temp\\\\L临时数据\\\\lifeifeixz@sina.cn\\\\user\\\\src\\\\main\\\\java\\\\demo.java\",\"relativePath\":\"lifeifeixz@sina.cn\\\\user\\\\src\\\\main\\\\java\\\\demo.java\",\"type\":\"file\",\"version\":1},{\"lastUpdateTime\":1503915052790,\"name\":\"resources\",\"path\":\"D:\\\\学习\\\\org\\\\lifeifeixz@sina.cn\\\\user\\\\src\\\\resources\",\"relativePath\":\"lifeifeixz@sina.cn\\\\user\\\\src\\\\resources\",\"type\":\"folder\",\"version\":1},{\"content\":\"\",\"lastUpdateTime\":1503920643633,\"name\":\"application.yml.bak\",\"path\":\"C:\\\\Users\\\\flysLi\\\\Desktop\\\\temp\\\\L临时数据\\\\lifeifeixz@sina.cn\\\\user\\\\src\\\\resources\\\\application.yml.bak\",\"relativePath\":\"lifeifeixz@sina.cn\\\\user\\\\src\\\\resources\\\\application.yml.bak\",\"type\":\"file\",\"version\":1},{\"content\":\"server.port:9009\\n\",\"lastUpdateTime\":1503920643635,\"name\":\"新建文本文档.txt\",\"path\":\"C:\\\\Users\\\\flysLi\\\\Desktop\\\\temp\\\\L临时数据\\\\lifeifeixz@sina.cn\\\\user\\\\src\\\\resources\\\\新建文本文档.txt\",\"relativePath\":\"lifeifeixz@sina.cn\\\\user\\\\src\\\\resources\\\\新建文本文档.txt\",\"type\":\"file\",\"version\":1}]";
        List<FileEntity> fileEntities = toEntity(data, FileEntity.class);
        for (FileEntity fileEntity : fileEntities) {
            System.out.println(fileEntity.toString());
        }
    }

    public static <T> List<T> toEntity(String data, Class<T> cls) {
        JSONObject jsonObject = null;
        JSONArray jsonArray = null;
        List<T> list = new ArrayList<T>();
        if (data != null) {
            jsonArray = JSONObject.parseArray(data);
        }
        Field[] fields = cls.getDeclaredFields();
        for (int i = 0; i < jsonArray.size(); i++) {
            jsonObject = jsonArray.getJSONObject(i);
            //创建一个对象
            Object obj = null;
            try {
                obj = cls.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            //遍历所有的属性,并给其赋值
            for (Field field : fields) {
                try {
                    field.setAccessible(true);
                    Object val = jsonObject.get(field.getName());
                    if (val != null) {
                        field.set(obj, val);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            list.add((T) obj);
        }


        //List<T> arrLt = new ArrayList<>();
        return list;
    }


}
