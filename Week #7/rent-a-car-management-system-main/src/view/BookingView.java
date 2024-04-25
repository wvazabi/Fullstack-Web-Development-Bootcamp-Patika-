package view;

import business.BookManager;
import core.Helper;
import entity.Book;
import entity.Car;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BookingView extends Layout{
    private JPanel container;
    private JLabel lbl_reservation;
    private JLabel lbl_vehicle;
    private JTextField fld_book_name;
    private JLabel lbl_book_name;
    private JTextField fld_id_no;
    private JLabel lbl_id_no;
    private JTextField fld_phone_no;
    private JLabel lbl_phone_no;
    private JTextField fld_mail;
    private JLabel lbl_mail;
    private JTextField fld_start_date;
    private JLabel lbl_start_date;
    private JTextField fld_end_date;
    private JLabel lbl_end_date;
    private JTextField fld_price;
    private JLabel lbl_price;
    private JLabel lbl_note;
    private JTextArea fld_note;
    private JButton btn_save;
    private Car car;
    private BookManager bookManager;

    public BookingView(Car selectedCar, String startDate, String finishDate) {
        this.car = selectedCar;
        this.bookManager = new BookManager();

        this.add(container);
        guiInitialize(300,600);

        lbl_vehicle.setText("Vehicle: " + this.car.getPlate() +
                " / " + this.car.getModel().getBrand().getName() +
                " / " + this.car.getModel().getName());

        this.fld_start_date.setText(startDate);
        this.fld_end_date.setText(finishDate);

        btn_save.addActionListener(e -> {
            JTextField[] checkFieldList = {
                    this.fld_book_name,
                    this.fld_mail,
                    this.fld_id_no,
                    this.fld_price,
                    this.fld_phone_no,
                    this.fld_start_date,
                    this.fld_end_date
            };

            if (Helper.isFieldListEmpty(checkFieldList)) {
                Helper.showMessage("fill");
            } else {
                Book book = new Book();
                book.setbCase("done");
                book.setCar_id(this.car.getId());
                book.setName(this.fld_book_name.getText());
                book.setStrt_date(LocalDate.parse(startDate, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                book.setFnsh_date(LocalDate.parse(finishDate, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                book.setIdno(this.fld_id_no.getText());
                book.setMpno(this.fld_phone_no.getText());
                book.setMail(this.fld_mail.getText());
                book.setNote(this.fld_note.getText());
                book.setPrc(Integer.parseInt(this.fld_price.getText()));

                if (this.bookManager.save(book)) {
                    Helper.showMessage("done");
                    dispose();
                } else {
                    Helper.showMessage("error");
                }
            }
        });

    }
}
