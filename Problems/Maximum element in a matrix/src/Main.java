
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] array = new int[scanner.nextInt()][scanner.nextInt()];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = scanner.nextInt();
            }
        }

        int max = array[0][0];
        int indexI = 0;
        int indexJ = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > max) {
                    max = array[i][j];
                    indexI = i;
                    indexJ = j;
                }
            }
        }
        System.out.println(indexI + " " + indexJ);
    }
}