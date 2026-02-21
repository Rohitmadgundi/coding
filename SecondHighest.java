import java.util.*;

public class SecondHighest {

    public static Integer getSecondHighestNumber(List<Integer> list){

        // 1 - Simple approach does not work for duplicates
//        Collections.sort(list);
//        return list.get(list.size() - 2);

        // 2 - Stream Api Approach

//        int value = list.stream()
//                .distinct()
//                .sorted(Comparator.reverseOrder())
//                .skip(1)
//                .findFirst()
//                .orElse(null);
//
//        return value;

        // 3 - Optimized approach O(n) time

        if (list == null || list.size() < 2)
            return -1;

        Integer first = null, second = null;

        for (Integer num : list){
            if (first == null || num > first){
                second = first;
                first = num;
            }

            else if ((second == null || num > second) && !num.equals(first))
                second = num;


        }

        return second;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10,5,56,1,0,67);

        Integer secondHighestNumber = getSecondHighestNumber(list);

        System.out.println("second highest number in a list " + list);
        System.out.println(secondHighestNumber);
    }
}
