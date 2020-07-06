import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            String input = scanner.nextLine();
            try {
                int number = Integer.parseInt(input);
                if (number == 0) {
                    break;
                } else {
                    System.out.println(number * 10);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid user input: " + input);
            }
        }
    }
}
