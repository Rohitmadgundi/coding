public class PrimeNumber {

    public static String reduceString(String s) {
        StringBuilder stack = new StringBuilder();

        for (char c : s.toCharArray()) {
            int length = stack.length();
            if (length > 0 && stack.charAt(length - 1) == c) {
                stack.deleteCharAt(length - 1);
            } else {
                stack.append(c);
            }
        }

        String result = stack.toString();
        return result.isEmpty() ? "Empty String" : result;
    }


    public static boolean isPrime(int number){

        for (int i = 2; i < Math.sqrt(number); i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(reduceString("abba"));

    }
}
