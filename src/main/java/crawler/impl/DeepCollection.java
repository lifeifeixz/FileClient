package crawler.impl;

import crawler.test.Scratch;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by flysLi on 2017/9/25.
 * 深度收集资源
 */
@SuppressWarnings("All")
public abstract class DeepCollection implements Scratch {
    @Override
    public String collection(String uri) throws Exception {
        URL url = new URL(uri);
        URLConnection connection = url.openConnection();
        connection.setReadTimeout(5000);
        InputStream inputStream = connection.getInputStream();
        return null;
    }

    @Override
    public String childSource() {
        return null;
    }
}
