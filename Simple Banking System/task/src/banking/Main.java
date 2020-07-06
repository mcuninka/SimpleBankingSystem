package banking;

import javax.xml.crypto.Data;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        String path = "jdbc:sqlite:" + args[1];
        Database database  = new Database(path);
        Bank danskeBank = new Bank(database);
        danskeBank.menu();
        danskeBank.database.connectionClose();
    }
}