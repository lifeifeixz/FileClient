package org.client;

import java.awt.*;

/**
 * Created by flysLi on 2017/8/29.
 */
public class IndexWindow {
    public static void main(String[] args) {
        Frame frame = new Frame("My first windows");
        frame.setLayout(new GridLayout(7, 1));
        //lable组件
        frame.add(new Label(""));
        //checkbox组件
        frame.add(new Checkbox("music"));
        frame.add(new Checkbox("PE"));
        frame.add(new Checkbox("meishu"));
        //List组件
        List l = new List(3, false);
        l.add("wasd");
        l.add("asfasd");
        l.add("fasdas");
        frame.add(l);
        //Button组件
        frame.add(new Button("asdfas"));
        frame.pack();//调整窗口以容纳所有的组件
        frame.setVisible(true);//显示窗口
        System.out.println("adas+c");
    }
}
