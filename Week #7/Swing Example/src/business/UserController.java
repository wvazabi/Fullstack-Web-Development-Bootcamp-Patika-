package business;

import dao.UserDao;
import entity.User;

import java.util.ArrayList;

public class UserController {
    private UserDao userDao;

    public UserController(){
        this.userDao = new UserDao();
    }

    public ArrayList<User> findAll() {
        return this.userDao.findAll();
    }
}
