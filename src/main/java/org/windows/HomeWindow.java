package org.windows;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

/**
 * Created by flysLi on 2017/9/8.
 */
public class HomeWindow extends Frame implements ActionListener, TextListener {
    MenuBar menubar;
    Menu menu;
    MenuItem item1, item2;
    TextArea ta = new TextArea("public class MyFrame extends Frame MyFrame fr = new MyFrame");

    HomeWindow() {
        setTitle("FVN文件版本管理系统");
        Toolkit tool = getToolkit();
        Dimension dim = tool.getScreenSize();
        setBounds(500, 200, 700, 420);
        menubar = new MenuBar();
        menu = new Menu("File");
        item1 = new MenuItem("sync");
        item2 = new MenuItem("push");
        item2 = new MenuItem("pull");
        item2.addActionListener(this);
        menu.add(item1);
        menu.add(item2);
        menubar.add(menu);
        setMenuBar(menubar);
        setVisible(true);

        //布局
        //设置CardLayout布局管理器
        this.setLayout(null);
        Panel p = new Panel();
        this.add(p);

        //加入一些文本
        ta.setBounds(100, 100, 600, 200);
        Font f = new Font("宋体", Font.ITALIC + Font.BOLD, 14);
        ta.setFont(f);
        ta.addTextListener(this);
        ta.setForeground(Color.red);
        p.add(ta);
    }

    /**
     * 按钮监听
     *
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
    }

    /**
     * 文本监听
     *
     * @param e
     */
    public void textValueChanged(TextEvent e) {

    }
}
