package org.file.client.action;

import com.netflix.governator.annotations.binding.Request;
import com.netflix.governator.annotations.binding.Response;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.file.client.workers.FileExplorer;
import org.file.client.workers.FileManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.utils.file.FileUtil;
import org.utils.file.entity.FileEntity;

import java.io.File;
import java.util.List;

/**
 * Created by flysLi on 2017/8/28.
 */
@SuppressWarnings("all")
@RestController
@RequestMapping(value = "/client")
public class FuncAction {

    /**
     * 客户端拉取数据
     *
     * @param userName
     * @param projectName
     * @return
     */
    @ApiOperation("push文件")
    @RequestMapping(value = "/pull", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Object pull(@ApiParam(name = "userName", value = "用户名,例:lifeifeixz@sina.cn") @RequestParam(required = true) String userName,
                       @ApiParam(name = "projectName", value = "项目名,例:demo") @RequestParam(required = true) String projectName,
                       @ApiParam(name = "root", value = "根目录,例:D:") @RequestParam(required = true) String root) {

        FileManager.pull(userName, projectName, root);
        return null;
    }

    /**
     * 客户端推送文件
     *
     * @param userName
     * @param projectName
     * @param root
     * @return
     */
    @ApiOperation("push文件")
    @RequestMapping(value = "/push")
    @ResponseBody
    public Object push(@ApiParam(name = "userName", value = "用户名,例:lifeifeixz@sina.cn") @RequestParam(required = true) String userName,
                       @ApiParam(name = "projectName", value = "项目名,例:demo") @RequestParam(required = true) String projectName,
                       @ApiParam(name = "root", value = "根目录,例:D:") @RequestParam(required = true) String root) {
        try {
            FileManager.pushFile(userName, projectName, root);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "完成";
    }

    /**
     * 比较文件变化
     *
     * @param userName
     * @param projectName
     * @param root
     * @return
     */
    @ApiOperation("sync")
    @RequestMapping(value = "/sync")
    @ResponseBody
    public List<FileEntity> sync(@ApiParam(name = "userName", value = "用户名,例:lifeifeixz@sina.cn") @RequestParam(required = true) String userName,
                                 @ApiParam(name = "projectName", value = "项目名,例:demo") @RequestParam(required = true) String projectName,
                                 @ApiParam(name = "root", value = "根目录,例:D:") @RequestParam(required = true) String root) {

        return FileManager.checkFileUpdate(root, userName, projectName);
    }

    /**
     * 获取文件资源
     *
     * @param path 硬盘的路径
     * @return
     */
    @ApiOperation("获取文件资源")
    @RequestMapping("/getFileExplorer")
    @ResponseBody
    public FileExplorer getFileExplorer(@ApiParam(name = "path", value = "路径") @RequestParam(required = true) String path) {
        return new FileExplorer(path);
    }

    @ApiOperation("设置常用网页")
    @RequestMapping("/setCommonWebsite")
    @ResponseBody
    public int setCommonWebsite(@ApiParam(name = "快捷键", value = "keyword") @RequestParam(required = true) String keyword,
                                @ApiParam(name = "网站地址", value = "url") @RequestParam(required = true) String url) {
        File file = new File("C:\\Users\\flysLi\\Document\\Link", keyword + ".bat");
        String text = "@echo off\n" +
                "start " + url;
        FileUtil.writer(file.getPath(), text);
        return 1;
    }
}
