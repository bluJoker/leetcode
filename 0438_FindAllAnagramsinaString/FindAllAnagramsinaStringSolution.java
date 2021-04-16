import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllAnagramsinaStringSolution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> resList = new ArrayList<>();

        int[] pFreq = new int[26];

        for (int i = 0; i < p.length(); i++) {
            pFreq[p.charAt(i) - 'a']++;
        }

        int start = 0;
        int end = -1;

        while (start < s.length()) {
            if ((end + 1 < s.length()) && (end - start + 1 < p.length())) {
                end++;
            } else {
                start++;
            }

            if ((end - start + 1 == p.length()) && isAnagrams(s.substring(start, end + 1), pFreq)) {
                resList.add(start);
            }
        }

        return resList;
    }

    private boolean isAnagrams(String subString, int[] pFreq) {
        int[] subFreq = new int[26];
        for (int i = 0; i < subString.length(); i++) {
            subFreq[subString.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (subFreq[i] != pFreq[i]) {
                return false;
            }
        }
        return true;
    }

    // 解法2：labuladong
    public List<Integer> findAnagrams1(String s, String p) {
        List<Integer> resList = new ArrayList<>();

        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> need = new HashMap<>();
        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int l = 0;
        int r = 0;
        int valid = 0;
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

            // 滑动窗口[l...r)
            while (r - l >= p.length()) {
                if (valid == need.size()) {
                    resList.add(l);
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

        return resList;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(new FindAllAnagramsinaStringSolution().findAnagrams1(s, p));
    }
}
