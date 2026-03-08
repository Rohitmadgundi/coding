import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

public class StringManipulation {

    public static String reverseIndivisualWordsInAString(String str){

        //1 . Stream API Approach

        return Arrays.stream(str.split(" "))
                .map(word -> new StringBuilder(word).reverse().toString())
                .collect(Collectors.joining());
    }

    public static boolean validParenthesis(String str){

        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()){
            if (ch == '(')
                stack.push(')');
            else if (ch == '[')
                stack.push(']');
            else if (ch == '{')
                stack.push('}');
            else if( stack.isEmpty() || stack.pop() != ch)
                return false;
        }

        return stack.isEmpty();
    }

    public static String reverseString(String str){

        char[] chars = str.toCharArray();

        int left = 0,right = str.length() - 1;

        while (left < right){
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }

        return String.valueOf(chars);

    }

    public static void main(String[] args) {

        String str = "rohit madgundi";

        System.out.println(reverseString(str));

        //ValidParenthesis
        // ()[]{}

        System.out.println(validParenthesis("()[]{}"));

    }

}
