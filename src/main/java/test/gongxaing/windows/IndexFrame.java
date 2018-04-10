package test.gongxaing.windows;

import java.awt.*;

/**
 * @author flysLi
 * @date 2018/3/29
 */
public class IndexFrame extends Frame {
    public Button start, choiceFileBtn, exitout;
    public int baseX = 0;
    public FileDialog d1;
    public Label uploadLabel;

    public IndexFrame(String str) {
        super(str);
    }

    public void init() {
        /*设置窗口居中显示*/
        this.setLayout(null);
        /*设置icon*/
        setSize(400, 800);
        setVisible(true);
        setResizable(false);

        /*上传组件*/
        uploadLabel = new Label("UPLOAD");
        uploadLabel.setBounds(baseX + 50, 170, 60, 30);
        add(uploadLabel);

        /*文件选择按钮*/
        choiceFileBtn = new Button("upload");
        choiceFileBtn.setBounds(baseX + 110, 170, 50, 30);
        choiceFileBtn.addActionListener((e) -> {
            d1.setVisible(true);
        });
        add(choiceFileBtn);

        //下拉框组件
        Choice c = new Choice();
        c.setBounds(baseX + 220, 170, 100, 30);
        c.add("table");
        c.add("detail");
        c.add("form");
        add(c);
        add(c);

         /*开始按钮*/
        start = new Button("Start");
        start.setBounds(baseX + 90, 200, 60, 30);
        start.addActionListener(new StartEvent());
        add(start);

        /*退出按钮*/
        exitout = new Button("exit");
        exitout.setBounds(baseX + 250, 200, 60, 30);
        exitout.addActionListener(new CloseEvent());
        add(exitout);

        /*文件选择窗口*/
        d1 = new FileDialog(this, "Open File", FileDialog.LOAD);
    }

    public static void main(String[] args) {
        IndexFrame indexFrame = new IndexFrame("登录窗口");
        indexFrame.init();
    }
}
