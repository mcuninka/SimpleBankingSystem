import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int seatsInRow = scanner.nextInt();
        int[][] cinema = new int[rows][seatsInRow];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seatsInRow; j++) {
                boolean isValidNumber = false;
                while (!isValidNumber) {
                    int number = scanner.nextInt();
                    if (number == 0 || number == 1) {
                        cinema[i][j] = number;
                        isValidNumber = true;
                    } else {
                        System.out.println("0 = 'Available' | 1 = 'Not available'");
                    }
                }
            }
        }
        int numberOfTickets = scanner.nextInt();
        int index = 0;

        for (int i = 0; i < rows; i++) {
            int count = 0;
            for (int j = 0; j < seatsInRow; j++) {
                if (cinema[i][j] == 0) {
                    count++;
                } else {
                    count = 0;
                }
                if (count == numberOfTickets) {
                    index = i + 1;
                    break;
                }
            }
            if (index > 0) {
                break;
            }
        }
        System.out.println(index);
    }
}
