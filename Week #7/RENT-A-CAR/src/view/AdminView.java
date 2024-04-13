package view;

import business.BrandManager;
import entity.Brand;
import entity.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
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

        loadBrandTable();

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
            System.out.println("Add clicked");
            BrandView brandView = new BrandView(null);
            brandView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadBrandTable();
                }
            });
        });
        brandMenu.add("Delete");

        brandMenu.add("Update").addActionListener(e -> {
            int selectedBrandId = Integer.parseInt(tbl_brand.getValueAt(tbl_brand.getSelectedRow(),0).toString());
            BrandView brandView = new BrandView(this.brandManager.getById(selectedBrandId));
            brandView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadBrandTable();
                }
            });
        });

        tbl_brand.setComponentPopupMenu(brandMenu);
    }

    public void loadBrandTable() {

        Object[] col_brand = {"Brand ID", "Brand Name"};
        ArrayList<Brand> brandArrayList = brandManager.findAll();
        tmdl_brand.setColumnIdentifiers(col_brand);



        tbl_brand.setModel(tmdl_brand);
        //TODO tablodaki sütunları tıklayarak yer değiştirmeyi kapatma
        tbl_brand.getTableHeader().setReorderingAllowed(false);
        //TODO düzenleme iptal etme
        tbl_brand.setEnabled(false);

        DefaultTableModel clearModel = (DefaultTableModel) this.tbl_brand.getModel();
        clearModel.setRowCount(0);
        for(Brand brand : brandArrayList) {
            //her klonun karşılığı gelen obje lazım
            Object[] obj = {brand.getId(),brand.getName()};
            tmdl_brand.addRow(obj);
        }

    }


}
