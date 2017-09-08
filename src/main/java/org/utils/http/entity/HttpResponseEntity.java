package org.utils.http.entity;

/**
 * Created by flysLi on 2017/8/28.
 */
public class HttpResponseEntity {

    private int code;

    private String uri;

    private String data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public HttpResponseEntity() {
    }

    public HttpResponseEntity(int code, String uri, String data) {
        this.code = code;
        this.uri = uri;
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
