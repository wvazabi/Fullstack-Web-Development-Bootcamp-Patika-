package business;

import dao.BrandDao;
import dao.UserDao;
import entity.Brand;
import entity.User;

import java.util.ArrayList;

public class BrandManager {

    private final BrandDao brandDao;

    public BrandManager() {
        this.brandDao = new BrandDao();
    }

    public ArrayList<Brand> findAll() {
        return this.brandDao.findAll();
    }
}
