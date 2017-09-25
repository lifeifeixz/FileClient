package org.file.client.workers;

import org.file.client.factory.Factorys;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <strong>文件资源管理器</strong>
 *
 * @author flysLi
 */
@SuppressWarnings("all")
public class FileExplorer {
    /**
     * 文件或文件夹名称
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
     * 子文件或子目录
     */
    private List<FileExplorer> sons;

    /**
     * 父目录
     */
    private String parentPath;

    public String getParentPath() {
        return parentPath;
    }

    public void setParentPath(String parentPath) {
        this.parentPath = parentPath;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    /**
     * 文件绝对地址
     */
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean getIsDirectory() {
        return isDirectory;
    }

    public void setIsDirectory(boolean isDirectory) {
        this.isDirectory = isDirectory;
    }

    public List<FileExplorer> getSons() {
        return sons;
    }

    public void setSons(List<FileExplorer> sons) {
        this.sons = sons;
    }

    public void setDirectory(boolean isDirectory) {
        this.isDirectory = isDirectory;
    }

    /**
     * 获取文件后缀名
     *
     * @param file
     * @return
     */
    public static String getSuffix(File file) {
        if (file.isDirectory()) {
            return null;
        }
        String filename = file.getName();
        int startIndex = filename.lastIndexOf(".");
        if (startIndex == -1) {
            return "noType";
        }
        return filename.substring(startIndex + 1);
    }

    /**
     * <strong>获取子文件系统</strong>
     * <p>使用链式调用</p>
     *
     * @param o <p>可以为2中类型:FileExplorer / String</p>
     * @return
     */
    public FileExplorer getFileExplorer(Object o) {
        String path = null;
        if (o instanceof FileExplorer) {
            fileName = ((FileExplorer) o).getPath();
        } else if (o instanceof String) {
            path = o.toString();
        }
        File file = new File(o.toString());
        this.fileName = file.getName();
        this.path = file.getPath();
        this.isDirectory = file.isDirectory();
        this.createDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(file.lastModified()));
        this.parentPath = file.getParent();
        List<FileExplorer> fileExplorers = Factorys.instanceExplorers();
        File[] files = file.listFiles();
        for (File f : files) {
            fileExplorers.add(Factorys.createExplorer(f.getPath()));
        }
        this.sons = fileExplorers;
        return this;
    }

    public FileExplorer[] root() {
        File[] roots = File.listRoots();
        List<FileExplorer> fileExplorers = new ArrayList<>();
        for (int i = 0; i < roots.length; i++) {

        }
        return null;
    }

    /**
     * 使用者需要构造一个FileExplorer用于访问其子文件
     *
     * @param fileExplorer
     */
    public FileExplorer(Object o) {

        //如果fileExplorer是空的话，将访问根目录
        String path = null;
        if (o instanceof File) {
            path = ((File) o).getPath();
        } else if (o instanceof FileExplorer) {
            path = ((FileExplorer) o).getPath();
        } else if (o instanceof String) {
            path = (String) o;
        }
        File file = new File(path);
        this.setCreateDate(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(file.lastModified())));
        this.setFileName(file.getName());
        this.setPath(path);
        this.setParentPath(file.getParent());

        //如果是目录,则获取子信息
        if (file.isDirectory()) {
            this.setIsDirectory(file.isDirectory());
            File[] files = file.listFiles();
            List<FileExplorer> fes = Factorys.instanceExplorers();
            for (int i = 0; i < files.length; i++) {
                fes.add(Factorys.createExplorer(files[i].getPath()));
            }
            this.setSons(fes);
        } else {
            this.setIsDirectory(false);
        }
    }

    public FileExplorer() {

    }

    public static void main(String[] args) {
        String str = "D:\\L临时数据";
        FileExplorer fe = new FileExplorer(str);
        List<FileExplorer> fes = fe.getSons();
        for (FileExplorer fileExplorer : fes) {
            System.out.println(fileExplorer.getFileName());
        }

    }
}
