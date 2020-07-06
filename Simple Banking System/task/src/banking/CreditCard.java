package banking;

import java.util.Random;

public class CreditCard {

    private final Random random = new Random();
    private final static String iin = "400000";
    private final int customerAccountNumber;
    private final int checkDigit;
    private final int pin;
    private static int counter = 0;
    private final int id;

    public CreditCard() {
        counter++;
        this.id = counter;
        int balance = 0;
        this.customerAccountNumber = generateAccountNumber();
        this.pin = generatePinNumber();
        String temp = String.format("%s%d",iin,customerAccountNumber);
        this.checkDigit = luhnAlgorithm(temp);
        String creditNumber = getCreditNumber();
    }
    public int luhnAlgorithm(String firstFifteenDigit) {
        int[] creditNumberArr = new int[15];
        int numberSum = 0;
        for(int i = 0; i < 15 ; i++) {
            creditNumberArr[i] = Integer
                    .parseInt(String.valueOf(firstFifteenDigit.charAt(i)));
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
        return numberSum % 10 == 0 ? 0 : 10 - (numberSum % 10);
    }

    public int generateAccountNumber() {
        return (100_000_000 + random.nextInt(900_000_000));
    }
    public int generatePinNumber() {
        return (1000 + random.nextInt(9000));
    }

    public int getPin() {
        return pin;
    }

    public int getId () {
        return id;
    }

    public String getCreditNumber() {
        return String.format("%s%d%d", iin,customerAccountNumber,checkDigit);
    }
}