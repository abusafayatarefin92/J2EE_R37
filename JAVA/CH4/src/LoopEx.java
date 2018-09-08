public class LoopEx {

    public static void main(String[] args) {
        int sn = 1;
        int en = 10;
        int sum = 0;

        for (sn = 1; sn <= en; sn++) {
            sum += sn;
        }

        System.out.println("Sum of 1 to 10 is: " + sum);
    }
}
