package org.file.client.workers;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;
import org.utils.HttpUtil;
import org.utils.file.FileCharge;
import org.utils.file.FileUtil;
import org.utils.file.entity.FileEntity;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by flysLi on 2017/8/28.
 */
@SuppressWarnings("all")
@Component
public class FileManager {

    /**
     * 下载文件到硬盘
     *
     * @param jsonStr
     */
    public static List<FileEntity> initFile(String jsonStr, String root, String project) {

        List<FileEntity> fileEntities = HttpUtil.toEntity(jsonStr, FileEntity.class);
        for (int i = 0; i < fileEntities.size(); i++) {
            FileEntity fileEntity = fileEntities.get(i);
            if (fileEntity.getType().equals(FileEntity.FOLDER)) {
                File f = FileUtil.mustNewFile(fileEntity.getPath());
                fileEntities.get(i).setLastUpdateTime(f.lastModified());
                fileEntities.get(i).setPath(f.getPath());
                fileEntities.get(i).setVersion(1);
                fileEntities.get(i).setType(FileEntity.FOLDER);
            } else if (fileEntity.getType().equals(FileEntity.FILE)) {
                File f = FileUtil.writer(root + File.separator + fileEntity.getRelativePath(), fileEntity.getContent());
                fileEntities.get(i).setLastUpdateTime(f.lastModified());
                fileEntities.get(i).setPath(f.getPath());
                fileEntities.get(i).setVersion(1);
                fileEntities.get(i).setType(FileEntity.FILE);
            }
            fileEntities.get(i).setContent(null);
        }
        return fileEntities;
    }

    /**
     * 下载代码
     *
     * @param userName
     * @param projectName
     * @param root
     */
    public static void pull(String userName, String projectName, String root) {
        String data = HttpUtil.get("http://localhost:8765/cloud/file/pull?userName=" + userName + "&projectName=" + projectName);
        new FileCharge(root, userName, projectName).save(initFile(data, root, projectName));
    }

    public static void main(String[] args) {


    }

    public static void pushFile(String userName, String projectName, String root) throws Exception {
        String project = root + File.separator + userName + File.separator + projectName + File.separator;
        List<File> files = FileUtil.ergdoic(new File(project), new ArrayList<File>());
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userName", userName);
        map.put("projectName", projectName);
        map.put("data", parseString(files, root + File.separator + userName));
        HttpUtil.post("http://localhost:8765/cloud/file/push", map);
    }

    /**
     * 将数据转换成string
     *
     * @param files
     * @param root
     * @return
     */
    public static String parseString(List<File> files, String root) {
        JSONArray jsonArray = new JSONArray();
        for (File f : files) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", f.getName());
            jsonObject.put("type", f.isDirectory() ? FileEntity.FOLDER : FileEntity.FILE);
            jsonObject.put("relativePath", f.getPath().substring(root.length(), f.getPath().length()));
            jsonObject.put("path", f.getPath());
            jsonObject.put("lastUpdateTime", f.lastModified());
            jsonObject.put("content", FileUtil.readerString(f.getPath(), "UTF-8"));
            jsonArray.add(jsonObject);
        }
        FileUtil.log("当前文件系统信息.json", jsonArray.toString());
        return jsonArray.toString();
    }

    public static void vo(String root, String userName, String projectName, String data) {
        //将文件改成本地可执行类型
        List<FileEntity> fileEntities = HttpUtil.toEntity(data, FileEntity.class);
        List<FileEntity> fileEntityArrayList = new ArrayList<FileEntity>();
        for (FileEntity f : fileEntities) {
            FileEntity fileEntity1 = new FileEntity();
            fileEntity1.setName(f.getName());
        }
    }

    /**
     * 检查文件状态
     *
     * @param root
     * @param userName
     * @param projectName
     * @return
     */
    public static List<FileEntity> readFileEntityInfo(String root, String userName, String projectName) {
        List<FileEntity> fileEntities = HttpUtil.toEntity(parseString(FileUtil.ergdoic(new File(root + File.separator + userName + File.separator + projectName), new ArrayList<File>()), root), FileEntity.class);
        return fileEntities;
    }

    /**
     * 检查本地被修改的文件
     *
     * @param userName
     * @param projectName
     * @param root
     */
    public static List<FileEntity> checkFileUpdate(String root, String userName, String projectName) {
        // 2017/8/29 1.获取本地记录册
        List<FileEntity> usedEntities = new FileCharge(root, userName, projectName).readLocalCharge();
        // 2017/8/29 2.获取本地文件改动明细
        List<FileEntity> localEntitys = readFileEntityInfo(root, userName, projectName);
        // 2017/8/29 3.分析出被修改的文件、目录
        return compare(localEntitys, usedEntities);
    }

    /**
     * 比较文件变化
     *
     * @param newVersion
     * @param usedVersion
     * @param usedVersion List<FileEntity> 产生变化的数据
     */
    public static List<FileEntity> compare(List<FileEntity> newVersion, List<FileEntity> usedVersion) {
        List<FileEntity> change = new ArrayList<>();//用户存储新的变化
        //2017/8/29 如果新版本中的updatetime与旧版本中的不同，将塞入变更中;新版本中的记录在旧版本中不存在，将存入变更中
        for (FileEntity fileEntity : newVersion) {
            FileEntity fe = contains(usedVersion, fileEntity.getPath());
            if (fe == null) {
                change.add(fileEntity);
            } else if (fileEntity.getLastUpdateTime() != fe.getLastUpdateTime()) {
                change.add(fileEntity);
            }
        }
        return change;
    }

    public static FileEntity contains(List<FileEntity> fileEntities, String s) {
        if (fileEntities == null || fileEntities.size() == 0) {
            return null;
        }

        for (FileEntity f : fileEntities) {
            if (f.getPath().equals(s)) {
                return f;
            }
        }
        return null;
    }
}
