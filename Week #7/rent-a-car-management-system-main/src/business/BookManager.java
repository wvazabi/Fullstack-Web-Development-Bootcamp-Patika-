package business;

import core.Helper;
import dao.BookDao;
import dao.CarDao;
import entity.Book;
import entity.Car;
import entity.Model;

import java.util.ArrayList;

public class BookManager {
    private final BookDao bookDao;

    public BookManager() {
        this.bookDao = new BookDao();
    }

    public boolean save (Book book) {
        return this.bookDao.save(book);
    }

    public ArrayList<Book> getAllBookings() { return this.bookDao.getAllBooks(); }

    public Book getById (int id) { return this.bookDao.getById(id); }

    public ArrayList<Object[]> getForTable(int size, ArrayList<Book> books) {
        ArrayList<Object[]> bookList = new ArrayList<>();

        for (Book obj : books) {
            int i = 0;
            Object[] rowObject = new Object[size];
            rowObject[i++] = obj.getId();
            rowObject[i++] = obj.getCar_id();
            rowObject[i++] = obj.getCar().getModel().getBrand().getName();
            rowObject[i++] = obj.getCar().getModel().getName();
            rowObject[i++] = obj.getCar().getPlate();
            rowObject[i++] = obj.getName();
            rowObject[i++] = obj.getIdno();
            rowObject[i++] = obj.getMpno();
            rowObject[i++] = obj.getMail();
            rowObject[i++] = obj.getStrt_date();
            rowObject[i++] = obj.getFnsh_date();
            rowObject[i++] = obj.getPrc();
            rowObject[i++] = obj.getbCase();
            rowObject[i++] = obj.getNote();
            bookList.add(rowObject);
        }
        return bookList;
    }

    public boolean delete (int id) {
        if (this.getById(id) == null) {
            Helper.showMessage(id + " ID no couldn't be found!");
            return false;
        }
        return this.bookDao.delete(id);
    }

    public ArrayList<Book> getByPlate(String plate) {
        ArrayList<Book> searchedBookList;
        String selectQuery = "SELECT book.* " +
                "FROM book " +
                "INNER JOIN car ON book.book_car_id = car.car_id ";
        String whereQuery = "WHERE car.car_plate = '" + plate + "'";

        if (plate == null) {
            searchedBookList = this.bookDao.selectByQuery(selectQuery);
        } else {
            searchedBookList = this.bookDao.selectByQuery(selectQuery + whereQuery);
        }

        return searchedBookList;
    }

}
