package view;

import business.BrandManager;
import business.CarManager;
import business.ModelManager;
import core.ComboItem;
import core.Helper;
import entity.Brand;
import entity.Car;
import entity.Model;
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
    private JButton btn_search_model;
    private JComboBox cmb_s_model_brand;
    private JComboBox cmb_s_model_type;
    private JComboBox cmb_s_model_fuel;
    private JComboBox cmb_s_model_gear;
    private JLabel lbl_s_model_brand;
    private JButton btn_cncl_model;
    private JPanel pnl_brands;
    private JPanel pnl_car;
    private JScrollPane scrl_car;
    private JTable tbl_car;
    private JPanel pnl_booking;
    private JPanel pnl_booking_search;
    private JScrollPane scrl_booking;
    private JTextField fld_strt_date;
    private JTextField fld_fnsh_date;
    private JComboBox cmb_booking_gear;
    private JComboBox cmb_booking_fuel;
    private JComboBox cmb_booking_type;
    private JButton button1;
    private JTable tbl_booking;
    private User user;

    //TODO table model
    private DefaultTableModel tmdl_brand = new DefaultTableModel();
    private DefaultTableModel tmdl_model = new DefaultTableModel();
    private DefaultTableModel tmdl_car = new DefaultTableModel();

    //TODO  manager
    private BrandManager brandManager;
    private ModelManager modelManager;
    private CarManager carManager;

    //TODO JPopUpMenu
    private JPopupMenu brand_menu;
    private JPopupMenu model_menu;
    private JPopupMenu car_menu;

    private Object[] col_model;


    public AdminView(User user) {
        this.brandManager = new BrandManager();
        this.modelManager = new ModelManager();
        this.carManager = new CarManager();

        this.add(container);
        this.guiInitilaze(1000, 500, "Admin Panel");
        this.user = user;

        if (user == null) {
            dispose();
        }

        this.lbl_welcome.setText("Welcome " + this.user.getUsername());

        loadBrandTable();
        loadBrandComponent();


        loadModelTable(null);
        loadModelComponent();
        loadModelFilter();

        loadCarComponent();
        loadCarTable();


    }




    public void loadCarTable() {
        Object[] col_car = {"ID", "Marka", "Model", "Plaka", "Renk", "Km", "Yıl", "Tip", "Yakit Türü", "Vites"};
        ArrayList<Car> allCars = this.carManager.findAll(); // Tüm araçları al
        if (allCars != null) { // Null kontrolü yap
            ArrayList<Object[]> carList = this.carManager.getForTable(col_car.length, allCars); // Tablo için gerekli listeyi oluştur
            createTable(this.tmdl_car, this.tbl_car, col_car, carList);
        } else {
            // Hata mesajı veya başka bir işlem yapılabilir
            System.err.println("Error: Car list is null");
        }
    }


    public void loadBrandTable() {

        Object[] col_brand = {"Brand ID", "Brand Name"};
        ArrayList<Object[]> brandList = brandManager.getForTable(col_brand.length);
        this.createTable(this.tmdl_brand, this.tbl_brand, col_brand, brandList);
    }

    private void loadCarComponent() {

        this.tableRowSelect(this.tbl_car);

        this.car_menu = new JPopupMenu();
        this.car_menu.add("Yeni").addActionListener(e -> {
            CarView carView = new CarView(new Car());
            carView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadCarTable();
                }
            });
        });
        this.car_menu.add("Güncelle").addActionListener(e -> {
            int selectCarlId = this.getTableSelectedRow(tbl_car, 0);
            CarView carView = new CarView(this.carManager.getById(selectCarlId));
            carView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadCarTable();
                    //loadRentalsTable(null);
                }
            });
        });
        this.car_menu.add("Sil").addActionListener(e -> {
            if (Helper.confirm("sure")) {
                int selectCarId = this.getTableSelectedRow(tbl_car, 0);
                if (this.carManager.delete(selectCarId)) {
                    Helper.showMsg("done");

                    loadCarTable();
                } else {
                    Helper.showMsg("error");
                }
            }
        });
        this.tbl_car.setComponentPopupMenu(this.car_menu);

