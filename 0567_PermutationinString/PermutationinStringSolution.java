import java.util.HashMap;

public class PermutationinStringSolution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        //[l...r)
        int l = 0;
        int r = 0;
        int valid = 0;
        while (r < s2.length()) {
            char c = s2.charAt(r);
            r++;

            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            // 本题移动 left 缩⼩窗⼝的时机是窗⼝⼤⼩⼤于 t.size() 时，应为排列嘛，显然⻓度应该是⼀样的。
            while (r - l >= s1.length()) {
                if (valid == need.size()) {
                    return true;
                }

                char d = s2.charAt(l);
                l++;

                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        String s3 = "ab";
        String s4 = "eidboaoo";

        System.out.println(new PermutationinStringSolution().checkInclusion(s1, s2));
        System.out.println(new PermutationinStringSolution().checkInclusion(s3, s4));
    }
}
