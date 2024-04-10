package business;

import dao.UserDao;
import entity.User;

public class UserManager {
    private final UserDao userDao;

    public UserManager() {
        this.userDao = new UserDao();
    }

    public User findByLogin(String username, String password) {
        //different methods can be use
        return this.userDao.findByLogin(username,password);
    }
}
