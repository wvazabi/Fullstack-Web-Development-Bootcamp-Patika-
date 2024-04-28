package view;

import business.BookManager;
import business.BrandManager;
import business.CarManager;
import business.ModelManager;
import core.ComboItem;
import core.Helper;
import entity.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.util.ArrayList;

public class AdminView extends Layout{
    private JPanel container;
    private JLabel lbl_welcome;
    private JPanel pnl_top;
    private JTabbedPane tab_menu;
    private JButton btn_logout;
    private JPanel pnl_brand;
    private JScrollPane scrl_brand;
    private JTable tbl_brand;
    private JPanel pnl_model;
    private JScrollPane scrl_model;
    private JTable tbl_model;
    private JLabel lbl_brand;
    private JLabel lbl_type;
    private JLabel lbl_fuel;
    private JLabel lbl_gear;
    private JComboBox cmb_brand;
    private JComboBox cmb_type;
    private JComboBox cmb_fuel;
    private JComboBox cmb_gear;
    private JButton btn_search;
    private JButton btn_clear;
    private JPanel pnl_car;
    private JTable tbl_car;
    private JScrollPane scrl_car;
    private JPanel pnl_book;
    private JLabel lbl_book_start;
    private JLabel lbl_book_finish;
    private JLabel lbl_book_gear;
    private JLabel lbl_book_fuel;
    private JLabel lbl_book_type;
    private JComboBox cmb_book_gear;
    private JComboBox cmb_book_fuel;
    private JComboBox cmb_book_type;
    private JButton btn_find;
    private JTable tbl_booking;
    private JPanel pnl_search;
    //TODO Formatlanabilir text fieldlar bunun içine format ataması yapabiliriz
    private JFormattedTextField fld_end_date;
    private JFormattedTextField fld_start_date;
    private JScrollPane scrl_booking;
    private JButton btn_clear_book_fltr;
    private JPanel pnl_reservation;
    private JScrollPane scrl_reservations;
    private JTable tbl_reservations;
    private JComboBox cmb_plate;
    private JPanel pnl_plate_filter;
    private JLabel fld_plate;
    private JButton btn_plate_clear;
    private JButton btn_plate_search;
    private User user;

    // TODO tablolarda işlem yapabilmemiz için table modellere ihtiyaç var
    private DefaultTableModel tmdl_brand = new DefaultTableModel();
    private DefaultTableModel tmdl_model = new DefaultTableModel();
    private DefaultTableModel tmbdl_car = new DefaultTableModel();
    private DefaultTableModel tmdl_booking = new DefaultTableModel();
    private DefaultTableModel tmdl_reservation = new DefaultTableModel();

    private BrandManager brandManager;
    private ModelManager modelManager;
    private JPopupMenu brand_menu;
    private JPopupMenu model_menu;
    private JPopupMenu car_menu;
    private JPopupMenu booking_menu;
    private JPopupMenu reservation_menu;
    private Object[] col_model;
    private Object[] col_booking_list;
    private Object[] col_car;
    private CarManager carManager;
    private BookManager bookManager;

    public AdminView(User user) {
        this.brandManager = new BrandManager();
        this.modelManager = new ModelManager();
        this.carManager = new CarManager();
        this.bookManager = new BookManager();
        this.add(container);
        this.guiInitialize(1000, 500);
        this.user = user;

        if (this.user == null) {
            dispose();
        }

        this.lbl_welcome.setText("Welcome " + this.user.getUsername() + " !");

        loadComponent();

        loadBrandTable();
        loadBrandComponent();

        loadModelTable(null);
        loadModelComponent();
        loadModelFilter();

        loadCarTable();
        loadCarComponent();

        loadBookingTable(null);
        loadBookingComponent();
        loadBookingFilter();

        loadReservationTable(null);
        loadReservationComponent();
        loadReservationFilter();

    }

