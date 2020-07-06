import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sizeOfArray = scanner.nextInt();
        int[][] array = new int[sizeOfArray][sizeOfArray];
        for (int i = 0; i < sizeOfArray; i++) {
            for (int j = 0; j < sizeOfArray; j++) {
                array[i][j] = Math.abs(i - j);
            }
        }
        for (int i = 0; i < sizeOfArray; i++) {
            for (int j = 0; j < sizeOfArray; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
