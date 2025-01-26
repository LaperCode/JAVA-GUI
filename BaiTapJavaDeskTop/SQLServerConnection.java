import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLServerConnection {
    public static void main(String[] args) {
        Connection conn = null;

        try {
            // Đăng ký driver (không cần thiết với driver mới)
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Sử dụng Integrated Security
            conn = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=QLSV;integratedSecurity=true;");

            if (conn != null) {
                System.out.println("Kết nối thành công tới SQL Server!");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
