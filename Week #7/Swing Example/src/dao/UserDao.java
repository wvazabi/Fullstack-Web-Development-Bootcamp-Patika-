package dao;

import core.Database;
import entity.User;
import org.postgresql.jdbc2.ArrayAssistant;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserDao {
     private Connection connection;

     public UserDao(){
         this.connection = Database.connection();
         //Gelen Verileri user entity nesnelerine aktaracak
         //CRUD ekleme silme okuma güncelleme
     }

     public ArrayList<User> findAll() {
         ArrayList<User> users = new ArrayList<>();
         String query = "SELECT * FROM public.user";

         try {

             ResultSet rs = this.connection.createStatement().executeQuery(query);
             while(rs.next()) {
                 User user = new User();
                 user.setId(rs.getInt("id"));
                 user.setName(rs.getString("name"));
                 user.setEmail(rs.getString("email"));
                 user.setPassword(rs.getString("password"));
                 user.setType(User.Type.valueOf(rs.getString("type")));
                 user.setGender(User.Gender.valueOf(rs.getString("gender")));

                 users.add(user);
             }

         } catch (Exception e) {
             e.printStackTrace();
         }


         return users;
     }

}
