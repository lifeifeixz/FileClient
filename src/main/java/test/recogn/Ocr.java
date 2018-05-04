package test.recogn;

import org.json.JSONObject;

/**
 * 百度AI识别
 *
 * @author flysLi
 * @date 2018/5/3
 */
public interface Ocr {

    /**
     * 文字识别
     *
     * @param bytes
     * @return
     */
    JSONObject recognition(byte[] bytes);
}
