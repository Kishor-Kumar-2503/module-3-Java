import java.sql.*;

public class StudentDAO {
    private Connection conn;

    public StudentDAO(String dbURL) throws SQLException {
        conn = DriverManager.getConnection(dbURL);
    }

    public void insertStudent(int id, String name, int age) throws SQLException {
        String sql = "INSERT INTO students (id, name, age) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setInt(3, age);
            pstmt.executeUpdate();
        }
    }

    public void updateStudentAge(int id, int newAge) throws SQLException {
        String sql = "UPDATE students SET age = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, newAge);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
        }
    }
}