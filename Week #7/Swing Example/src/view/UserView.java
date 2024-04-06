package view;

import business.UserController;
import entity.User;
import sun.security.util.Password;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class UserView extends  JFrame {
    private JPanel container;
    private JTabbedPane tab_menu;
    private JPanel pnl_user;
    private JTable tbl_user;
    private JButton btn_user_new;
    private JButton btn_refresh;
    private UserController userController;
    private DefaultTableModel mdl_user;
    private JPopupMenu user_popup;

    public UserView(){
        this.add(container);
        this.setTitle("User Management");
        this.setSize(500,500);
        int x = (Toolkit.getDefaultToolkit().getScreenSize().width - this.getWidth()) / 2;
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height - this.getHeight()) / 2;
        this.setLocation(x,y);
        this.setVisible(true);

        //business katman bağlantısı
        this.userController = new UserController();
        this.mdl_user = new DefaultTableModel();
        this.user_popup = new JPopupMenu();

        // Table Model
        //kolon başlıkları oluştur

        Object[] columnUser = {"Id", "Name", "Type", "Gender", "E-mail", "Password"};
        this.mdl_user.setColumnIdentifiers(columnUser);

        ArrayList<User> users = this.userController.findAll();

        for(User user : users) {
            Object[] row = {
                    user.getId(),
                    user.getName(),
                    user.getType(),
                    user.getGender(),
                    user.getEmail(),
                    user.getPassword()
            };
            this.mdl_user.addRow(row);
        }

        //Modeli tabloya ata

        this.tbl_user.setModel(this.mdl_user);
        this.tbl_user.setEnabled(false);
        this.tbl_user.getTableHeader().setReorderingAllowed(false);


        this.tbl_user.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int selectedRow = tbl_user.rowAtPoint(e.getPoint());
                tbl_user.setRowSelectionInterval(selectedRow,selectedRow);

            }
        });

        this.user_popup.add("Update").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              int selectedID = Integer.parseInt(tbl_user.getValueAt(tbl_user.getSelectedRow(),0).toString());
              User selectedUser = userController.getById(selectedID);
              EditView editView = new EditView(selectedUser);
            }
        });
        this.user_popup.add("Delete").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedID = Integer.parseInt(tbl_user.getValueAt(tbl_user.getSelectedRow(),0).toString());
                userController.delete(selectedID);
            }
        });

        this.tbl_user.setComponentPopupMenu(user_popup);
        btn_user_new.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditView editView = new EditView(new User());

            }
        });
        btn_refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mdl_user.setRowCount(0);
                ArrayList<User> users = userController.findAll();

                for(User user : users) {
                    Object[] row = {
                            user.getId(),
                            user.getName(),
                            user.getType(),
                            user.getGender(),
                            user.getEmail(),
                            user.getPassword()
                    };
                    mdl_user.addRow(row);
                }

               tbl_user.setModel(mdl_user);
               tbl_user.setEnabled(false);
               tbl_user.getTableHeader().setReorderingAllowed(false);

            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
