import java.sql.*;

public class BankTransaction {
    private static final String DB_URL = "jdbc:sqlite:bank.db"; // Use your DB URL
    private static final String DEBIT_SQL = "UPDATE accounts SET balance = balance - ? WHERE id = ?";
    private static final String CREDIT_SQL = "UPDATE accounts SET balance = balance + ? WHERE id = ?";

    public static void main(String[] args) {
        int fromAccount = 1;
        int toAccount = 2;
        double amount = 100.0;

        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            conn.setAutoCommit(false);

            try (
                PreparedStatement debitStmt = conn.prepareStatement(DEBIT_SQL);
                PreparedStatement creditStmt = conn.prepareStatement(CREDIT_SQL)
            ) {
                // Debit
                debitStmt.setDouble(1, amount);
                debitStmt.setInt(2, fromAccount);
                debitStmt.executeUpdate();

                // Credit
                creditStmt.setDouble(1, amount);
                creditStmt.setInt(2, toAccount);
                creditStmt.executeUpdate();

                conn.commit();
                System.out.println("Transfer successful.");

            } catch (SQLException e) {
                System.out.println("Transaction failed. Rolling back.");
                conn.rollback();
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}