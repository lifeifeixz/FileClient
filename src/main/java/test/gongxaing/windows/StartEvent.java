package test.gongxaing.windows;

import jars.ResourceTransportationUtil;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * @author flysLi
 * @date 2018/3/29
 */
public class StartEvent implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Button start = (Button) e.getSource();
        IndexFrame indexFrame = (IndexFrame) start.getParent();
        FileDialog upload = indexFrame.d1;
    }
}
