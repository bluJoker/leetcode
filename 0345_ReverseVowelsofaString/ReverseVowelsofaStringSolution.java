import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsofaStringSolution {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {

            while (l < r && !isVowel(chars[l])) {
                l++;
            }

            while (l < r && !isVowel(chars[r])) {
                r--;
            }

            if (l < r) {
                char tmp = chars[l];
                chars[l] = chars[r];
                chars[r] = tmp;

                l++;
                r--;
            }
        }
        return new String(chars);
    }

    /**
     * @param c 用于判断的字符
     * @return 元音字母返回true 不是返回false;
     */
    private boolean isVowel(char c) {
        switch (c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "leetcode";

        System.out.println(new ReverseVowelsofaStringSolution().reverseVowels(s1));
        System.out.println(new ReverseVowelsofaStringSolution().reverseVowels(s2));
    }
}
