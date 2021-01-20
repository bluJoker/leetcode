import java.util.Arrays;

public class LCSSolution {

//    public int longestCommonSubsequence(String text1, String text2) {
//        char[] char1 = text1.toCharArray();
//        char[] char2 = text2.toCharArray();
//
//        return LCSHelper(char1, char2, char1.length - 1, char2.length - 1);
//    }
//
//    // char1[0...index1]和char2[0...index2]的LCS长度
//    private int LCSHelper(char[] char1, char[] char2, int index1, int index2) {
//        if (index1 < 0 || index2 < 0) {
//            return 0;
//        }
//
//        if (char1[index1] == char2[index2]) {
//            return 1 + LCSHelper(char1, char2, index1 - 1, index2 - 1);
//        } else {
//            return Math.max(LCSHelper(char1, char2, index1, index2 - 1),
//                    LCSHelper(char1, char2, index1 - 1, index2));
//        }
//    }

    public int longestCommonSubsequence(String text1, String text2) {

        return LCSHelper(text1, text2, text1.length() - 1, text2.length() - 1);
    }

    // char1[0...index1]和char2[0...index2]的LCS长度
    private int LCSHelper(String text1, String text2, int m, int n) {
        if (m < 0 || n < 0) {
            return 0;
        }

        if (text1.charAt(m) == text2.charAt(n)) {
            return 1 + LCSHelper(text1, text2, m - 1, n - 1);
        } else {
            return Math.max(LCSHelper(text1, text2, m, n - 1),
                    LCSHelper(text1, text2, m - 1, n));
        }
    }

    // 记忆化搜索
    private int[][] memo;

    public int longestCommonSubsequence1(String text1, String text2) {
        memo = new int[text1.length()][text2.length()];

        for (int i = 0; i < text1.length(); i++) {
            Arrays.fill(memo[i], -1);
        }

        return LCSHelper1(text1, text2, text1.length() - 1, text2.length() - 1);
    }

    // char1[0...index1]和char2[0...index2]的LCS长度
    private int LCSHelper1(String s1, String s2, int m, int n) {
        if (m < 0 || n < 0) {
            return 0;
        }

        if (memo[m][n] != -1) {
            return memo[m][n];
        }

        if (s1.charAt(m) == s2.charAt(n)) {
            memo[m][n] = 1 + LCSHelper1(s1, s2, m - 1, n - 1);
            return memo[m][n];
        } else {
            memo[m][n] = Math.max(LCSHelper1(s1, s2, m, n - 1),
                    LCSHelper1(s1, s2, m - 1, n));
            return memo[m][n];
        }
    }

    //dp
    private int[] memo1;

    public int longestCommonSubsequence2(String text1, String text2) {
        memo1 = new int[text2.length()];

        for (int j = 0; j < text2.length(); j++) {
            if (text1.charAt(0) == text2.charAt(j)) {
                for (int i = j; i < text2.length(); i++) {
                    memo1[i] = 1;
                }
                break;
            }
        }

        for (int i = 1; i < text1.length(); i++) {
            for (int j = text2.length() - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    memo1[j] = 1 + ((j >= 1) ? memo1[j - 1] : 0);
                } else {
                    memo1[j] = Math.max(memo1[j], (j >= 1) ? memo1[j - 1] : 0);
                }
            }
        }
        return memo1[text2.length() - 1];
    }


    // 通过memo反向求解s1和s2的最长公共子序列
    private String getLCS(String s1, String s2){

        int m = s1.length() - 1;
        int n = s2.length() - 1;

        StringBuilder res = new StringBuilder("");
        while(m >= 0 && n >= 0)
            if(s1.charAt(m) == s2.charAt(n)){
                res = res.insert(0, s1.charAt(m));
                m --;
                n --;
            }
            else if(m == 0)
                n --;
            else if(n == 0)
                m --;
            else{
                if(memo[m-1][n] > memo[m][n-1])
                    m --;
                else
                    n --;
            }

        return res.toString();
    }

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "acbed";

        String text3 = "abcba";
        String text4 = "abcbcba";

        System.out.println(new LCSSolution().longestCommonSubsequence1(text1, text2));
        System.out.println(new LCSSolution().longestCommonSubsequence1(text3, text4));

    }
}
