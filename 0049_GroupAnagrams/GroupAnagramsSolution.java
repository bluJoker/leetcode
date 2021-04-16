import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagramsSolution {

    // Leetcode官方解法1
    // 当且仅当它们的排序字符串相等时，两个字符串是字母异位词。
    //
    // 时间复杂度：O(NKlogK)，其中 N 是 strs 的长度，而 K 是 strs 中字符串的最大长度，
    // 当我们遍历每个字符串时，外部循环具有的复杂度为 O(N)。然后，我们在 O(KlogK) 的时间内对每个字符串排序。
    //
    // 空间复杂度：O(NK)，排序存储在 ans 中的全部信息内容。
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        //维护一个映射 ans : {String -> List}，其中每个键 K 是一个排序字符串，每个值是初始输入的字符串列表，排序后等于 K。
        Map<String, List<String>> res = new HashMap<>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!res.containsKey(key)) {
                res.put(key, new ArrayList());
            }
            res.get(key).add(s);
        }

        //Collection<V> values()
        //Returns a Collection view of the values contained in this map.
        return new ArrayList<>(res.values());
    }

    // stream1:
    public List<List<String>> groupAnagrams1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        return new ArrayList<>(Arrays.stream(strs)
                .collect(Collectors.groupingBy(str -> {
                    // 返回 str 排序后的结果。
                    // 按排序后的结果来grouping by，算子类似于 sql 里的 group by。
                    // https://leetcode-cn.com/problems/group-anagrams/solution/kan-wo-yi-ju-hua-ac-zi-mu-yi-wei-ci-fen-yrnis/
                    char[] array = str.toCharArray();
                    Arrays.sort(array);
                    System.out.println("array=" + Arrays.toString(array));
                    return new String(array);
                })).values());
    }


    public static void main(String[] args) {
        String[] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};

        System.out.println(new GroupAnagramsSolution().groupAnagrams1(strings));
    }

}
