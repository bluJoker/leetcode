import java.util.Arrays;

public class ReverseStringSolution {


    public void reverseString(char[] s) {
        if (s == null || s.length == 0){
            return;
        }

        int i = 0;
        int j = s.length-1;
        while (i < j){
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            i++;
            j--;
        }
    }


    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        new ReverseStringSolution().reverseString(s);
        System.out.println(Arrays.toString(s));
    }
}
