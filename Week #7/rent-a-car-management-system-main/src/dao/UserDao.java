package dao;

import core.Db;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDao {
    private final Connection con;


    public UserDao() {
        this.con = Db.getInstance();
    }

    public ArrayList<User> getAllUsers() {
        ArrayList<User> userList = new ArrayList<>();
        String query = "SELECT * from public.user";

        try {
            PreparedStatement pr = this.con.prepareStatement(query);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                userList.add(this.match(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }

    public User findByLogin(String username, String password) {
        User user = null;
        String query = "SELECT * FROM public.user WHERE user_name = ? AND user_pass = ?";

        try {
            PreparedStatement pr = this.con.prepareStatement(query);
            pr.setString(1, username);
            pr.setString(2, password);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                user = this.match(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public User match(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("user_id"));
        user.setUsername(rs.getString("user_name"));
        user.setPassword(rs.getString("user_pass"));
        user.setRole(rs.getString("user_role"));

        return user;
    }
}
