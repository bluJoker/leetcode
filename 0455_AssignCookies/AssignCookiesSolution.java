import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class AssignCookiesSolution {
    // greedy algo
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int gi = g.length - 1;
        int si = s.length - 1;
        int res = 0;

        while (gi >= 0 && si >= 0) {

            if (s[si] >= g[gi]) {
                res++;
                gi--;
                si--;
            } else {
                gi--;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] g = {1, 2};
        int[] s = {2, 1, 3};

        System.out.println(new AssignCookiesSolution().findContentChildren(g, s));

    }
}
