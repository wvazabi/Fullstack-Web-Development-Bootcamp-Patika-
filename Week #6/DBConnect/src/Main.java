import java.sql.*;
import java.util.Scanner;

public class DBConnect {
    public static final String DB_URL = "jdbc:mysql://localhost/patika";
    public static final String DB_USERNAME = "admin";
    public static final String DB_PASSWORD = "111111";

    public static void insertData(PreparedStatement pr, String name, String position, double salary) throws SQLException {

        pr.setString(1, name);
        pr.setString(2, position);
        pr.setDouble(3, salary);
        pr.executeUpdate();
        System.out.println("Veri başarıyla eklendi.");
        pr.close();

    }

    public static void readData(ResultSet st) throws SQLException {
        System.out.println("\n--------------------------------------------------------------------");
        System.out.println("| ID | Adı-Soyad                 | Pozisyon        | Maaş            |");
        System.out.println("----------------------------------------------------------------------");
        while (st.next()){
            System.out.printf("| %-2d | %-25s | %-15s | %-15f | \n",
                    st.getInt("employees_id"), st.getString("employees_name"), st.getString("employees_position"), st.getDouble("employees_salary"));
        }

    }

    public static void updateData(PreparedStatement pr, String name, String position, double salary, int getID) throws SQLException {

        pr.setString(1, name);
        pr.setString(2, position);
        pr.setDouble(3, salary);
        pr.setInt(4, getID);
        pr.executeUpdate();
        System.out.println("Veri başarıyla güncellendi.");
        pr.close();

    }

    public static void main(String[] args) {
        Connection connect = null;
        Statement st = null;
        Scanner scanner = new Scanner(System.in);
        String name, position;
        double salary;

        try {
            connect = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            connect.setAutoCommit(false);
            PreparedStatement pr = null;

            while (true) {
                System.out.println("Yapmak istediğiniz işlemi seçiniz.");
                System.out.println("1- Kayıt Ekle\n2- Kayıtları Oku\n3- Kayıt Sil\n4- Kayıt Güncelle\n5- Çıkış Yap");
                System.out.print("Seçiminiz : ");
                int select = scanner.nextInt();
                int getID;

                switch (select) {
                    case 1:
                        pr = connect.prepareStatement("INSERT INTO employees (employees_name, employees_position, employees_salary) VALUES (?,?,?)");
                        System.out.print("Çalışan Ad Soyad : ");
                        scanner.nextLine();
                        name = scanner.nextLine();
                        System.out.print("Pozisyonu : ");
                        position = scanner.nextLine();
                        System.out.print("Maaşı : ");
                        salary = scanner.nextDouble();
                        insertData(pr, name, position, salary);
                        connect.commit();
                        break;
                    case 2:
                        st = connect.createStatement();
                        ResultSet resultSet = st.executeQuery("SELECT * FROM employees");
                        readData(resultSet);
                        st.close();
                        break;
                    case 3:
                        pr = connect.prepareStatement("DELETE FROM `employees` WHERE `employees_id` = ?");
                        System.out.print("Silmek istediğiniz ID giriniz : ");
                        getID = scanner.nextInt();
                        pr.setInt(1,getID);
                        pr.executeUpdate();
                        System.out.println(getID + " ID'li çalışan başarıyla silindi.");
                        pr.close();
                        connect.commit();
                        break;
                    case 4:
                        pr = connect.prepareStatement("UPDATE `employees` SET `employees_name` = ?, `employees_position` = ?, `employees_salary` = ? WHERE `employees_id` = ?");
                        System.out.print("Güncellemek istediğiniz ID giriniz : ");
                        getID = scanner.nextInt();
                        System.out.print("Çalışan Ad Soyad : ");
                        scanner.nextLine();
                        name = scanner.nextLine();
                        System.out.print("Pozisyonu : ");
                        position = scanner.nextLine();
                        System.out.print("Maaşı : ");
                        salary = scanner.nextDouble();
                        updateData(pr, name, position, salary, getID);
                        connect.commit();
                        break;
                    case 5:
                        System.out.println("Çıkış yapıldı.");
                        return;
                }
            }


        } catch (SQLException e) {
            if (connect != null) {
                try {
                    connect.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            System.out.println(e.getMessage());
        }
    }
}