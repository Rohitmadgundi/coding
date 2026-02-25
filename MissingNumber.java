import java.util.Arrays;

public class MissingNumber {

    public static int findMissingNumber(int[] arr,int n){
        int missingNumber = 0;

        int expected_sum = (n * (n + 1)) / 2;
        int actual_sum = 0;

        for (int j : arr) {
            actual_sum += j;
        }

        missingNumber = expected_sum - actual_sum;

        return missingNumber;
    }

    public static void main(String[] args) {

        int[] arr = {1, 3, 4, 5, 6};
        System.out.println("missing number in the array " + Arrays.toString(arr));
        System.out.println(findMissingNumber(arr,6));
    }
}
