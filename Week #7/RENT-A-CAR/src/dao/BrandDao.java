package dao;

import core.Db;
import entity.Brand;
import entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BrandDao {
    private final Connection CON;

    public BrandDao() {
        this.CON = Db.getInstance();

    }

    public ArrayList<Brand> findAll(){
        ArrayList<Brand> brandArrayList = new ArrayList<>();
        String query = "SELECT * FROM public.brand";
        try {
            ResultSet resultSet = this.CON.createStatement().executeQuery(query);
            while (resultSet.next()){
                brandArrayList.add(this.match(resultSet));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return brandArrayList;
    }

    public Brand match(ResultSet resultSet) throws SQLException {
        Brand brand = new Brand();
        brand.setId(resultSet.getInt("brand_id"));
        brand.setName(resultSet.getString("brand_name"));
        return brand;
    }



}
