import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CuaHangThucPhamConnectionTest {
    private static final String URL = "jdbc:mysql://localhost:3306/cuahangthucpham";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver"); // Load JDBC Driver

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[] args) {
        try {
            Connection conn = getConnection();
            String query = "SELECT * FROM sanpham";

            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();

            System.out.printf("%-10s | %-20s | %-5s | %-10s | %-5s | %-30s | %-10s | %-10s\n",
                    "MaSP", "TenSP", "Loai", "DonViTinh", "HSDung", "MoTa", "Gia", "SoLuongTon");
            System.out.println(
                    "--------------------------------------------------------------------------------------------------------------------------");

            while (rs.next()) {
                System.out.printf("%-10s | %-20s | %-5d | %-10d | %-5d | %-30s | %-10d | %-10d\n",
                        rs.getString("MaSP"),
                        rs.getString("TenSP"),
                        rs.getInt("Loai"),
                        rs.getInt("DonViTinh"),
                        rs.getInt("HSDung"),
                        rs.getString("MoTa"),
                        rs.getInt("Gia"),
                        rs.getInt("SoLuongTon"));
            }
            System.out.println(
                    "--------------------------------------------------------------------------------------------------------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
