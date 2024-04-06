package view;

import business.UserController;
import entity.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditView extends JFrame {
    private JPanel container;
    private JTextField fld_name;
    private JTextField fld_mail;
    private JPasswordField fld_password;
    private JComboBox<User.Type> cmb_type;
    private JRadioButton radio_female;
    private JRadioButton radio_male;
    private JCheckBox check_agree;
    private JButton btn_save;
    private JLabel lbl_name;
    private JLabel lbl_mail;
    private JLabel lbl_password;
    private JLabel lbl_type;
    private JLabel lbl_gender;
    private User user;
    private UserController userController;

    private DefaultComboBoxModel<User.Type> cmdl_type;

    public EditView(User user) {
        this.add(container);
        this.setTitle("User Edit");
        this.setSize(300,500);
        int x = (Toolkit.getDefaultToolkit().getScreenSize().width - this.getWidth()) / 2;
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height - this.getHeight()) / 2;
        this.setLocation(x,y);
        this.setVisible(true);

        //user boş ise yeni ekleme değilse editleme
        this.user = user;
        this.userController = new UserController();

        this.cmdl_type = new DefaultComboBoxModel<>(User.Type.values());
        this.cmb_type.setModel(cmdl_type);

        if(this.user.getId() != 0) {
            this.fld_name.setText(this.user.getName());
            this.fld_mail.setText(this.user.getEmail());
            this.fld_password.setText(this.user.getPassword());
            this.cmb_type.getModel().setSelectedItem(user.getType());
            if(this.user.getGender() == User.Gender.FEMALE) {
                this.radio_female.setSelected(true);
            } else {
                this.radio_male.setSelected(true);
            }
        }

        check_agree.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 if(check_agree.isSelected()) {
                     btn_save.setEnabled(true);
                 } else {
                     btn_save.setEnabled(false);
                 }
            }
        });
        btn_save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(fld_mail.getText().isEmpty() ||
                        fld_name.getText().isEmpty() ||
                        fld_password.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "Please fill all fields",
                            "Missing Data",
                            JOptionPane.ERROR_MESSAGE
                    );
                } else {
                    user.setName(fld_name.getText());
                    user.setEmail(fld_mail.getText());
                    user.setPassword(fld_password.getText());
                    user.setType((User.Type)cmb_type.getSelectedItem());
                    if(radio_male.isSelected()) {
                        user.setGender(User.Gender.MALE);
                    } else {
                        user.setGender(User.Gender.FEMALE);
                    }
                    if (user.getId() != 0) {
                        if (userController.update(user)){
                            JOptionPane.showMessageDialog(null,
                                    "Data has been uptaded",
                                    "Update Data",
                                    JOptionPane.INFORMATION_MESSAGE
                            );
                            dispose();
                        }
                    } else {
                        // SAVE
                        if(userController.save(user)) {
                            JOptionPane.showMessageDialog(null,
                                    "Data has been created",
                                    "Add Data",
                                    JOptionPane.INFORMATION_MESSAGE
                            );
                            dispose();
                        }


                    }



                }
            }
        });
    }
}
