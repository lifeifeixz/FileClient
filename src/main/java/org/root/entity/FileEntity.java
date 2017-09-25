package org.root.entity;

import org.file.client.workers.FileExplorer;
import java.io.File;
import java.util.List;

/**
 * Created by flysLi on 2017/9/19.
 */
public class FileEntity {
    /**
     * <p>
     * 文件或文件夹名称
     * </p>
     */
    private String fileName;

    /**
     * 文件大小(k)
     */
    private int size;

    /**
     * 是否是目录 true：目录 false：文件
     */
    private boolean isDirectory;

    /**
     * 文件后缀名
     */
    private String suffix;

    /**
     * 创建时间
     */
    private String createDate;

    /**
     * 最后修改时间
     */
    private Long lastModified;

    /**
     * 子文件或子目录
     */
    private List<FileExplorer> sons;

    /**
     * 父目录
     */
    private String parentPath;

    public static void main(String[] args) {
        File f = new File("");
        f.lastModified();
    }
}
