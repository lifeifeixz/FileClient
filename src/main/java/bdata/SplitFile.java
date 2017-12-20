package bdata;

import java.io.*;
/**
 * @author flysLi
 * @date 2017/12/19
 */
@SuppressWarnings("all")
public class SplitFile {

    private File file;

    public static void main(String[] args) throws Exception {
        SplitFile splitFile = new SplitFile("D:\\L临时数据\\splitDemo\\2a58421e084b365e40b7002a50694df1.mp4");
//        splitFile.split(1024 * 1024);
        splitFile.sequence();
        System.out.println("程序完成");
    }

    public SplitFile(String filePath) {
        this.file = new File(filePath);
    }

    /**
     * 文件分割
     *
     * @param fileSize 你只需声明你一个block多大
     * @throws IOException
     */
    public void split(int fileSize) throws IOException {
        FileInputStream fis;
        FileOutputStream fos;
        byte[] buf = new byte[fileSize];
        int len, count = 0;

        fis = new FileInputStream(this.file.getPath());
        while ((len = fis.read(buf)) != -1) {
            count++;
            fos = new FileOutputStream(this.file.getPath() + "." + count);
            fos.write(buf, 0, len);
            fos.flush();
            fos.close();
        }
        fis.close();
    }

    public void sequence() throws Exception {
        FileOutputStream fos = new FileOutputStream("D:\\L临时数据\\splitDemo\\2a58421e084b365e40b7002a50694df1.mp4");
        byte[] buf = new byte[1024 * 1024];
        for (int i = 1; i <= 8; i++) {
            FileInputStream fis = new FileInputStream("D:\\L临时数据\\splitDemo\\2a58421e084b365e40b7002a50694df1.mp4." + i);
            int len = 0;
            while ((len = fis.read(buf)) != -1) {
                fos.write(buf, 0, len);
            }
        }
        fos.flush();
        fos.close();

    }

}
