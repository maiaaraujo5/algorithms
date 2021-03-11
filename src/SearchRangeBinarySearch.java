import java.util.Arrays;

public class SearchRangeBinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 7, 7, 8, 8, 10};
        int[] result = searchRange(arr, 8);
        System.out.println(Arrays.toString(result));
    }

    public static int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int[] result = new int[]{-1, -1};

        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] == target) {
                result[0] = mid;
                break;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        for (int i = result[0]; i < nums.length; i++) {
            if (nums[i] == target) {
                result[1] = i;
            } else {
                break;
            }
        }


        return result;
    }
}
