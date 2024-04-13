package view;

import entity.Brand;

import javax.swing.*;

public class BrandView extends Layout{
    private JPanel container;
    private JLabel lbl_brand;
    private JLabel lbl_brand_name;
    private JTextField fld_brand_name;
    private JButton btn_brand_save;
    private Brand brand;

    public BrandView(Brand brand) {
        this.add(container);
        this.guiInitilaze(300,200,"Add Brand");
        this.brand = brand;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
