import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] array = new String[4];

        for (int i = 0; i < 4; i++) {
            array[i] = scanner.next();
        }
        boolean result = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (array[i].charAt(j) == array[i + 1].charAt(j) && array[i].charAt(j) == array[i].charAt(j + 1) &&
                        array[i].charAt(j) == array[i + 1].charAt(j + 1)) {
                    result = true;
                    break;
                }
            }
        }
        System.out.println(result ? "NO" : "YES");
    }
}