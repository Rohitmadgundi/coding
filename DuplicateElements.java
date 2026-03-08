import java.util.HashSet;

public class DuplicateElements {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 4, 1,22, 22, 12};

        HashSet<Integer> set = new HashSet<>();

        for (int i : arr) {

            if (!set.add(i))
                System.out.println(i);
        }
    }
}
