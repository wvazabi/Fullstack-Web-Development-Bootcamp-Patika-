package view;

import business.BrandManager;
import business.ModelManager;
import core.ComboItem;
import core.Helper;
import entity.Brand;
import entity.Model;

import javax.swing.*;

public class ModelView extends Layout{
    private JPanel container;
    private JLabel lbl_heading;
    //TODO generic yapı comboitem veriyoruz
    private JComboBox<ComboItem> cmb_brand;
    private JTextField fld_model_name;
    private JTextField fld_model_year;
    private JLabel lbl_model_type;
    private JComboBox<Model.Type> cmb_model_type;
    private JLabel fld_fuel;
    private JComboBox<Model.Fuel> cmb_fuel_type;
    private JLabel fld_gear;
    private JComboBox<Model.Gear> cmb_gear_type;
    private JButton btn_save;
    private Model model;
    private ModelManager modelManager;
    private BrandManager brandManager;

    public ModelView(Model model) {
        this.model = model;
        this.modelManager = new ModelManager();
        this.brandManager = new BrandManager();
        this.add(container);
        this.guiInitialize(300, 500);

        this.cmb_brand.setModel(new DefaultComboBoxModel());

        //TODO sistemdeki tüm brandleri geziyoruz
        for (Brand brand : this.brandManager.getAllBrands()) {
            //TODO combobox'a yeni item ekleiyor comboitem tibinde brand id kry brand name value
            this.cmb_brand.addItem(new ComboItem(brand.getId(), brand.getName()));
        }
    //TODO enum oldukları için combo item generic yapıya ihtiyaç yok
        this.cmb_fuel_type.setModel(new DefaultComboBoxModel<>(Model.Fuel.values()));
        this.cmb_gear_type.setModel(new DefaultComboBoxModel<>(Model.Gear.values()));
        this.cmb_model_type.setModel(new DefaultComboBoxModel<>(Model.Type.values()));

        if (this.model.getId() != 0) {
            this.fld_model_name.setText(this.model.getName());
            this.fld_model_year.setText(String.valueOf(this.model.getYear()));
            this.cmb_model_type.getModel().setSelectedItem(this.model.getType());
            this.cmb_gear_type.getModel().setSelectedItem(this.model.getGear());
            this.cmb_fuel_type.getModel().setSelectedItem(this.model.getFuel());
            ComboItem defaultBrand = new ComboItem(this.model.getBrand_id(), this.model.getBrand().getName());
            this.cmb_brand.getModel().setSelectedItem(defaultBrand);
        }

        this.btn_save.addActionListener(e -> {
            if (Helper.isFieldListEmpty(new JTextField[]{this.fld_model_name, this.fld_model_year})) {
                Helper.showMessage("fill");
            } else {
                boolean result;
                ComboItem selectedBrand = (ComboItem) cmb_brand.getSelectedItem();
                this.model.setName(fld_model_name.getText());
                this.model.setYear(Integer.parseInt(fld_model_year.getText()));
                this.model.setBrand_id(selectedBrand.getKey());
                this.model.setType((Model.Type) cmb_model_type.getSelectedItem());
                this.model.setFuel((Model.Fuel) cmb_fuel_type.getSelectedItem());
                this.model.setGear((Model.Gear) cmb_gear_type.getSelectedItem());

                if (this.model.getId() != 0) {
                    result = this.modelManager.update(this.model);
                } else {
                    result = this.modelManager.save(this.model);
                }

                if (result) {
                    Helper.showMessage("done");
                    dispose();
                } else {
                    Helper.showMessage("error");
                }
            }
        });
    }
}
