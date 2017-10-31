package crawler.jasiel.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by flysLi on 2017/10/27.
 */
@SuppressWarnings("all")
public class RemoteReadUtils {
    public static Document get(String uri) throws Exception {
        URL url = new URL(uri);
        HttpURLConnection httpUrl = (HttpURLConnection) url.openConnection();
        InputStream is = httpUrl.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        is.close();
        br.close();
        return Jsoup.parse(sb.toString());
    }

    public static String reader(String uri) throws Exception {
        URL url = new URL(uri);
        HttpURLConnection httpUrl = (HttpURLConnection) url.openConnection();
        InputStream is = httpUrl.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        is.close();
        br.close();
        return sb.toString();
    }

    public static String read(String path) {
        StringBuilder result = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(path)));//构造一个BufferedReader类来读取文件
            String s = null;
            while ((s = br.readLine()) != null) {//使用readLine方法，一次读一行
                result.append(System.lineSeparator() + s);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    public static void writer(String content, String path) {
        FileOutputStream fop = null;
        File file;
        try {
            file = new File(path);
            fop = new FileOutputStream(file);
            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }
            // get the content in bytes
            byte[] contentInBytes = content.getBytes();
            fop.write(contentInBytes);
            fop.flush();
            fop.close();
            System.out.println("Done");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fop != null) {
                    fop.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        //System.out.println(RemoteReadUtils.readTxt("D:\\L临时数据\\HTML\\amazonIndex.txt"));
//        RemoteReadUtils.writer("哈哈","D:\\L临时数据\\HTML\\test.txt");
//        System.out.println("done");
        System.out.println(RemoteReadUtils.reader("https://www.msn.cn/zh-cn"));
    }
}
