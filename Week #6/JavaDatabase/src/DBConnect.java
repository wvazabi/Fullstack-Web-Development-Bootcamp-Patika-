import java.sql.*;

public class DBConnect {
    public static final String DB_URL = "jdbc:mysql://localhost/university";
    public static final String DB_USERNAME = "root";
    public static final String DB_PASSWORD = "mysql";

    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        try {
            // TODO kayıt getirme
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            st = conn.createStatement();
            //TODO Transaction
            conn.setAutoCommit(false);
// PreparedStatement ile Insert İşlemi
            PreparedStatement pr = conn.prepareStatement("INSERT INTO student (student_name,student_class) VALUES (?,?)");
            pr.setString(1, "Harry");
            pr.setString(2, "7");
            pr.executeUpdate();

            if (1 == 1) {
                throw new SQLException();
            }

// PreparedStatement ile Insert İşlemi
            pr.setString(1, "Ron");
            pr.setString(2, "1");
            pr.executeUpdate();
            conn.commit();
            conn.close();
//            ResultSet resultSet = st.executeQuery("SELECT * FROM student");
//            while (resultSet.next()) {
//                System.out.println("ID : " + resultSet.getInt("student_id"));
//                System.out.println("Adı : " + resultSet.getString("student_name"));
//                System.out.println("Sınıfı : " + resultSet.getInt("student_class"));
//                System.out.println("#################");
//            }
            // TODO kayıt eklemek
//            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
//            st = conn.createStatement();
//
//            // Statement ile Insert İşlemi
//            String updateQuery = "INSERT INTO student (student_name,student_class) VALUES ('Barış', 1)";
//            st.executeUpdate(updateQuery);
//
//            // PreparedStatement ile Insert İşlemi
//            PreparedStatement pr = conn.prepareStatement("INSERT INTO student (student_name,student_class) VALUES (?,?)");
//            pr.setString(1, "Harry");
//            pr.setString(2, "2");
//            pr.executeUpdate();

            // TODO Kayıt Güncelleme

            // Statement ile Update İşlemi
//            String updateQuery = "UPDATE student SET student_class = '1'  WHERE student_id = 3";
//            st.executeUpdate(updateQuery);
//
//            // PreparedStatement ile Update İşlemi
//            PreparedStatement pr = conn.prepareStatement("UPDATE student SET student_class = ?  WHERE student_id = ?");
//            pr.setString(1, "6");
//            pr.setInt(2, 2);
//            pr.executeUpdate();

            // TODO kayıt silme

            // Statement ile Delete İşlemi
            String updateQuery = "DELETE FROM student WHERE student_id = 4";
            st.executeUpdate(updateQuery);

            // PreparedStatement ile Delete İşlemi
            //PreparedStatement pr = conn.prepareStatement("DELETE FROM student WHERE student_id = ?");
            pr.setInt(1, 4);
            pr.executeUpdate();

            st.close();

        } catch (SQLException ex) {

            try {
                if (conn != null) {
                    conn.rollback();
                }
            }
            catch (SQLException e) {
                System.out.println(e.getMessage());
            }

                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

}