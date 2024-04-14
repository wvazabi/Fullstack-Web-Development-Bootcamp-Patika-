package view;

import business.BrandManager;
import business.ModelManager;
import core.Helper;
import entity.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.ArrayList;

public class AdminView extends Layout {
    private JPanel container;
    private JLabel lbl_welcome;
    private JTabbedPane tab_menu;
    private JButton logOutButton;
    private JPanel pnl_top;
    private JScrollPane scrl_brand;
    private JTable tbl_brand;
    private JPanel pnl_model;
    private JScrollPane scrl_model;
    private JTable tbl_model;
    private User user;

    //TODO table model
    private DefaultTableModel tmdl_brand = new DefaultTableModel();
    private DefaultTableModel tmdl_model = new DefaultTableModel();

    //TODO  manager
    private BrandManager brandManager;
    private ModelManager modelManager;

    //TODO JPopUpMenu
    private JPopupMenu brandMenu;
    private JPopupMenu model_Menu;

    private Object[] col_model;

    public AdminView(User user) {
        this.brandManager = new BrandManager();
        this.modelManager = new ModelManager();
        this.add(container);
        this.guiInitilaze(1000, 500, "Admin Panel");
        this.user = user;

        if (user == null) {
            dispose();
        }

        this.lbl_welcome.setText("Welcome " + this.user.getUsername());

        loadBrandTable();
        loadBrandComponent();
        loadModelTable();


        tbl_brand.setComponentPopupMenu(brandMenu);
    }

    public void loadBrandTable() {

        Object[] col_brand = {"Brand ID", "Brand Name"};
        ArrayList<Object[]> brandList = brandManager.getForTable(col_brand.length);
        this.createTable(this.tmdl_brand, this.tbl_brand, col_brand, brandList);

    }

    public void loadModelTable() {
        this.col_model = new Object[]{"Model ID","Marka", "Model Adı","Tip","Yıl","Yakıt Türü ","Vites"};
        ArrayList<Object[]> modelList = this.modelManager.getForTable(this.col_model.length,this.modelManager.findAll());

//        if(modelList ==null){
//            modelList =
//        }

        this.createTable(this.tmdl_model, this.tbl_model, this.col_model, modelList);
    }


    public void loadBrandComponent() {
        //TODO sağ clik
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
        brandMenu.add("Delete").addActionListener(e -> {
            if (Helper.confirm("sure")){
                int selectBrandId = this.getTableSelectedRow(tbl_brand, 0);
                if(this.brandManager.delete(selectBrandId)) {
                    Helper.showMsg("done","");
                    loadBrandTable();
                } else {
                    Helper.showMsg("error","");
                }
            }


        });

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
    }


}
