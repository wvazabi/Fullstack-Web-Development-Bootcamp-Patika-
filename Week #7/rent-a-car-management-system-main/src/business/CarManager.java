package business;

import core.Helper;
import dao.BookDao;
import dao.CarDao;
import entity.Book;
import entity.Car;
import entity.Model;

import java.sql.SQLOutput;
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

    public Car getById(int id) { return this.carDao.getById(id); }

    public ArrayList<Car> getAllCars() { return this.carDao.getAllCars(); }

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

    public boolean save (Car car) {
        if (this.getById(car.getId()) != null) {
            Helper.showMessage("error");
            return false;
        }
        return this.carDao.save(car);
    }

    public boolean update (Car car) {
        if (this.getById(car.getId()) == null) {
            Helper.showMessage(car.getId() + " ID no cannot be found!");
            return false;
        }
        return this.carDao.update(car);
    }

    public boolean delete (int id) {
        if (this.getById(id) == null) {
            Helper.showMessage(id + " ID no cannot be found!");
            return false;
        }
        return this.carDao.delete(id);
    }

    public ArrayList<Car> searchForBooking(String startDate, String endDate, Model.Type type, Model.Gear gear, Model.Fuel fuel) {
        String selectQuery = "SELECT * FROM public.car AS c LEFT JOIN public.model AS m";

        ArrayList<String> where = new ArrayList<>();
        ArrayList<String> joinWhere = new ArrayList<>();
        ArrayList<String> bookOrWhere = new ArrayList<>();

        joinWhere.add("c.car_model_id = m.model_id");

        startDate = LocalDate.parse(startDate, DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString();
        endDate = LocalDate.parse(endDate, DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString();

        if (fuel != null) where.add("m.model_fuel = '" + fuel.toString() + "'");
        if (gear != null) where.add("m.model_gear = '" + gear.toString() + "'");
        if (type != null) where.add("m.model_type = '" + type.toString() + "'");

        String whereStr = String.join(" AND ", where);
        String joinStr = String.join(" AND ", joinWhere);

        if (joinStr.length() > 0) {
            selectQuery += " ON " + joinStr;
        }

        if (whereStr.length() > 0) {
            selectQuery += " WHERE " + whereStr;
        }

        ArrayList<Car> searchedCarList = this.carDao.selectByQuery(selectQuery);

        bookOrWhere.add("('" + startDate + "' BETWEEN book_start_date AND book_finish_date)");
        bookOrWhere.add("('" + endDate + "' BETWEEN book_start_date AND book_finish_date)");
        bookOrWhere.add("(book_start_date BETWEEN ' " + startDate + "' AND '" + endDate + "')");
        bookOrWhere.add("(book_finish_date BETWEEN ' " + startDate + "' AND '" + endDate + "')");

        String bookOrWhereStr = String.join(" OR ", bookOrWhere);
        String bookQuery = "SELECT * FROM public.book WHERE " + bookOrWhereStr;

        ArrayList<Book> bookList = this.bookDao.selectByQuery(bookQuery);
        ArrayList<Integer> busyCarId = new ArrayList<>();

        for (Book book : bookList) {
            busyCarId.add(book.getCar_id());
        }

        searchedCarList.removeIf(car -> busyCarId.contains(car.getId()));

        return searchedCarList;
    }
}
