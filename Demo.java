
public class Demo{

    public static boolean isPalindrome(String str){

        if (str == null)
            return false;

        int left = 0;
        int right = str.length() - 1;

        while (left < right){
            if (str.charAt(left) != str.charAt(right))
                return false;

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {

        String s1 = "rohit";
        String s2 = "madam";

        System.out.println(s1 + " = " + isPalindrome(s1));
        System.out.println(s2 + " = " + isPalindrome(s2));

    }
}
