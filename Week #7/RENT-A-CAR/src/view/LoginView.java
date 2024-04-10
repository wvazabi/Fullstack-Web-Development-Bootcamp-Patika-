package view;

import business.UserManager;
import core.Helper;
import entity.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends Layout {
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
    private final UserManager userManager;

    public LoginView() {
        this.userManager =  new UserManager();
        this.add(container);
        this.guiInitilaze(400,400,"Rent a Car");


        this.setLocation(Helper.setLoc("x",this.getSize()),Helper.setLoc("y",this.getSize()));
        btn_login.addActionListener(e -> {
            //TODO info pop up
            if (Helper.isFieldEmpty(fld_username) || Helper.isFieldEmpty(fld_pass)) {
                Helper.showMsg("fill","");
            } else {
                User loginUser = this.userManager.findByLogin(this.fld_username.getText(),this.fld_pass.getText());
                if(loginUser == null) {
                    Helper.showMsg("User does not found","Not Found!");
                } else {
                    AdminView adminView = new AdminView(loginUser);
                    dispose();
                }
            }
        });
    }
}
