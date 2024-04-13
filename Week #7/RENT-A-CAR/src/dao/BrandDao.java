package dao;

import core.Db;
import entity.Brand;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

    //TODO save boolean çünkü ya başarılıdır ya başarısızdır
    public boolean save(Brand brand) {
        String query = "INSERT INTO public.brand (brand_name) VALUES (?)";


        try {
            PreparedStatement pr = this.CON.prepareStatement(query);
            pr.setString(1,brand.getName());
            return pr.executeUpdate() != -1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean update(Brand brand){
        String query="UPDATE public.brand SET brand_name = ? WHERE brand_id = ?";
        try{
            PreparedStatement pr = this.CON.prepareStatement(query); {
                pr.setString(1,brand.getName());
                pr.setInt(2,brand.getId());
                return pr.executeUpdate() != -1;
            }
        }catch (SQLException e){
            e.printStackTrace();
            return true;
        }

    }

    public Brand getById(int id){
        Brand obj=null;
        String query ="SELECT * FROM public.brand WHERE brand_id = ?";
        try {
            PreparedStatement pr = CON.prepareStatement(query);
            pr.setInt(1,id);
            ResultSet rs =  pr.executeQuery();
            if(rs.next()){
                obj = this.match(rs);


            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return obj;

    }
    public Brand match(ResultSet resultSet) throws SQLException {
        Brand brand = new Brand();
        brand.setId(resultSet.getInt("brand_id"));
        brand.setName(resultSet.getString("brand_name"));
        return brand;
    }



}
