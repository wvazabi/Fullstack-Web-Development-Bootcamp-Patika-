package view;

import business.BrandManager;
import entity.Brand;
import entity.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class AdminView extends Layout{
    private JPanel container;
    private JLabel lbl_welcome;
    private JTabbedPane tab_menu;
    private JButton logOutButton;
    private JPanel pnl_top;
    private JScrollPane scrl_brand;
    private JTable tbl_brand;
    private User user;

    private DefaultTableModel tmdl_brand = new DefaultTableModel();
    private BrandManager brandManager;
    private JPopupMenu brandMenu;

    public AdminView(User user) {
        this.brandManager = new BrandManager();
        this.add(container);
        this.guiInitilaze(1000,500,"Admin Panel");
        this.user = user;

        if(user == null) {
            dispose();
        }

        this.lbl_welcome.setText("Welcome " + this.user.getUsername());
        Object[] col_brand = {"Brand ID", "Brand Name"};
        ArrayList<Brand> brandArrayList = brandManager.findAll();
        tmdl_brand.setColumnIdentifiers(col_brand);

        for(Brand brand : brandArrayList) {
            //her klonun karşılığı gelen obje lazım
            Object[] obj = {brand.getId(),brand.getName()};
            tmdl_brand.addRow(obj);
        }

        tbl_brand.setModel(tmdl_brand);
        //TODO tablodaki sütunları tıklayarak yer değiştirmeyi kapatma
        tbl_brand.getTableHeader().setReorderingAllowed(false);
        //TODO düzenleme iptal etme
        tbl_brand.setEnabled(false);
        this.tbl_brand.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int selected_row = tbl_brand.rowAtPoint(e.getPoint());
                tbl_brand.setRowSelectionInterval(selected_row,selected_row);
            }
        });

        //TODO sağ tıkla menu
        this.brandMenu = new JPopupMenu();
        brandMenu.add("Add").addActionListener(e -> {
            System.out.println("New clicked");
        });
        brandMenu.add("Delete");
        brandMenu.add("Update");

        tbl_brand.setComponentPopupMenu(brandMenu);
    }
}
