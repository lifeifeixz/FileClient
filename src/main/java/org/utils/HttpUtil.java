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
        String data = "";
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