//        this.btn_search_model.addActionListener(e -> {
//            ComboItem selectedBrand = (ComboItem) this.cmb_s_model_brand.getSelectedItem();
//            int brandId = 0;
//            if (selectedBrand != null) {
//                brandId = selectedBrand.getKey();
//            }
//            ArrayList<Model> modelListBySearch = this.modelManager.searcForTable(
//                    brandId,
//                    (Model.Fuel) cmb_s_model_fuel.getSelectedItem(),
//                    (Model.Gear) cmb_s_model_gear.getSelectedItem(),
//                    (Model.Type) cmb_s_model_type.getSelectedItem()
//            );
//
//            ArrayList<Object[]> modelRowListBySearch = this.modelManager.getForTable(this.col_model.length, modelListBySearch);
//            loadModelTable(modelRowListBySearch);
//        });

    }

        private void loadModelFilter() {
        this.cmb_s_model_type.setModel(new DefaultComboBoxModel<>(Model.Type.values()));
        this.cmb_s_model_type.setSelectedItem(null);
        this.cmb_s_model_gear.setModel(new DefaultComboBoxModel<>(Model.Gear.values()));
        this.cmb_s_model_gear.setSelectedItem(null);
        this.cmb_s_model_fuel.setModel(new DefaultComboBoxModel<>(Model.Fuel.values()));
        this.cmb_s_model_fuel.setSelectedItem(null);
        loadModelFilterBrand();
    }

    public void loadModelFilterBrand() {
        this.cmb_s_model_brand.removeAllItems();
        for (Brand obj : brandManager.findAll()) {
            this.cmb_s_model_brand.addItem(new ComboItem(obj.getId(), obj.getName()));
        }
        this.cmb_s_model_brand.setSelectedItem(null);
    }

    private void loadModelComponent() {
        tableRowSelect(tbl_model);
        this.model_menu = new JPopupMenu();

        model_menu.add("Add").addActionListener(e -> {
            ModelView modelView = new ModelView(new Model());
            modelView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadModelTable(null);
                }
            });

        });
        model_menu.add("Delete").addActionListener(e -> {
            if(Helper.confirm("sure")){
                int selectModelId   = this.getTableSelectedRow(tbl_model,0);
                if(this.modelManager.delete(selectModelId)){
                    Helper.showMsg("done","");

                    loadModelTable(null);
                    loadCarTable();
                }else {
                    Helper.showMsg("error");
                }
            }
        });

        model_menu.add("Update").addActionListener(e -> {

            int selectModelId   = this.getTableSelectedRow(tbl_model,0);
            ModelView modelView = new ModelView(this.modelManager.getById(selectModelId));
            modelView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadModelTable(null);
                    loadCarTable();
                }
            });

        });

        tbl_model.setComponentPopupMenu(model_menu);

        this.btn_search_model.addActionListener(e -> {
            ComboItem selectedBrand = (ComboItem) this.cmb_s_model_brand.getSelectedItem();
            int brandId = 0;
            if (selectedBrand != null) {
                brandId = selectedBrand.getKey();
            }
            ArrayList<Model> modelListBySearch = this.modelManager.searcForTable(
                    brandId,
                    (Model.Fuel) cmb_s_model_fuel.getSelectedItem(),
                    (Model.Gear) cmb_s_model_gear.getSelectedItem(),
                    (Model.Type) cmb_s_model_type.getSelectedItem()
            );

            ArrayList<Object[]> modelRowListBySearch = this.modelManager.getForTable(this.col_model.length, modelListBySearch);
            loadModelTable(modelRowListBySearch);
        });
        this.btn_cncl_model.addActionListener(e -> {
            this.cmb_s_model_type.setSelectedItem(null);
            this.cmb_s_model_gear.setSelectedItem(null);
            this.cmb_s_model_fuel.setSelectedItem(null);
            this.cmb_s_model_brand.setSelectedItem(null);
            loadModelTable(null);
        });
    }



    public void loadModelTable(ArrayList<Object[]> modelList) {
        this.col_model = new Object[]{"Model ID","Marka", "Model Adı","Tip","Yıl","Yakıt Türü ","Vites"};
        if(modelList ==null){
            modelList = this.modelManager.getForTable(this.col_model.length,this.modelManager.findAll());
        }

        this.createTable(this.tmdl_model, this.tbl_model, this.col_model, modelList);
    }


    public void loadBrandComponent() {
        //TODO sağ clik
        this.tableRowSelect(this.tbl_brand);


        //TODO sağ tıkla menu
        this.brand_menu = new JPopupMenu();
        brand_menu.add("Add").addActionListener(e -> {
            System.out.println("Add clicked");
            BrandView brandView = new BrandView(null);
            brandView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadBrandTable();
                    loadModelTable(null);
                    loadModelFilter();
                }
            });
        });
        brand_menu.add("Delete").addActionListener(e -> {
            if (Helper.confirm("sure")){
                int selectBrandId = this.getTableSelectedRow(tbl_brand, 0);
                if(this.brandManager.delete(selectBrandId)) {
                    Helper.showMsg("done","");
                    loadBrandTable();
                    loadModelTable(null);
                    loadModelFilter();
                    loadCarTable();

                } else {
                    Helper.showMsg("error","");
                }
            }


        });

        brand_menu.add("Update").addActionListener(e -> {
            int selectedBrandId = Integer.parseInt(tbl_brand.getValueAt(tbl_brand.getSelectedRow(),0).toString());

            BrandView brandView = new BrandView(this.brandManager.getById(selectedBrandId));
            brandView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadBrandTable();
                    loadModelTable(null);
                    loadModelFilter();
                    loadCarTable();

                }
            });
        });

        tbl_brand.setComponentPopupMenu(brand_menu);
    }


}
