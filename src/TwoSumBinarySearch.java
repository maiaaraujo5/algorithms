import java.util.Arrays;

public class TwoSumBinarySearch {
    public static void main(String[] args) {
        int[] array = new int[]{0, 0, 3, 4};
        int[] result = twoSum(array, 0);
        System.out.println(Arrays.toString(result));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            int sum = numbers[start] + numbers[end];

            if (sum == target) {
                break;
            } else if (sum < target) {
                if (numbers[mid] + numbers[end] < target) {
                    start = mid;
                } else {
                    start = mid + 1;
                }
            } else {
                if (numbers[mid] + numbers[start] > target) {
                    end = mid;
                } else {
                    end = end - 1;
                }
            }
        }

        if (start < end) {
            return new int[]{start + 1, end + 1};
        } else {
            return new int[]{end + 1, start + 1};
        }
    }
}
