import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int z1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        int z2 = scanner.nextInt();

        int[] box1 = {x1, y1, z1};
        int[] box2 = {x2, y2, z2};

        Arrays.sort(box1);
        Arrays.sort(box2);

        if (box1[0] == box2[0] && box1[1] == box2[1] && box1[2] == box2[2]) {
            System.out.println("Box 1 = Box 2");
        } else if (box1[0] >= box2[0] && box1[1] >= box2[1] && box1[2] >= box2[2]) {
            System.out.println("Box 1 > Box 2");
        } else if (box1[0] <= box2[0] && box1[1] <= box2[1] && box1[2] <= box2[2]) {
            System.out.println("Box 1 < Box 2");
        } else {
            System.out.println("Incomparable");
        }
    }
}