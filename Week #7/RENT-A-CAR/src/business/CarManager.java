package business;

import core.Helper;
//import dao.BookDao;
import dao.BookDao;
import dao.CarDao;
import dao.ModelDao;
//import entity.Book;
import entity.Book;
import entity.Brand;
import entity.Car;
import entity.Model;
import org.postgresql.jdbc2.ArrayAssistant;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class CarManager {
    private final CarDao carDao;
    private final BookDao bookDao;

    public CarManager() {
        this.carDao = new CarDao();
        this.bookDao = new BookDao();

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

    public ArrayList<Car> searchForBooking(String strt_date,String fnsh_date,Model.Type type,Model.Gear gear,Model.Fuel fuel){
        String query ="SELECT * FROM public.car as c LEFT JOIN public.model as m ";

        //TODO istediğimiz şartları arraylistin içine atıyoruz. Hangi koşullarda joinlesin

        ArrayList<String> where = new ArrayList<>();
        ArrayList<String> joinWhere = new ArrayList<>();
        ArrayList<String> bookOrWhere = new ArrayList<>();

        joinWhere.add("c.car_model_id=m.model_id");

        //TODO Local date tanımlama in date 10/10/2023 veritabanı out date 2023-10-10
        strt_date = LocalDate.parse(strt_date, DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString();
        fnsh_date = LocalDate.parse(fnsh_date, DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString();

        if(fuel != null) where.add("m.model_fuel = '" + fuel.toString()+ "'");
        if(gear != null) where.add("m.model_gear = '" + gear.toString()+ "'");
        if(type != null) where.add("m.model_type = '" + type.toString()+ "'");

        //TODO birleştirme işlemi sağda solda boşluk olsun

        String whereStr = String.join(" AND ",where);
        String joinStr = String.join(" AND ",joinWhere);

        if(joinStr.length() > 0 ){
            query += " ON " + joinStr;
        }
        if(whereStr.length() > 0){
            query += " WHERE " + whereStr;
        }

        //return this.carDao.selectByQuery(query);


        ArrayList<Car> searchedCarList = this.carDao.selectByQuery(query);

        // TODO herhangi bir kiralamanın başlangıç ve bitiş tarihi ile çakışıyor mu?
        bookOrWhere.add("('" + strt_date + "' BETWEEN book_strt_date AND book_fnsh_date)");
        bookOrWhere.add("('" + fnsh_date + "' BETWEEN book_strt_date AND book_fnsh_date)");
        bookOrWhere.add("(book_strt_date BETWEEN '" + strt_date + "' AND '" + fnsh_date + "')");
        bookOrWhere.add("(book_fnsh_date BETWEEN '" + strt_date + "' AND '" + fnsh_date + "')");

        String bookOrWhereStr = String.join(" OR ", bookOrWhere);
        String bookQuery = "SELECT * FROM public.book WHERE " + bookOrWhereStr;

        // TODO kirada olan arabaları bir arrray e atıyoruz
        ArrayList<entity.Book> bookList = this.bookDao.selectByQuery(bookQuery);
        ArrayList<Integer> busyCarId = new ArrayList<>();
        for (Book book:bookList){
            busyCarId.add(book.getCar_id());

        }
        searchedCarList.removeIf(car -> busyCarId.contains(car.getId()));

        return searchedCarList;

    }

}