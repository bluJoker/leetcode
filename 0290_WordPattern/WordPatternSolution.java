import java.util.HashMap;
import java.util.HashSet;

public class WordPatternSolution {
    public boolean wordPattern(String pattern, String s) {
        String[] strs = s.split(" ");
        if (pattern.length() != strs.length) {
            return false;
        }

        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (map.containsKey(c)) {
                if (!map.get(c).equals(strs[i])) {
                    return false;
                }
            } else {
                // map中不存在pattern[i]的字符，则看对应的strs[i]是否在set中，在表示不同的key对应了相同的value
                if (set.contains(strs[i])) {
                    return false;
                }
                map.put(c, strs[i]);
                set.add(strs[i]);
            }
        }
        return true;
    }

    // 双射法：
    public boolean wordPattern1(String pattern, String s) {
        String[] strs = s.split(" ");
        if (pattern.length() != strs.length) {
            return false;
        }

        HashMap<Character, String> map1 = new HashMap<>();
        HashMap<String, Character> map2 = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if ((map1.containsKey(c) && !map1.get(c).equals(strs[i])
                    || (map2.containsKey(strs[i]) && map2.get(strs[i]) != c))) {
                return false;
            }
            map1.put(c, strs[i]);
            map2.put(strs[i], c);
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern = "abba";
        String str = "dog cat cat dog";
        System.out.println(new WordPatternSolution().wordPattern1(pattern, str));

        String pattern2 = "abba", str2 = "dog cat cat fish";
        System.out.println(new WordPatternSolution().wordPattern1(pattern2, str2));

        String pattern3 = "abba", str3 = "dog dog dog dog";
        System.out.println(new WordPatternSolution().wordPattern1(pattern3, str3));

    }
}
