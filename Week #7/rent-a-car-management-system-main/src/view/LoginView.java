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
    private JPanel w_button;
    private JTextField fld_username;
    private JPasswordField fld_password;
    private JButton btn_login;
    private JLabel lbl_username;
    private JLabel lbl_password;
    private final UserManager userManager;

    public LoginView() {
        this.userManager = new UserManager();
        this.add(container);
        this.guiInitialize(400,400);

        btn_login.addActionListener(e -> {
            JTextField[] checkedFieldList = {this.fld_username, this.fld_password};
           if (Helper.isFieldListEmpty(checkedFieldList)) {
               Helper.showMessage("fill");
           } else {
               User userLogin = this.userManager.findByLogin(this.fld_username.getText(), this.fld_password.getText());
               if (userLogin == null) {
                   Helper.showMessage("notFound");
               } else {
                   AdminView adminView = new AdminView(userLogin);
                   dispose();
               }
           }
        });
    }


}
