package view;

import business.BrandManager;
import core.Helper;
import entity.Brand;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BrandView extends Layout {
    private JPanel container;
    private JLabel lbl_brand;
    private JLabel lbl_brand_name;
    private JTextField fld_brand_name;
    private JButton btn_brand_save;
    private Brand brand;
    private BrandManager brandManager;


    public BrandView(Brand brand) {
        this.brandManager = new BrandManager();
        this.add(container);
        this.guiInitilaze(300, 200, "Add Brand");

        if (brand != null) {
            fld_brand_name.setText(brand.getName());
        }

        this.brand = brand;
        btn_brand_save.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_brand_name)) {
                Helper.showMsg("fill","");
            } else {
                boolean result = true;

                if (brand == null) {
                    Brand obj = new Brand(fld_brand_name.getText());
                    result = brandManager.save(obj);

                } else {
                   this.brand.setName(fld_brand_name.getText());
                   result = this.brandManager.update(this.brand);
                }

                if (result == true) {
                    Helper.showMsg("done","");
                    dispose();
                } else {
                    Helper.showMsg("error","");
                }

            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
