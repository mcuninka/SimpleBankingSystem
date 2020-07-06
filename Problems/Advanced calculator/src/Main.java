/* Please, do not rename it */
class Problem {

    public static void main(String[] args) {
        String operator = args[0];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        switch (operator) {
            case "MAX":
                for (int i = 1; i < args.length; i++) {
                    int number = Integer.parseInt(args[i]);
                    if (number > max) {
                        max = number;
                    }
                }
                System.out.println(max);
                break;
            case "MIN":
                for (int i = 1; i < args.length; i++) {
                    int number = Integer.parseInt(args[i]);
                    if (number < min) {
                        min = number;
                    }
                }
                System.out.println(min);
                break;
            case "SUM":
                for (int i = 1; i < args.length; i++) {
                    int number = Integer.parseInt(args[i]);
                    sum += number;
                }
                System.out.println(sum);
                break;
            default:
                System.out.println("Unknown operator");
        }
    }
}