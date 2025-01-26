import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://LAPTOP-M816NVHH\\SQLEXPRESS:1433;databaseName=QLSV;encrypt=true;trustServerCertificate=true";
            String userName = "sa";
            String password = "123456789";

            Connection connection = DriverManager.getConnection(url, userName, password);
            System.out.println("Kết nối thành công");

            //test
            String sql = "select * from Khoa";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getString(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getInt(3));
            }
            System.out.println();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
