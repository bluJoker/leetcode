import java.util.HashMap;
import java.util.HashSet;

public class IsomorphicStringsSolution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }

        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (map.containsKey(c1)){
                if (map.get(c1) != c2){
                    return false;
                }
            }else {
                if (set.contains(c2)){
                    return false;
                }
                map.put(c1, c2);
                set.add(c2);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s1 = "egg", t1 = "add";
        String s2 = "badc", t2 = "baba";
        String s3 = "paper", t3 = "title";
//        System.out.println(new IsomorphicStringsSolution().isIsomorphic(s1, t1));
        System.out.println(new IsomorphicStringsSolution().isIsomorphic(s2, t2));
//        System.out.println(new IsomorphicStringsSolution().isIsomorphic(s3, t3));

    }
}
