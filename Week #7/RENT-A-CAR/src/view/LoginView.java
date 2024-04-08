package view;

import core.Helper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {
    private JPanel container;
    private JPanel w_top;
    private JLabel lbl_welcome;
    private JPanel w_bottom;
    private JTextField fld_username;
    private JTextField fld_pass;
    private JButton btn_login;
    private JLabel lbl_username;
    private JLabel lbl_pass;
    private JLabel lbl_welcome2;

    public LoginView() {
        this.add(container);
        this.setTitle("Rent a Car");
        // delete from heap memory
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(400, 400);
        this.setVisible(true);


        this.setLocation(Helper.setLoc("x",this.getSize()),Helper.setLoc("y",this.getSize()));
        btn_login.addActionListener(e -> {
            //TODO info pop up
            if (Helper.isFieldEmpty(fld_username) || Helper.isFieldEmpty(fld_pass)) {
                Helper.showMsg("fill","");
            }
        });
    }
}
