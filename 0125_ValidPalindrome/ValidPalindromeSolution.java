public class ValidPalindromeSolution {

    public boolean isPalindrome(String s) {

        if (s == null){
            return false;
        }

        int i = 0;
        int j = s.length()-1;

        while (i < j){
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }

            if (i < j){ // 可省略
                if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))){
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String s1 = "A man, a plan, a canal: Panama";
        String s2 = "race a car";

        ValidPalindromeSolution validPalindromeSolution = new ValidPalindromeSolution();
        System.out.println(validPalindromeSolution.isPalindrome(s1));
        System.out.println(validPalindromeSolution.isPalindrome(s2));


    }
}
