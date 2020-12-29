import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsofaPhoneNumberSolution {

    private String[] letterMap = {
            " ",    //0
            "",     //1
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9
    };

    private ArrayList<String> res;

    public List<String> letterCombinations(String digits) {

        res = new ArrayList<>();
        if (digits == null || digits.equals("")) {
            return res;
        }

        letterCombinations(digits, 0, "");
        return res;
    }

    // s中保存了此时从digits[0...index-1]翻译得到的一个字母字符串
    // 寻找和digits[index]匹配的字母, 获得digits[0...index]翻译得到的解
    private void letterCombinations(String digits, int index, String s) {

        System.out.println(index + " : " + s);
        if (index == digits.length()) {
            // 此时就得到了一个解
            res.add(s);
            System.out.println("get " + s + " , return");
            return;
        }

        char c = digits.charAt(index);

        String letters = letterMap[c - '0'];
        for (int i = 0; i < letters.length(); i++) {
            System.out.println("digits[" + index + "] = " + c +
                    " , use " + letters.charAt(i));
            letterCombinations(digits, index + 1, s + letters.charAt(i));
        }

        System.out.println("digits[" + index + "] = " + c + " complete, return");

        return;
    }

    public static void main(String[] args) {
        String digits = "23";
        System.out.println(new LetterCombinationsofaPhoneNumberSolution().letterCombinations(digits));
    }
}
