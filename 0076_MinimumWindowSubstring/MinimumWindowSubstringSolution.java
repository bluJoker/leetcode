import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MinimumWindowSubstringSolution {
    public String minWindow(String s, String t) {
        // TODO:
//        HashMap<Character, Integer> map = new HashMap<>();
//
//        for (int i = 0; i < t.length(); i++) {
//            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0)+1);
//        }
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
//
//        return -1;
//    }
//
//    private boolean hasAll(String subT, HashMap<Character, Integer> map) {
//        HashMap<Character, Integer> tmpMap = new HashMap<>();
//        for (int i = 0; i < subT.length(); i++) {
//            map.put(subT.charAt(i), map.getOrDefault(subT.charAt(i), 0)+1);
//        }
//
//        Set<Character> keySet = map.keySet();
//
//        for (char c:keySet) {
//            if (map.get(c) != )
//        }
//
//        return true;
//    }
        int[] tFreq = new int[58];
        for (int i = 0; i < t.length(); i++) {
            tFreq[t.charAt(i) - 'A']++;
        }

        int l = 0;
        int r = -1;
        int resLen = s.length() + 1;
        String res = "";

        while (l < s.length()) {
            if (r + 1 < s.length() && !hasAll(s.substring(l, r + 1), t, tFreq)) {
                r++;
            } else {
                l++;
            }

            if (r - l + 1 >= t.length() && hasAll(s.substring(l, r + 1), t, tFreq)) {
                if (r - l + 1 < resLen) {
                    resLen = r - l + 1;
                    res = s.substring(l, r + 1);
                }
            }
        }
        return res;
    }

    private boolean hasAll(String subT, String t, int[] tFreq) {
        int[] subFreq = new int[58];

        for (int i = 0; i < subT.length(); i++) {
            subFreq[subT.charAt(i) - 'A']++;
        }

        for (int i = 0; i < t.length(); i++) {
            // 易错
            // if (subFreq[t.charAt(i)-'A'] != tFreq[t.charAt(i)-'A']){
            if (subFreq[t.charAt(i) - 'A'] < tFreq[t.charAt(i) - 'A']) {
                return false;
            }
        }

        return true;
    }

    public String minWindow1(String s, String t) {
        // labuladong
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }
        int l = 0;
        int r = 0;
        int valid = 0;
        int start = 0;
        int len = s.length() + 1;

        while (r < s.length()) {
            char c = s.charAt(r);
            r++;

            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            /*** debug 输出的位置 ***/
            System.out.println("window: [" + l + ", " + r + "]");

            while (valid == need.size()) {
                // 因为此时r+1了，故不是r-l+1
                if (r - l < len) {
                    start = l;
                    len = r - l;
                }

                char d = s.charAt(l);
                l++;

                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }

        return len == s.length() + 1 ? "" : s.substring(start, start + len);
    }


    public static void main(String[] args) {
        String s1 = "ADOBECODEBANC";
        String t1 = "ABC";
//        System.out.println(new MinimumWindowSubstringSolution().minWindow1(s1, t1));

        String s2 = "bbaac";
        String t2 = "aba";
        System.out.println(new MinimumWindowSubstringSolution().minWindow1(s2, t2));

    }
}
