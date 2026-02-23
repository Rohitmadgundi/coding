import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] getTwoSumIndices(int[] nums, int target){

        int x = 0;

        Map<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            x = target - nums[i];
            if (seen.containsKey(x))
                return new int[]{i, seen.get(x)};

            seen.put(nums[i],i);
        }

        return new int[]{};
    }

    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};

        int[] res = getTwoSumIndices(nums, 9);

        System.out.println(Arrays.toString(res));

    }
}
