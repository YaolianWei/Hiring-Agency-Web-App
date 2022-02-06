import java.sql.SQLException;

public class Main {
    public static void main(String[] args){
        DatabaseConnection con = new DatabaseConnection();
        try {
            con.initialize();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
