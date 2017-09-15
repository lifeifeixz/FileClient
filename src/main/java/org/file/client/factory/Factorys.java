package org.file.client.factory;

import org.file.client.workers.FileExplorer;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by flysLi on 2017/9/15.
 */
public class Factorys {

    /**
     * 实例化一个自定义文件容器集合
     *
     * @return
     */
    public static List<FileExplorer> instanceExplorers() {
        return new ArrayList<FileExplorer>();
    }

    /**
     * 实例化一个自定义文件容器
     *
     * @return
     */
    public static FileExplorer instanceExplorer() {
        return new FileExplorer();
    }

    /**
     * 创建一个自定义文件容器，并给予属性值
     *
     * @return
     */
    public static FileExplorer createExplorer(String path) {
        FileExplorer fileExplorer = new FileExplorer();
        File file = new File(path);
        fileExplorer.setFileName(file.getName());
        fileExplorer.setPath(path);
        fileExplorer.setCreateDate(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(file.lastModified())));
        fileExplorer.setParentPath(new File(path).getParent());
        fileExplorer.setIsDirectory(file.isDirectory());
        return fileExplorer;
    }
}