    private void loadComponent() {
        this.btn_logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                LoginView loginView = new LoginView();
            }
        });
    }

    private void loadBookingComponent() {
        tableRowSelect(this.tbl_booking);
        this.booking_menu = new JPopupMenu();
        this.booking_menu.add("Make Reservation").addActionListener(e -> {
            int selectCarId = this.getTableSelectedRow(this.tbl_booking, 0);
            BookingView bookingView = new BookingView(
                    this.carManager.getById(selectCarId),
                    this.fld_start_date.getText(),
                    this.fld_end_date.getText()
                    );
            bookingView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadBookingTable(null);
                    loadBookingFilter();
                    loadBookingTable(null);
                    loadReservationTable(null);
                }
            });
        });
        this.tbl_booking.setComponentPopupMenu(booking_menu);

        // TODO araç bulma algoritması
        btn_find.addActionListener(e -> {
            //TODO car managerdan yapılıyor arabalarla ilgili olduğu için araba döndüren array var filtrelenen arabaları
            // alıp obje şeklinde tabloya göndermek için
            ArrayList<Car> carList = this.carManager.searchForBooking(
                    fld_start_date.getText(),
                    fld_end_date.getText(),
                    (Model.Type) cmb_book_type.getSelectedItem(),
                    (Model.Gear) cmb_book_gear.getSelectedItem(),
                    (Model.Fuel) cmb_book_fuel.getSelectedItem()
            );

            ArrayList<Object[]> carBookingRow = this.carManager.getForTable(this.col_car.length, carList);
            loadBookingTable(carBookingRow);
        });

        //TODO clear search
        btn_clear_book_fltr.addActionListener(e -> {
            loadBookingFilter();
        });
    }

    private void loadBookingTable(ArrayList<Object[]> carList) {
        Object[] col_booking_list = new Object[]{"ID", "Brand", "Model", "Plate", "Color", "Km", "Year", "Type", "Fuel", "Gear"};
        createTable(this.tmdl_booking, this.tbl_booking, col_booking_list, carList);
    }

    public void loadBookingFilter() {
        this.cmb_book_type.setModel(new DefaultComboBoxModel<>(Model.Type.values()));
        this.cmb_book_type.setSelectedItem(null);
        this.cmb_book_gear.setModel(new DefaultComboBoxModel<>(Model.Gear.values()));
        this.cmb_book_gear.setSelectedItem(null);
        this.cmb_book_fuel.setModel(new DefaultComboBoxModel<>(Model.Fuel.values()));
        this.cmb_book_fuel.setSelectedItem(null);
    }

    private void loadCarComponent() {
        tableRowSelect(this.tbl_car);
        this.car_menu = new JPopupMenu();
        this.car_menu.add("New").addActionListener(e -> {
            CarView carView = new CarView(new Car());
            carView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadCarTable();
                }
            });
        });
        this.car_menu.add("Update").addActionListener(e -> {
            int selectModelId = this.getTableSelectedRow(tbl_car, 0);
            CarView carView = new CarView(this.carManager.getById(selectModelId));
            carView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadCarTable();
                    loadReservationTable(null);
                    loadBookingTable(null);
                }
            });
        });
        this.car_menu.add("Delete").addActionListener(e -> {
            if (Helper.confirm("sure")) {
                int selectCarId = this.getTableSelectedRow(tbl_car, 0);
                if (this.carManager.delete(selectCarId)) {
                    Helper.showMessage("done");
                    loadCarTable();
                    loadReservationComponent();
                    loadBookingTable(null);
                } else {
                    Helper.showMessage("error");
                }
            }
        });
        this.tbl_car.setComponentPopupMenu(car_menu);
    }

    private void loadCarTable() {
        col_car = new Object[]{"ID", "Brand", "Model", "Plate", "Color", "KM", "Year", "Type", "Fuel", "Gear"};
        ArrayList<Object[]> carList = this.carManager.getForTable(col_car.length, this.carManager.getAllCars());
        createTable(this.tmbdl_car, this.tbl_car, col_car, carList);

    }

    private void loadModelComponent() {
        tableRowSelect(this.tbl_model);
        this.model_menu = new JPopupMenu();
        this.model_menu.add("New").addActionListener(e -> {
            ModelView modelView = new ModelView(new Model());
            modelView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadModelTable(null);
                }
            });
        });
        this.model_menu.add("Update").addActionListener(e -> {
            int selectModelId = this.getTableSelectedRow(tbl_model, 0);
            ModelView modelView = new ModelView(this.modelManager.getById(selectModelId));
            modelView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadModelTable(null);
                    loadReservationTable(null);
                    loadBookingTable(null);
                }
            });
        });
        this.model_menu.add("Delete").addActionListener(e -> {
            if (Helper.confirm("sure")) {
                int selectModelId = this.getTableSelectedRow(tbl_model, 0);
                if (this.modelManager.delete(selectModelId)) {
                    Helper.showMessage("done");
                    loadModelTable(null);
                    loadBookingTable(null);
                    loadReservationTable(null);
                } else {
                    Helper.showMessage("error");
                }
            }
        });

        this.tbl_model.setComponentPopupMenu(this.model_menu);

        //TODO filtlereme yapılıyor butona tıklanıldığında
        this.btn_search.addActionListener(e -> {
            ComboItem selectedBrand = (ComboItem) this.cmb_brand.getSelectedItem();
            int brandId = 0;
            //TODO boş search ettiğinde proplemler olmasması için
            if (selectedBrand != null) {
                brandId = selectedBrand.getKey();
            }
            ArrayList<Model> modelListBySearch = this.modelManager.searchForTable(
                    brandId,
                    (Model.Fuel) cmb_fuel.getSelectedItem(),
                    (Model.Gear) cmb_gear.getSelectedItem(),
                    (Model.Type) cmb_type.getSelectedItem()
            );
            //TODO loadModelTable da göresilmesini istediğimiz datayı veriyoruz
            ArrayList<Object[]> modelRowListBySearch = this.modelManager.getForTable(this.col_model.length, modelListBySearch);
            //TODO null yerine modelRowListBySearch veriliyor
            loadModelTable(modelRowListBySearch);
        });

        //TODO arama filtreleri cancel olduğu zaman sıfırlanıyor
        this.btn_clear.addActionListener(e ->  {
            this.cmb_type.setSelectedItem(null);
            this.cmb_gear.setSelectedItem(null);
            this.cmb_fuel.setSelectedItem(null);
            this.cmb_brand.setSelectedItem(null);
        });
    }

    public void loadBrandComponent() {
        tableRowSelect(this.tbl_brand);
        this.brand_menu = new JPopupMenu();
        this.brand_menu.add("New").addActionListener(e -> {
            BrandView brandView = new BrandView(new Brand());
            brandView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadBrandTable();
                    loadModelTable(null);
                    loadModalFilterBrand();
                }
            });
        });
        this.brand_menu.add("Update").addActionListener(e -> {
            int selectId = this.getTableSelectedRow(tbl_brand, 0);
            BrandView brandView = new BrandView(this.brandManager.getById(selectId));
            brandView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadBrandTable();
                    loadModelTable(null);
                    loadModalFilterBrand();
                    loadReservationTable(null);
                    loadBookingTable(null);
                }
            });
        });
        this.brand_menu.add("Delete").addActionListener(e -> {
            if (Helper.confirm("sure")) {
                int selectId = this.getTableSelectedRow(tbl_brand, 0);
                if (this.brandManager.delete(selectId)) {
                    Helper.showMessage("done");
                    loadBrandTable();
                    loadModelTable(null);
                    loadModalFilterBrand();
                    loadBookingTable(null);
                } else {
                    Helper.showMessage("error");
                }
            }
        });

        this.tbl_brand.setComponentPopupMenu(this.brand_menu);
    }

    public void loadModelTable(ArrayList<Object[]> modelList) {
        this.col_model = new Object[]{"Model ID", "Brand", "Model", "Type", " Year", "Fuel Type", "Gear"};
        //TODO bir değere göndermessek filtreleme olamdan listeleme
        if (modelList == null) {
            modelList = this.modelManager.getForTable(this.col_model.length, this.modelManager.findAll());
        }
        createTable(this.tmdl_model, this.tbl_model, col_model, modelList);
    }

    public void loadModelFilter() {
        //TODO ilk seçilen itemları null'a çekiyoruz
        this.cmb_type.setModel(new DefaultComboBoxModel<>(Model.Type.values()));
        this.cmb_type.setSelectedItem(null);

        this.cmb_gear.setModel(new DefaultComboBoxModel<>(Model.Gear.values()));
        this.cmb_gear.setSelectedItem(null);

        this.cmb_fuel.setModel(new DefaultComboBoxModel<>(Model.Fuel.values()));
        this.cmb_fuel.setSelectedItem(null);

        loadModalFilterBrand();
    }

    public void loadModalFilterBrand() {
        this.cmb_brand.removeAllItems();
        for (Brand obj : brandManager.getAllBrands()) {
            this.cmb_brand.addItem(new ComboItem(obj.getId(), obj.getName()));
        }
        this.cmb_brand.setSelectedItem(null);
    }

    public void loadBrandTable() {
        Object[] col_brand = {"Brand ID", "Brand Name"};
        // TODO tablnun kolonları belirlenmesi için
        ArrayList<Object[]> brandList = this.brandManager.getForTable(col_brand.length);
        this.createTable(this.tmdl_brand, this.tbl_brand, col_brand, brandList);
    }

    //TODO tarih text fieldları formatlanabilir text formatında yazılması
    private void createUIComponents() throws ParseException {
        this.fld_start_date = new JFormattedTextField(new MaskFormatter("##/##/####"));
        this.fld_start_date.setText("10/10/2023");
        this.fld_end_date = new JFormattedTextField(new MaskFormatter("##/##/####"));
        this.fld_end_date.setText("16/10/2023");
    }

    private void loadReservationTable(ArrayList<Object[]> carList) {
        this.col_booking_list = new Object[]{"ID", "Car ID", "Brand", "Model", "Plate", "Name", "ID Number", "Phone Number", "E-Mail", "Start Date", "End Date", "Price", "Status", "Note"};
        if (carList == null) {
            carList = this.bookManager.getForTable(this.col_booking_list.length, this.bookManager.getAllBookings());
        }
        createTable(this.tmdl_reservation, this.tbl_reservations, col_booking_list, carList);
    }

    public void loadReservationComponent() {
        tableRowSelect(this.tbl_reservations);
        this.reservation_menu = new JPopupMenu();
        this.reservation_menu.add("Delete").addActionListener(e -> {
            if (Helper.confirm("sure")) {
                int selectId = this.getTableSelectedRow(tbl_reservations, 0);
                if (this.bookManager.delete(selectId)) {
                    Helper.showMessage("done");
                    loadReservationTable(null);
                    loadModelTable(null);
                    loadModalFilterBrand();
                    loadBookingTable(null);
                } else {
                    Helper.showMessage("error");
                }
            }
        });

        this.tbl_reservations.setComponentPopupMenu(this.reservation_menu);
    }

    public void loadReservationFilter() {
        this.cmb_plate.removeAllItems();
        for (Car obj : carManager.getAllCars()) {
            this.cmb_plate.addItem(new ComboItem(obj.getPlate()));
        }
        this.cmb_plate.setSelectedItem(null);

        btn_plate_search.addActionListener(e -> {
            ArrayList<Book> carPlateList;
            if (cmb_plate.getSelectedItem() == null) {  carPlateList = this.bookManager.getByPlate(null);
            } else {carPlateList = this.bookManager.getByPlate(cmb_plate.getSelectedItem().toString());}

            ArrayList<Object[]> carBookingRow = this.bookManager.getForTable(this.col_booking_list.length, carPlateList);
            loadReservationTable(carBookingRow);
        });

        btn_plate_clear.addActionListener(e -> {
            loadReservationFilter();
        });
    }
}
