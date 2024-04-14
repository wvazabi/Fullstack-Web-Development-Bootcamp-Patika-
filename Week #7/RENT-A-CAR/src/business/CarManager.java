package business;

import core.Helper;
//import dao.BookDao;
import dao.CarDao;
import dao.ModelDao;
//import entity.Book;
import entity.Brand;
import entity.Car;
import entity.Model;
import org.postgresql.jdbc2.ArrayAssistant;

import java.awt.print.Book;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class CarManager {
    private final CarDao carDao;
    //private final BookDao bookDao;

    public CarManager() {
        this.carDao = new CarDao();
        //this.bookDao = new BookDao();

    }

    public Car getById(int id) {
        return this.carDao.getById(id);
    }

    public ArrayList<Car> findAll() {
        return this.carDao.findAll();
    }

    //TODO tabloya çevirme obje listesi ile kullanma

    public ArrayList<Object[]> getForTable2(int size) {
        ArrayList<Object[]> brandRowList = new ArrayList<>();
        for (Car car : this.findAll()) {
            Object[] rowObject = new Object[size];
            int i = 0;
            rowObject[i++] = car.getId();
            rowObject[i++] = car.getColor();
            rowObject[i++] = car.getKm();
            rowObject[i++] = car.getPlate();

            brandRowList.add(rowObject);

        }
        return brandRowList;
    }

    public ArrayList<Object[]> getForTable(int size, ArrayList<Car> cars) {
        ArrayList<Object[]> carList = new ArrayList<>();
        for (Car obj : cars) {
            int i = 0;
            Object[] rowObject = new Object[size];
            rowObject[i++] = obj.getId();
            rowObject[i++] = obj.getModel().getBrand().getName();
            rowObject[i++] = obj.getModel().getName();
            rowObject[i++] = obj.getPlate();
            rowObject[i++] = obj.getColor();
            rowObject[i++] = obj.getKm();
            rowObject[i++] = obj.getModel().getYear();
            rowObject[i++] = obj.getModel().getType();
            rowObject[i++] = obj.getModel().getFuel();
            rowObject[i++] = obj.getModel().getGear();

            carList.add(rowObject);
        }
        return carList;
    }

    public boolean save(Car car) {
        if (this.getById(car.getId()) != null) {
            Helper.showMsg("error");
            return false;
        }
        return this.carDao.save(car);

    }

    public boolean update(Car car) {
        if (this.getById(car.getId()) == null) {
            Helper.showMsg(car.getId() + " ID kayıtlı model bulunamadı");
            return false;
        }
        return this.carDao.update(car);
    }

    public boolean delete(int id) {

        if (this.getById(id) == null) {
            Helper.showMsg(id + " ID kayıtlı model bulunamadı");
            return false;
        }
        return this.carDao.delete(id);
    }

}