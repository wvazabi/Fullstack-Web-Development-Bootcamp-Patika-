package view;

import core.Helper;

import javax.swing.*;

public class Layout extends JFrame {
    public void guiInitilaze(int width, int height, String title){
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle(title);
        this.setSize(width,height);
        this.setLocation(Helper.setLoc("x",this.getSize()), Helper.setLoc("y",this.getSize()));
        this.setVisible(true);


    }
}
