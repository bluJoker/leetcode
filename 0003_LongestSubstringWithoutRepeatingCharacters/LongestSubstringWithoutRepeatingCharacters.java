import java.util.HashSet;
import java.util.Set;

/**
 * 滑动窗口
 * <p>
 * 暴力解法时，内循环相当于右指针每次从左指针下一位开始右移
 * <p>
 * 滑动窗口解法中右指针不会从已遍历过的元素再开始，而是一直右移。因为：
 * 假设我们选择字符串中的第 k 个字符作为起始位置，并且得到了不包含重复字符的最长子串的结束位置为
 * Tk。那么当我们选择第 k+1 个字符作为起始位置时，首先从 k+1 到 Tk​ 的字符显然是不重复的，
 * 并且由于少了原本的第 k 个字符，我们可以尝试继续增大 Tk​，直到右侧出现了重复字符为止。
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

//        int start = 0;  // 左指针初始位置
//        int end = 0;    // 右指针初始位置
//        Set<Character> set = new HashSet<>();
//        set.add(s.charAt(0)); // 先把第0个字符放入Set
//        int maxSum = 0;
//        while (start < s.length()) {
//            // 先判断长度，再判断是否包含字符，避免越界
//            // end初始位置是0，0号字符已被加入集合，从下一个字符开始计算
//            while (end + 1 < s.length() && !set.contains(s.charAt(end + 1))) {
//                set.add(s.charAt(end + 1));
//                end++;
//            }
//            maxSum = Math.max(maxSum, end - start + 1);
//
//            if (end + 1 >= s.length()) {  // 右指针移动到最后，可以终止计算，不需要再循环
//                break;
//            }
//
//            // 左指针右移，并将元素从hash表中移除
//            set.remove(s.charAt(start));
//            start++;
//        }
//        return maxSum;


        // bobobo:
//        int[] freq = new int[256];
//        int l = 0;
//        int r = -1;
//        int res = 0;
//
//        while (l < s.length()){
//            if (r+1 < s.length() && freq[s.charAt(r+1)] == 0){
//                freq[s.charAt(++r)]++;
//            }else {
//                freq[s.charAt(l++)]--;
//            }
//            res = Math.max(res, r-l+1);
//        }
//        return res;


        int l = 0;
        int r = -1;
        int res = 0;
        Set<Character> set = new HashSet<>();

        while (l < s.length()) {
            if (r + 1 < s.length() && !set.contains(s.charAt(r + 1))) {
                set.add(s.charAt(++r));
            } else {
                set.remove(s.charAt(l++));
            }
            //此时滑动窗口中已经不包含重复字符了，因为如果包含不会扩展右边界。
            res = Math.max(res, r - l + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters
                = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(s));
    }
}
