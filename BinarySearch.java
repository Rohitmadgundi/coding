public class BinarySearch {

    public static int binarySearch(int[] arr, int target){

        int low = 0;
        int high = arr.length - 1;

        while (low <= high){
            int mid = (low + high) / 2;

            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] arr = {1, 5, 8, 9, 33, 77, 88};
        int index = binarySearch(arr,1);

        if (index == -1)
            System.out.println("not found");
        else
            System.out.println("77 found at index : " + index);
    }
}
