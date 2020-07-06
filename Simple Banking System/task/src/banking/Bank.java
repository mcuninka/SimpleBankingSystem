package banking;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Bank {
    Database database;
    Scanner scanner = new Scanner(System.in);
    boolean exit = true;
    boolean loggedIn = false;

    public Bank(Database database) {
        this.database = database;
    }

    public void menu() throws SQLException {
        while(exit) {
            System.out.println("1. Create an account\n" +
                    "2. Log into account\n" +
                    "0. Exit");
            String choice = scanner.nextLine();
            int realChoice = Integer.parseInt(choice);
            System.out.println();
            switch (realChoice) {
                case 1: {
                    createAccount();
                    System.out.println();
                    break;
                }
                case 2: {
                    logIntoAccount();
                    System.out.println();
                    break;
                }
                case 0: {
                    System.out.println("Bye!");
                    exit = false;
                    break;
                }
            }
        }
    }

    public void createAccount() throws SQLException {
        CreditCard creditCard = new CreditCard();
        database.insertInformation(creditCard.getId(),creditCard.getCreditNumber(),Integer.toString(creditCard.getPin()));
        System.out.printf("Your card has been created\n" +
                "Your card number:\n" +
                "%s\n" +
                "Your card PIN:\n" +
                "%d\n",creditCard.getCreditNumber(),creditCard.getPin());
    }
    public void logIntoAccount() throws SQLException {
        System.out.println("Enter your card number:");
        String cardNumber = scanner.nextLine();
        System.out.println("Enter  your PIN:");
        String strPin = scanner.nextLine();
        if(database.isExist(cardNumber,strPin)){
            System.out.println("You have successfully logged in!\n");
            loggedIn = true;
            customerInterface(cardNumber,strPin);
        } else {
            System.out.println("Wrong card number or PIN!\n");
        }
    }
    public void customerInterface(String number, String pin) throws SQLException {
        while (loggedIn) {
            try {
                System.out.println("1. Balance\n" +
                        "2. Add income\n" +
                        "3. Do transfer\n" +
                        "4. Close account\n" +
                        "5. Log out\n" +
                        "0. Exit");
                String choice = scanner.nextLine();
                int choiceInt = Integer.parseInt(choice);
                switch (choiceInt) {
                    case 1:
                        System.out.println(database.getBalance(number,pin));
                        break;
                    case 2:
                        System.out.println("Enter income:");
                        int income = scanner.nextInt();
                        int newBalance = database.getBalance(number, pin) + income;
                        database.updateBalance(newBalance, number, pin);
                        System.out.println("Income was added!");
                        System.out.println();
                        break;
                    case 3:
                        System.out.println("Transfer\n Enter card number:");
                        String nextAccount = scanner.next();
                        if (nextAccount.equals(number)) {
                            System.out.println("You can't transfer money to the same account!");
                        } else {
                            int[] creditNumberArr = new int[15];
                            int numberSum = 0;
                            for (int i = 0; i < 15; i++) {
                                creditNumberArr[i] = Integer.parseInt(String.valueOf(nextAccount.charAt(i)));
                            }
                            for (int i = 0; i < creditNumberArr.length; i++) {
                                if(i % 2 == 0) {
                                    creditNumberArr[i] *= 2;
                                }
                                if(creditNumberArr[i] > 9) {
                                    creditNumberArr[i] -= 9;
                                }
                                numberSum += creditNumberArr[i];
                            }
                            if (10 - (numberSum % 10) != Integer.parseInt(String.valueOf(nextAccount.charAt(15)))) {
                                System.out.println("Probably you made mistake in the card number. Please try again!");
                            } else {
                                List<String> cards = database.getAllAccounts();
                                boolean same = false;
                                for (String card : cards) {
                                    if (card.equals(nextAccount)) {
                                        same = true;
                                        break;
                                    }
                                }
                                if (same) {
                                    System.out.println("Such a card does not exist.”");
                                } else {
                                    System.out.println("Enter how much money you want to transfer:");
                                    int moneyToTransfer = scanner.nextInt();
                                    int balance = database.getBalance(number, pin);
                                    if (balance < moneyToTransfer) {
                                        System.out.println("Not enough money!");
                                    } else {
                                        System.out.println("Success!");
                                    }
                                }
                            }
                        }
                        break;
                    case 4:
                        database.deleteAccount(number, pin);
                        break;
                    case 5:
                        System.out.println("You have successfully logged out!\n ");
                        loggedIn = false;
                        break;
                    case 0:
                        loggedIn = false;
                        exit = false;
                        System.out.println("Bye!");
                        break;
                    default:
                        System.out.println("Try again.");
                        break;
                }
            } catch (NumberFormatException ignored){
            }
        }
    }
}