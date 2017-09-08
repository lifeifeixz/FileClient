package org.utils.file;

import com.alibaba.fastjson.JSONArray;
import org.utils.HttpUtil;
import org.utils.file.entity.FileEntity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by flysLi on 2017/8/28.
 */
public class FileCharge {

    private String root;

    private String userName;

    private String project;

    private String fileCharge;

    public String getFileCharge() {
        return fileCharge;
    }

    public void setFileCharge(String fileCharge) {
        this.fileCharge = fileCharge;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public String getProject() {
        return project;
    }

    public FileCharge() {
    }

    public FileCharge(String root, String userName, String project) {
        this.root = root;
        this.project = project;
        this.userName = userName;
        this.fileCharge = this.root + File.separator + this.userName + File.separator + this.project + File.separator + this.project + ".json";
    }

    public void setProject(String project) {
        this.project = project;
    }

    /**
     * 首次创建项目时调用该文件
     *
     * @param fileManagerList
     */
    public void save(List<FileEntity> fileManagerList) {
        String jsonArray = JSONArray.toJSONString(fileManagerList);
        FileUtil.writer(this.getRoot() + File.separator + this.userName + File.separator + this.project + File.separator + this.getProject() + ".json", jsonArray);
    }

    /**
     * 得到文件记录册
     *
     * @return List<FileEntity>
     */
    public List<FileEntity> readLocalCharge() {
        String data = FileUtil.readerString(this.getFileCharge(), "UTF-8");
        FileUtil.log("记录册文件系统信息.json", data);
        return HttpUtil.toEntity(data, FileEntity.class);
    }

    public static void main(String[] args) {
        List<FileEntity> entities = new ArrayList<>();
        FileEntity fileEntity = new FileEntity("你好仨的", "你好仨的", "你好仨的", "你好仨的", "你好仨的", "你好仨的");
        entities.add(fileEntity);
        FileEntity fileEntity2 = new FileEntity("你好仨的2", "你12好仨的", "你好12仨的", "你好仨的", "你好仨的", "你好仨的");

        entities.add(fileEntity2);
        System.out.println("-==========");
    }
}
