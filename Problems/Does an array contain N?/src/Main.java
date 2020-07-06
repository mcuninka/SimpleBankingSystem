import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] numbers = new int[length];
        boolean result = false;

        for (int i = 0; i < length; i++) {
            numbers[i] = sc.nextInt();
        }
        int numberToCheck = sc.nextInt();
        for (int num : numbers) {
            if (num == numberToCheck) {
                result = true;
                break;
            }
        }
        System.out.println(result ? "true" : "false");
    }
}