import java.util.ArrayList;
import java.util.List;

public class CombinationsSolution {

    List<List<Integer>> res;
    List<Integer> list;

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        list = new ArrayList<>();

        if (n <= 0 || k <= 0 || n < k) {
            return res;
        }

        generateCombinations(n, k, 1, list);
        return res;
    }

    // 求解C(n, k)，当前已经找到的组合存储在list中，需要从start开始搜索新的元素
    private void generateCombinations(int n, int k, int start, List<Integer> list) {

        System.out.println(start + ":" + list + "i<=" + (n - (k - list.size()) + 1));
        if (k == list.size()) {
            res.add(new ArrayList<>(list));
            return;
        }

        // 还有k-list.size()个空位，则下面要从start到n数据中去寻找这么多元素去填补这些空位。
        // 所以，[1...n]中至少要有k-list.size()个元素。故i最多为n - (k - list.size()) + 1
        for (int i = start; i <= n - (k - list.size()) + 1; i++) {
//        for (int i = start; i <= n; i++) {

            list.add(i);
            generateCombinations(n, k, i + 1, list);
            list.remove((Integer) i);
        }
        return;
    }


    ArrayList<Integer> chosen; // 被选择的数
    public List<List<Integer>> combine1(int n, int k) {
        res = new ArrayList<>();
        list = new ArrayList<>();

        if (n <= 0 || k <= 0 || n < k) {
            return res;
        }

        calc(n, k, 1, list);
        return res;
    }

    // 求解C(n, k)，当前已经找到的组合存储在list中，需要从start开始搜索新的元素
    private void calc(int n, int k, int start, List<Integer> list) {

        System.out.println(start + ":" + list + "i<=" + (n - (k - list.size()) + 1));
        if (k == list.size()) {
            res.add(new ArrayList<>(list));
            return;
        }

        // 还有k-list.size()个空位，则下面要从start到n数据中去寻找这么多元素去填补这些空位。
        // 所以，[1...n]中至少要有k-list.size()个元素。故i最多为n - (k - list.size()) + 1
        for (int i = start; i <= n - (k - list.size()) + 1; i++) {
//        for (int i = start; i <= n; i++) {

            list.add(i);
//            generateCombinations1(n, k, i + 1, list);
            list.remove((Integer) i);
        }
        return;
    }

    public static void main(String[] args) {
        System.out.println(new CombinationsSolution().combine(4, 2));
    }
}
