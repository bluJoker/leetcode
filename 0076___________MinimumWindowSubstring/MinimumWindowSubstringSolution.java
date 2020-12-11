import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MinimumWindowSubstringSolution {
    public int minWindow(String s, String t) {
        // TODO:
//        HashMap<Character, Integer> map = new HashMap<>();
//        int l = 0;
//        int r = -1;
//        int res = s.length() + 1;
//
//        while (l < s.length()) {
//
//            if (r + 1 < s.length() && !hasAll(t, map)) {
//                r++;
//                map.put(s.charAt(r+1), map.get(s.charAt(r+1))+1);
//            } else {
//                res = Math.min(res, r - l + 1);
//                set.remove(s.charAt(l++));
//            }
//        }
//        return res;

        return -1;
    }

    private boolean hasAll(String t, Set<Character> set) {
        for (int i = 0; i < t.length(); i++) {
            if (!set.contains(t.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "ADOBECODEBANC";
        String t1 = "ABC";
        System.out.println(new MinimumWindowSubstringSolution().minWindow(s1, t1));
    }
}
