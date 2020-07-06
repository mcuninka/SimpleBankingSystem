package banking;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {

    private final Connection con;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public Database(String url) throws SQLException {
        this.con = DriverManager.getConnection(url);
        DatabaseMetaData meta = con.getMetaData();
        resultSet = meta.getTables(null,null,"card",null);
        if(!resultSet.next()) {
            Statement statement = con.createStatement();
            String tableContent =  "CREATE TABLE card " +
                    " (id INTEGER not NULL ," +
                    " number TEXT," +
                    " pin TEXT,"    +
                    " balance INTEGER DEFAULT 0)";
            statement.executeUpdate(tableContent);
        }
        resultSet.close();
    }

    public void insertInformation(int idNumber, String accountNumber, String accountPin) throws SQLException {
        this.preparedStatement = con.prepareStatement("INSERT INTO card(id, number, pin) " +
                "VALUES(?, ?, ?)");
        this.preparedStatement.setInt(1,idNumber);
        this.preparedStatement.setString(2,accountNumber);
        this.preparedStatement.setString(3,accountPin);
        this.preparedStatement.executeUpdate();
    }
    public boolean isExist(String account, String accountPin) throws SQLException {
        this.preparedStatement = con.prepareStatement("select *  from card WHERE pin =? AND number = ?");
        preparedStatement.setString(1,accountPin);
        preparedStatement.setString(2,account);
        resultSet = preparedStatement.executeQuery();
        return resultSet.next();
    }

    public void retrieveInformation(String account, String accountPin) throws SQLException {
        this.preparedStatement = con.prepareStatement("select id, number, pin, balance from card WHERE pin = ? AND number = ?" );
        preparedStatement.setString(1,accountPin);
        preparedStatement.setString(2,account);
        resultSet = preparedStatement.executeQuery();
        while(resultSet.next()) {
            int id  = resultSet.getInt("id");
            String accountNumber = resultSet.getString("number");
            String pin = resultSet.getString("pin");
            int balance = resultSet.getInt("balance");
            System.out.println("ID: " + id);
            System.out.println("Account number: " + accountNumber);
            System.out.println("Pin: " + pin);
            System.out.println("Balance: " + balance);
            resultSet.close();
        }
    }

    public List<String> getAllAccounts() throws SQLException {
        List<String> allCards = new ArrayList<>();
        this.preparedStatement = con.prepareStatement("select number from card");
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String accountNumber = resultSet.getString("number");
            allCards.add(accountNumber);
        }
        return allCards;
    }

    public int getBalance(String account, String accountPin) throws SQLException {
        this.preparedStatement = con.prepareStatement("select balance from card WHERE number = ? AND pin = ?");
        preparedStatement.setString(1,account);
        preparedStatement.setString(2,accountPin);
        resultSet = preparedStatement.executeQuery();
        int balance = resultSet.getInt("balance");
        preparedStatement.close();
        return balance;
    }

    public void updateBalance (int balance, String account, String accountPin) throws SQLException {
        this.preparedStatement = con.prepareStatement("UPDATE card SET balance = ? WHERE  pin = ? AND number = ? " );
        preparedStatement.setInt(1,balance);
        preparedStatement.setString(2,accountPin);
        preparedStatement.setString(3,account);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public void deleteAccount (String account, String accountPin) throws SQLException {
        this.preparedStatement = con.prepareStatement("DELETE FROM card WHERE number = ? AND pin = ?");
        preparedStatement.setString(1,account);
        preparedStatement.setString(2, accountPin);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public void connectionClose() throws SQLException {
        con.close();
    }
}