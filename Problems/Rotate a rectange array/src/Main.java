import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int[][] array = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                array[i][j] = scanner.nextInt();
            }
        }
        int[][] array2 = new int[y][x];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                array2[i][j] = array[j][i];
            }
        }

        for (int i = 0; i < y; i++) {
            for (int j = x - 1; j >= 0; j--) {
                System.out.print(array2[i][j] + " ");
            }
            System.out.println();
        }
    }
}
