import java.util.HashMap;
import java.util.Map;

public class ValidAnagramSolution {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
//
//        HashMap<Character, Integer> map = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            if (map.containsKey(s.charAt(i))) {
//                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
//            } else {
//                map.put(s.charAt(i), 1);
//            }
//        }
//
//        for (int i = 0; i < t.length(); i++) {
//            if (!map.containsKey(t.charAt(i))) {
//                return false;
//            }
//            map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
//            if (map.get(t.charAt(i)) < 0) {
//                return false;
//            }
//        }
//        return true;



        // 使用数组代替hash表更好，因为仅限制小写字母26
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            hash[t.charAt(i) - 'a']--;
            if (hash[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }

//        for (int i : hash){
//            if (i < 0){
//                return false;
//            }
//        }
        return true;
    }


    public static void main(String[] args) {
        String s1 = "anagram";
        String t1 = "nagaram";
        String s2 = "rat";
        String t2 = "car";
        System.out.println(new ValidAnagramSolution().isAnagram(s1, t1));
        System.out.println(new ValidAnagramSolution().isAnagram(s2, t2));

    }
}
