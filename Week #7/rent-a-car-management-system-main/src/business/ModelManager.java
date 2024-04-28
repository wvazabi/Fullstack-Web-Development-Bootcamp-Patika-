package business;

import core.Helper;
import dao.ModelDao;
import entity.Model;

import java.util.ArrayList;

public class ModelManager {
    private final ModelDao modelDao = new ModelDao();

    public Model getById (int id) { return this.modelDao.getById(id); }

    public ArrayList<Model> findAll () { return this.modelDao.getAllModels(); }

    public ArrayList<Object[]> getForTable(int size, ArrayList<Model> modelList) {
        ArrayList<Object[]> modelObjList = new ArrayList<>();
        // TODO her satırda obj göstermesi istiyor addrow object
        for (Model obj : modelList) {
            int i = 0;
            Object[] rowObject = new Object[size];
            rowObject[i++] = obj.getId();
            rowObject[i++] = obj.getBrand().getName();
            rowObject[i++] = obj.getName();
            rowObject[i++] = obj.getType();
            rowObject[i++] = obj.getYear();
            rowObject[i++] = obj.getFuel();
            rowObject[i++] = obj.getGear();
            modelObjList.add(rowObject);
        }
        return modelObjList;
    }

    public boolean save (Model model) {
        if (this.getById(model.getId()) != null) {
            Helper.showMessage("error");
            return false;
        }
        return this.modelDao.save(model);
    }

    public boolean update (Model model) {
        if (this.getById(model.getId()) == null) {
            Helper.showMessage(model.getId() + " ID no couldn't be found!");
            return false;
        }
        return this.modelDao.update(model);
    }

    public boolean delete (int id) {
        if (this.getById(id) == null) {
            Helper.showMessage(id + " ID no couldn't be found!");
            return false;
        }
        return this.modelDao.delete(id);
    }


    public ArrayList<Model> getByListBrandId (int brandId) {
        return this.modelDao.getByListBrandId(brandId);
    }

    //TODO model arama için
    public ArrayList<Model> searchForTable(int brandId, Model.Fuel fuel, Model.Gear gear, Model.Type type) {
        String select = "SELECT * FROM public.model";
        //TODO dinamik sorgu için araylist oluşturuyor
        ArrayList<String> whereList = new ArrayList<>();

        if (brandId != 0) {
            whereList.add("model_brand_id='" + brandId + "'");
        }
        if (fuel != null) {
            whereList.add("model_fuel='" + fuel.toString() + "'");
        }
        //TODO string olduğu için tırnak işareti kullanıyor
        if (gear != null) {
            whereList.add("model_gear='" + gear.toString() + "'");
        }
        if (type != null) {
            whereList.add("model_type='" + type.toString() + "'");
        }

        // where list birleştirme
        String whereStr = String.join(" AND ", whereList);
        String query = select;
        //TODO bir değer varsa
        if (whereStr.length() > 0) {
            query += " WHERE " + whereStr;
        }

        //TODO bu query ye göre vei dödürüyoruz
        return this.modelDao.selectByQuery(query);
    }

}
