import java.awt.print.PrinterGraphics;
import java.util.HashSet;

public class HappyNumberSolution {

    public boolean isHappy(int n) {
        int m = 0;
        int sum = 0;

        HashSet<Integer> set = new HashSet<>();

        while (n != 0) {
            m = n % 10;
            sum += m * m;


            n = n / 10;

            if (n == 0) {
                n = sum;
                System.out.println("sum = " + sum);
                if (set.contains(sum)) {
                    return false;
                } else if (sum == 1) {
                    return true;
                }
                set.add(sum);
                sum = 0;
            }
        }
        return true;
    }

    // 写法规范
    public boolean isHappy1(int n) {
        HashSet<Integer> set = new HashSet<>();

        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNext(n);
            System.out.println("n = " + n);
        }

        return n == 1;
    }

    private int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            sum += d * d;
        }
        return sum;
    }

    public static void main(String[] args) {
        int n1 = 19;
        System.out.println(new HappyNumberSolution().isHappy(n1));

        int n2 = 4;
        System.out.println(new HappyNumberSolution().isHappy1(n2));
    }
}
