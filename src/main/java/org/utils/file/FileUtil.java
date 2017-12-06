package org.utils.file;


import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * Created by flysLi on 2017/8/28.
 */
public class FileUtil {

    /**
     * 可能创建一个文件
     *
     * @param path
     */
    public static void maybeNewFile(String path) {
        File file = new File(path);
        file.mkdir();
    }

    /**
     * 下载文件
     *
     * @param path
     * @param content
     */
    public static void initData(String path, String content) {

    }

    /**
     * 必须创建一个文件
     *
     * @param path
     */
    public static File mustNewFile(String path) {
        File file = new File(path);
        if (file.exists()) {
            file.mkdir();
        }
        return file;
    }

    /**
     * 写出文件到服务器
     *
     * @param path 路径
     * @param data 要输出的数据
     */
    public static File writer(String path, String data) {

        //判断路径是否存在
        File file = new File(path.substring(0, path.lastIndexOf(File.separator)));
        if (!file.isDirectory() && !file.isFile()) {
            file.mkdirs();
        }

        if (data == null) {
            return null;
        }

        File f = new File(path);
        OutputStream out = null;

        try {
            out = new FileOutputStream(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //将字符串转换成字节数组
        byte[] b = data.getBytes();

        try {
            out.write(b);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return f;
    }


    public static void main(String[] args) {
//        String path = "C:\\Users\\flysLi\\Desktop\\temp\\L临时数据\\lifeifeixz@sina.cn\\user\\src\\main\\java";
//        String father = "C:\\Users\\flysLi\\Desktop\\temp\\L临时数据\\lifeifeixz@sina.cn\\user";
        System.out.println(FileUtil.getFileMD5("D:\\学习\\file.txt"));
    }

    /**
     * 计算相对路劲
     *
     * @param path
     * @param fatherPath
     * @return
     */
    public static String relvltePath(String path, String fatherPath) {
        String[] paths = path.split(File.separator);
        String[] fathers = path.split(File.separator);
        int index = 0;
        //删除其公有的数据
        for (int i = 0; i < paths.length; i++) {
            if (!paths[i].equals(fathers[i])) {
                index = i;
                continue;
            }
        }

        String newPath = "";
        for (int i = index; i < paths.length; i++) {
            newPath += File.separator + paths[i];
        }
        return newPath;
    }

    /**
     * 读取文件内容
     *
     * @param filePath
     * @return
     */
    public static String readerString(String filePath, String encoding) {
        File file = new File(filePath);
        String sb = "";
        if (file.isFile() && file.exists()) {// 判断文件是否存在
            InputStreamReader read = null;// 考虑到编码格式
            BufferedReader br = null;
            String lineTxt = null;
            try {
                read = new InputStreamReader(new FileInputStream(file), encoding);// 考虑到编码格式
                br = new BufferedReader(read);
                while ((lineTxt = br.readLine()) != null) {
                    sb += lineTxt;
                    sb += "\n";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    /**
     * 读取文件
     *
     * @param filePath
     * @return
     */
    public static String readerString(String filePath) {
        return readerString(filePath);
    }

    /**
     * 读取硬盘结构数据
     *
     * @param file
     * @param fileList
     * @return
     */
    public static List<File> ergdoic(File file, List<File> fileList) {

        if (file.isDirectory()) {
            fileList.add(file);
        }
        File[] files = file.listFiles();
        if (files == null) {
            return fileList;
        }
        for (File f : files) {
            if (!f.isDirectory()) {//如果不是文件夹
                fileList.add(f);
            } else {
                ergdoic(f, fileList);//如果是文件夹进行递归
            }
        }
        return fileList;//返回文件名的集合
    }

    /**
     * 获取文件的MD5
     *
     * @param fileName
     * @return
     */
    public static String getFileMD5(String fileName) {
        String result = null;
        try {
            File file = new File(fileName);
            FileInputStream fis = new FileInputStream(file);
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] buffer = new byte[1024];
            int length = -1;
            while ((length = fis.read(buffer, 0, 1024)) != -1) {
                md.update(buffer, 0, length);
            }
            BigInteger bigInt = new BigInteger(1, md.digest());
            result = bigInt.toString(16);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 输出日志
     *
     * @param fileName
     * @param data
     */
    public static void log(String fileName, String data) {
        writer("C:\\Users\\flysLi\\Desktop\\temp\\L临时数据\\filetest\\log\\" + fileName, data);
    }
}
